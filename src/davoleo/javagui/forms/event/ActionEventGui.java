package davoleo.javagui.forms.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 07/12/2018 / 20:26
 * Class: EventHandler
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2018
 **************************************************/

public class ActionEventGui extends JFrame {

    private Container content = getContentPane();
    private JTextField textBox1;
    private JTextField textBox2;
    private JTextField textBox3;
    private JPasswordField pwBox;
    private JButton backgroundButton;

    public ActionEventGui()
    {
        super("Event Handlers");
        setLayout(new FlowLayout());

        //Component initialization
        textBox1 = new JTextField(10);
        textBox2 = new JTextField("enter text here...");
        textBox3 = new JTextField("uneditable", 20);
        pwBox = new JPasswordField("my P455w0rd");
        backgroundButton = new JButton("Event Button");

        //Adding components to the window
        add(textBox1);
        add(textBox2);
        add(textBox3);
        add(pwBox);
        add(backgroundButton);

        //Setting the third textbox as read-only
        textBox3.setEditable(false);

        //Event Listener
        Handler handler = new Handler();
        textBox1.addActionListener(handler);
        textBox2.addActionListener(handler);
        textBox3.addActionListener(handler);
        pwBox.addActionListener(handler);
        backgroundButton.addActionListener(handler);

    }

    private class Handler implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String result = "";

            if(e.getSource() == textBox1)
                result = String.format("field 1: %s", e.getActionCommand());
            else if(e.getSource() == textBox2)
                result = String.format("field 2: %s", e.getActionCommand());
            else if(e.getSource() == textBox2)
                result = String.format("field 2: %s", e.getActionCommand());
            else if(e.getSource() == pwBox)
                result = String.format("password field is: %s", e.getActionCommand());

            if (e.getSource() == backgroundButton)
                content.setBackground(Color.magenta);
            else
                JOptionPane.showMessageDialog(null, result);
        }

    }

}
