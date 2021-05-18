package net.davoleo.javagui.forms.controls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 18/12/2018 / 12:27
 * Class: JButtonGui
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2018
 **************************************************/

public class JButtonGui extends JFrame {

    private JButton reg;
    private JButton custom;

    public JButtonGui()
    {
        super("Buttons");
        setLayout(new FlowLayout());

        //Creating some Icons and init them using the images from the resources folder
        Icon icon1 = new ImageIcon(getClass().getResource("../../../../resources/40x40.png"));
        Icon icon2 = new ImageIcon(getClass().getResource("../../../../resources/ingot_blue.png"));

        //Init buttons
        reg = new JButton("Reg Button");
        custom = new JButton("Custom", icon1);
        //Setting a Icon for when the user hovers the mouse over the button
        custom.setRolloverIcon(icon2);

        //Adding buttons to the GUI
        add(reg);
        add(custom);

        //Listener init & Adding a listener to the buttons
        JButtonHandler handler = new JButtonHandler();
        reg.addActionListener(handler);
        custom.addActionListener(handler);
    }

    private class JButtonHandler implements ActionListener {

        //TRIGGERED When the buttons are clicked
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(null, e.getActionCommand());
        }
    }

}
