package swing;

import swing.jframe.graphics.DrawOvalGui;
import swing.jframe.graphics.Oval;
import swing.jframe.layouts.FormAbsoluteLayout;
import swing.jframe.layouts.FormBorderLayout;
import swing.jframe.layouts.FormBoxLayout;
import swing.jframe.layouts.FormFlowLayout;
import swing.practice.BrowserGui;
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

        FormAbsoluteLayout absoluteLayout = new FormAbsoluteLayout();
        absoluteLayout.setSize(200, 150);
        absoluteLayout.setVisible(true);

        JFrame flowLayout = new JFrame("Flow Layout Example!");
        flowLayout.setContentPane(new FormFlowLayout().getPanel1());
        flowLayout.pack();
        flowLayout.setVisible(true);

        JFrame designerGuiTest = new JFrame("Designer Form Test");
        designerGuiTest.setContentPane(new GuiTest().getMainPanel());
        designerGuiTest.pack();
        designerGuiTest.setVisible(true);

        DrawOvalGui ovalGui = new DrawOvalGui();
        ovalGui.pack();
        ovalGui.setVisible(true);

        BrowserGui browser = new BrowserGui();
        browser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


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
