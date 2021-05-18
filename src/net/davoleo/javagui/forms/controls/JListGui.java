package net.davoleo.javagui.forms.controls;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 04/01/2019 / 15:47
 * Class: JListGui
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2018
 **************************************************/

public class JListGui extends JFrame {

    private JList list;

    private static String[] colornames = {"black", "blue", "red", "white", "cyan", "yellow"};
    private static Color[] colors = {Color.BLACK, Color.BLUE, Color.RED, Color.WHITE, Color.CYAN, Color.YELLOW};

    public JListGui()
    {
        super("JList");
        setLayout(new FlowLayout());

        list = new JList(colornames);
        list.setVisibleRowCount(6);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(list));

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                getContentPane().setBackground(colors[list.getSelectedIndex()]);
            }
        });
    }

}