package swing.jframe.layouts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 16/01/2019 / 21:10
 * Class: FormFlowLayout
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2018
 **************************************************/

public class FormFlowLayout {
    private JPanel panel1;
    private JLabel userLabel;
    private JTextField userBox;
    private JLabel passwordLabel;
    private JPasswordField passwordBox;
    private JButton submitButton;

    public FormFlowLayout()
    {

        panel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                //submitButton.setPreferredSize(new Dimension(50, 50));
                submitButton.setSize(50, 50);
            }
        });
    }

    public JPanel getPanel1()
    {
        return panel1;
    }
}
