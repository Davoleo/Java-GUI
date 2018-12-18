package jframe.buttons;

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

        Icon icon1 = new ImageIcon(getClass().getResource("../../resources/40x40.png"));
        Icon icon2 = new ImageIcon(getClass().getResource("../../resources/ingot_blue.png"));

        reg = new JButton("Reg Button");
        custom = new JButton("Custom", icon1);
        custom.setRolloverIcon(icon2);

        add(reg);
        add(custom);

        JButtonHandler handler = new JButtonHandler();
        reg.addActionListener(handler);
        custom.addActionListener(handler);
    }

    private class JButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            JOptionPane.showMessageDialog(null, e.getActionCommand());
        }
    }

}
