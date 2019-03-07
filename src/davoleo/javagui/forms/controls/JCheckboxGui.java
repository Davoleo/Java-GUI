package davoleo.javagui.forms.controls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 02/01/2019 / 15:11
 * Class: JCheckboxGui
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2018
 **************************************************/

public class JCheckboxGui extends JFrame {

    private JTextField textBox;
    private JCheckBox boldBox;
    private JCheckBox italicBox;

    public JCheckboxGui()
    {
        super("Checkboxes");
        setLayout(new FlowLayout());

        textBox = new JTextField("This is a textbox", 20);
        textBox.setFont(new Font("Serif", Font.PLAIN, 14));
        add(textBox);

        boldBox = new JCheckBox("Bold");
        italicBox = new JCheckBox("Italic");
        add(boldBox);
        add(italicBox);

        JCheckboxHandler handler = new JCheckboxHandler();
        boldBox.addItemListener(handler);
        italicBox.addItemListener(handler);

    }

    private class JCheckboxHandler implements ItemListener
    {
        @Override
        public void itemStateChanged(ItemEvent e)
        {
            Font font = null;

            if(boldBox.isSelected() && italicBox.isSelected())
                font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
            else if (boldBox.isSelected())
                font = new Font("Serif", Font.BOLD, 14);
            else if (italicBox.isSelected())
                font = new Font("Serif", Font.ITALIC, 14);
            else
                textBox.setFont(new Font("Serif", Font.PLAIN, 14));

            textBox.setFont(font);

        }
    }


}
