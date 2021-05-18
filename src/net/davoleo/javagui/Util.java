package net.davoleo.javagui;

import javax.swing.*;
import java.awt.*;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 07/03/2019 / 18:47
 * Class: Util
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class Util {

    public static void pause(int seconds)
    {
        try {
            Thread.sleep(seconds*1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void runIOBoxes()
    {
        //Some super-simple sum program (Just using Swing input and output dialogs)

        String fn = JOptionPane.showInputDialog("Enter first number");
        String sn = JOptionPane.showInputDialog("Enter second number");

        try {
            int num1 = Integer.parseInt(fn);
            int num2 = Integer.parseInt(sn);
            int sum = num1 + num2;
            JOptionPane.showMessageDialog(null,"The sum of " + num1 + " and " + num2 + " is equals to " + sum,"Rouxls Kaard", JOptionPane.PLAIN_MESSAGE);
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "devi per forza rompere il cazzo?", "MA SEI STUPIDO??", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static Point centerScreen(int formWidth, int formHeight)
    {
        return new Point((Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (formWidth / 2), Toolkit.getDefaultToolkit().getScreenSize().height / 2 - (formHeight / 2));
    }
}
