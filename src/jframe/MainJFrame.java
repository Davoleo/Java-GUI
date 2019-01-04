package jframe;

import event.EventGui;
import jframe.controls.*;

import javax.swing.*;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 02/12/2018 / 00:17
 * Class: MainJFrame
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2018
 **************************************************/

public class MainJFrame {

    public static void main(String[] args)
    {
        JFrameGui gui = new JFrameGui();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(200,100);
        gui.setVisible(true);


        EventGui eventGui = new EventGui();
        eventGui.setSize(500,100);
        eventGui.setVisible(true);

        JButtonGui buttonGui = new JButtonGui();
        buttonGui.setSize(300, 100);
        buttonGui.setVisible(true);

        JCheckboxGui checkboxGui = new JCheckboxGui();
        checkboxGui.setSize(270, 100);
        checkboxGui.setVisible(true);

        JRadioButtonGui radioButtonGui = new JRadioButtonGui();
        radioButtonGui.setSize(300, 100);
        radioButtonGui.setVisible(true);

        JComboboxGui comboboxGui = new JComboboxGui();
        comboboxGui.setSize(300, 100);
        comboboxGui.setVisible(true);

        JListGui listGui = new JListGui();
        listGui.setSize(100, 200);
        listGui.setVisible(true);

    }
}
