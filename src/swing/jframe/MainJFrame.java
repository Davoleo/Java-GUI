package swing.jframe;

import swing.jframe.event.ActionEventGui;
import swing.jframe.controls.*;
import swing.jframe.event.KeyEventGui;

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


        ActionEventGui actionEventGui = new ActionEventGui();
        actionEventGui.setSize(500,100);
        actionEventGui.setVisible(true);

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

        JMultiListGui multiListGui = new JMultiListGui();
        multiListGui.setSize(350, 120);
        multiListGui.setVisible(true);

        KeyEventGui keyGui = new KeyEventGui();
        keyGui.setSize(200, 200);
        keyGui.setVisible(true);

    }
}
