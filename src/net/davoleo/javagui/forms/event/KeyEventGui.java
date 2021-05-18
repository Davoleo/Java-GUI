package net.davoleo.javagui.forms.event;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 07/01/2019 / 19:48
 * Class: KeyEventGui
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2018
 **************************************************/

public class KeyEventGui extends JFrame {

    private JTextField textbox, textbox2;

    public KeyEventGui()
    {
        super("Keyboard Events!");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        textbox = new JTextField();
        textbox2 = new JTextField();

        //KeyListener (Interface)
        //Per intercettare i tasti premuti, ti costringe a implementare tutti e tre i metodi
        textbox.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e)
            { }

            @Override
            public void keyPressed(KeyEvent e)
            { }

            @Override
            public void keyReleased(KeyEvent e)
            {
                JTextField textbox = (JTextField) e.getSource();
                String output = textbox.getText();
                textbox.setText(output.toUpperCase());
            }
        });

        textbox2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e)
            {
                JTextField textbox = (JTextField) e.getSource();
                String output = textbox.getText();
                textbox.setText(output.toLowerCase());
            }
        });

        add(textbox);
        add(textbox2);
    }

}
