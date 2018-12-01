package jframe;

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
        gui.setSize(300,300);
        gui.setVisible(true);
    }
}
