package davoleo.javagui.forms.practice.messenger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 08/03/2019 / 14:42
 * Class: ServerGui
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class ServerGui extends JFrame {

    //private fields
    private JTextField userText;
    private JTextArea chat;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ServerSocket server;
    private Socket connection;

    //constructor
    public ServerGui()
    {
        super("Instant Messenger Server");

        userText = new JTextField();
        userText.setEditable(false);
        userText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                sendMessage(e.getActionCommand());
                userText.setText("");

            }
        });
        add(userText, BorderLayout.SOUTH);
        chat = new JTextArea();
        add(new JScrollPane(chat));

        setSize(500, 500);
        setVisible(true);
    }

    public void startServer()
    {
        try {
            //Port: The location of the application on the server
            //Backlog: How many people can wait to enter the IM
            server = new ServerSocket(3333, 100);

            while (true)
            {
                try {
                    waitForConnection();
                    setupStreams();
                    whileChatting();
                }
                catch (EOFException e) {
                    showMessage("\n Server ended the connection! ");
                } finally {
                    close();
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //wait from connection from another compurter, then display connection info
    private void waitForConnection() throws IOException
    {
        showMessage(" Waiting for someone to connect.... \n");
        connection = server.accept();
        showMessage(" Connected to " + connection.getInetAddress().getHostName() + " \n");
    }

    //setup the stream to send and receive data
    private void setupStreams() throws IOException
    {
        //send messages to someone
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();

        //receive messages from someone
        input = new ObjectInputStream(connection.getInputStream());

        showMessage("\n Streams are now setup! \n");
    }

    //Handles the chat between users
    private void whileChatting() throws IOException
    {
        String message = " You are now connected ";
        sendMessage(message);
        setInputEnabled(true);
        do {
            //active chat until the message CLIENT - END
            try {
                message = (String) input.readObject();
                showMessage(" \n" + message + message);
            }
            catch (ClassNotFoundException e)
            {
                showMessage("\n WELCOME TO THE MALFORMED MESSAGE! (Message format unsupported)");
            }

        }while (!message.equals("CLIENT - END"));
    }

    //closes streams and sockets during shutdown
    private void close()
    {
        showMessage("\n Closing streams and sockets... \n");
        setInputEnabled(false);

        try {
            output.close();
            input.close();
            connection.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //sends a message to client
    private void sendMessage(String message)
    {
        try {
            output.writeObject("SERVER - " + message);
            output.flush();
            showMessage("\nSERVER - " + message);
        }
        catch (IOException e) {
            chat.append("\n ERROR: COULDN'T SEND THE MESSAGE");
        }
    }

    //displays messages on the GUI
    private void showMessage(final String text)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                chat.append(text);
            }
        });
    }

    //enable/disable user textbox "writability"
    private void setInputEnabled(boolean enabled)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                userText.setEditable(enabled);
            }
        });
    }
}
