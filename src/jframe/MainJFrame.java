package jframe;

import event.EventGui;
import jframe.buttons.JButtonGui;

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
        eventGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        eventGui.setSize(500,100);
        eventGui.setVisible(true);

        JButtonGui buttonGui = new JButtonGui();
        buttonGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonGui.setSize(300, 100);
        buttonGui.setVisible(true);
    }
}
