package net.davoleo.javagui.forms.layouts;

import javax.swing.*;
import java.awt.*;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 16/01/2019 / 20:34
 * Class: FormAbsoluteLayout
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2018
 **************************************************/

public class FormAbsoluteLayout extends JFrame {

    private JLabel userLabel, passwordLabel;
    private JTextField userBox;
    private JPasswordField passwordBox;
    private JButton submitButton;

    public FormAbsoluteLayout()
    {
        super("Absolute Layout Example!");
        setLayout(null);
        setResizable(false);

        userLabel = new JLabel("User: ");
        passwordLabel = new JLabel("Password: ");

        userBox = new JTextField();
        passwordBox = new JPasswordField();

        submitButton = new JButton("LOGIN");

        add(userLabel); add(passwordLabel);
        add(userBox); add(passwordBox);
        add(submitButton);

        Insets insets = getInsets();

        Dimension size = userLabel.getPreferredSize();
        userLabel.setBounds(5 + insets.left, 5 + insets.top, size.width, size.height);
        size = passwordLabel.getPreferredSize();
        passwordLabel.setBounds(5 + insets.left, 30 + insets.top, size.width, size.height);
        size = userBox.getPreferredSize();
        userBox.setBounds(80 + insets.left, 5 + insets.top, size.width + 100, size.height);
        size = passwordBox.getPreferredSize();
        passwordBox.setBounds(80 + insets.left, 30 + insets.top, size.width + 100, size.height);
        size = submitButton.getPreferredSize();
        submitButton.setBounds(80 + insets.left, 60 + insets.top, size.width, size.height);
    }

}
