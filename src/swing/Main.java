package swing;

import swing.jframe.layouts.FormBorderLayout;
import swing.jframe.layouts.FormBoxLayout;
import swing.practice.GuiTest;

import javax.swing.*;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 05/01/2019 / 14:43
 * Class: Main
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2018
 **************************************************/

public class Main {

    public static void main(String[] args)
    {
        FormBorderLayout borderLayout = new FormBorderLayout();
        borderLayout.setSize(600, 500);
        borderLayout.setVisible(true);
        borderLayout.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        FormBoxLayout boxLayout = new FormBoxLayout();
        boxLayout.setSize(350, 150);
        boxLayout.setVisible(true);


        JFrame designerGuiTest = new JFrame("Designer Form Test");
        designerGuiTest.setContentPane(new GuiTest().getMainPanel());
        designerGuiTest.pack();
        designerGuiTest.setVisible(true);


    }

    public static void pause(int seconds)
    {
        try {
            Thread.sleep(seconds*1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
