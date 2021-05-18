package net.davoleo.javagui.forms.controls;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 19/01/2019 / 16:54
 * Class: JTabbedPaneGui
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2018
 **************************************************/

public class JTabbedPaneGui {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JButton button1;
    private JRadioButton radioButton1;
    private JProgressBar progressBar1;
    private JCheckBox checkBox1;

    public JTabbedPaneGui()
    {
        panel1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e)
            {
                tabbedPane1.setPreferredSize(new Dimension(panel1.getWidth() - 30, 150));
            }
        });
    }

    public JPanel getPanel1()
    {
        return panel1;
    }
}
