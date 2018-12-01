package classic;

import javax.swing.*;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 01/12/2018 / 23:47
 * Class: classic.GuiBoxes
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2018
 **************************************************/

public class GuiBoxes {

    public static void main(String[] args)
    {

        String fn = JOptionPane.showInputDialog("Enter first number");
        String sn = JOptionPane.showInputDialog("Enter second number");

        int num1 = Integer.parseInt(fn);
        int num2 = Integer.parseInt(sn);
        int sum = num1 + num2;

        JOptionPane.showMessageDialog(null,"The sum of " + num1 + " and " + num2 + " is equals to " + sum,"Rouxls Kaard", JOptionPane.PLAIN_MESSAGE);

    }
}
