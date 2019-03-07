package davoleo.javagui;

import javax.swing.*;
import java.awt.*;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 07/03/2019 / 18:52
 * Class: Main
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class Main {

    public static JFrame mainGUI;

    public static void main(String[] args)
    {
        mainGUI = new JFrame("MAIN");
        MainGui gui = new MainGui();
        mainGUI.setContentPane(gui.getContentPanel());
        mainGUI.pack();
        mainGUI.setVisible(true);
        mainGUI.setLocation(Util.centerScreen(mainGUI.getWidth(), mainGUI.getHeight()));
        mainGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
