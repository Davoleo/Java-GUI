package net.davoleo.javagui.forms.practice.messenger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 11/03/2019 / 00:15
 * Class: Client
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class Client extends JFrame {

    private JTextField userText;
    private JTextArea chat;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private String message = "";
    private String serverIP;
    private Socket connection;

    //constructor
    public Client(String host)
    {
        super("Client");
        serverIP = host;
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
        add(new JScrollPane(chat), BorderLayout.CENTER);

        setSize(500, 500);
        setVisible(true);
    }

    public void startClient()
    {
        try {
            connectToServer();
            setupStreams();
            whileChatting();
        }
        catch (EOFException e) {
            showMessage("\n Client terminated the connection");
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            close();
        }
    }

    //establish server connection
    private void connectToServer() throws IOException
    {
        showMessage("Attempting connection to the server... \n");
        connection = new Socket(InetAddress.getByName(serverIP), 3333);
        showMessage("Connection established to: " + connection.getInetAddress().getHostName());
    }

    //sets the streams up
    private void setupStreams() throws IOException
    {
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input = new ObjectInputStream(connection.getInputStream());
        showMessage("\n Streams are now setup \n");
    }

    //while completely connected to the server
    private void whileChatting() throws IOException
    {
        setInputEnabled(true);
        do {
            try {
                message = (String) input.readObject();
                showMessage("\n" + message);
            }
            catch (ClassNotFoundException e) {
                showMessage("\n WELCOME TO THE MALFORMED MESSAGE! (Message format unsupported)");
            }
        }while (!message.equals("SERVER - END"));
    }

    private void sendMessage(String s)
    {
        try {
            output.writeObject("CLIENT - " + message);
            output.flush();
            showMessage("\nCLIENT - " + message);
        }
        catch (IOException e) {
            chat.append("\n something went wrong while sending the message");
        }
    }

    //shows the message in the GUI
    private void showMessage(final String message)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                chat.append(message);
            }
        });
    }

    //Enables/Disables the textbox for the user to type
    private void setInputEnabled(final boolean enabled)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                userText.setEditable(enabled);
            }
        });
    }

    //prepare for shutdown
    private void close()
    {
        showMessage("\n Closing streams and sockets...");
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
}