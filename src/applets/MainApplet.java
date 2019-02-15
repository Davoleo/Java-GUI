package applets;

import javax.swing.*;
import java.awt.*;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 15/02/2019 / 17:38
 * Class: MainApplet
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class MainApplet extends JApplet {

    private double sum;

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawString("is this applet?", 25, 25);

        g.drawString("The sum is: " + sum, 25, 40);
    }

    @Override
    public void init()
    {
        String s1 = JOptionPane.showInputDialog("Enter the first number");
        String s2 = JOptionPane.showInputDialog("Enter the second number");

        double n1 = Double.parseDouble(s1);
        double n2 = Double.parseDouble(s2);

        sum = n1 + n2;

    }
}