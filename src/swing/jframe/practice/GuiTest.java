package swing.jframe.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 07/01/2019 / 20:31
 * Class: GuiTest
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2018
 **************************************************/

public class GuiTest {
    private JPanel mainPanel;
    private JButton button1;

    public GuiTest()
    {
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e)
            {
                ((JButton)e.getSource()).setBackground(Color.GREEN);
            }
        });
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e)
            {
                ((JButton)e.getSource()).setBackground(Color.WHITE);
            }
        });
    }

    public JPanel getMainPanel()
    {
        return mainPanel;
    }
}
