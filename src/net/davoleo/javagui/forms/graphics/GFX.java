package net.davoleo.javagui.forms.graphics;

import javax.swing.*;
import java.awt.*;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 30/01/2019 / 20:52
 * Class: GFX
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2018
 **************************************************/

public class GFX extends JPanel {

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        g.setColor(Color.BLUE);
        g.fillRect(25, 25, 100, 30);

        g.setColor(new Color(190, 81, 215));
        g.fillRect(25, 65, 100, 30);

        g.setColor(Color.RED);
        g.drawString("THIS IS A DRAWN STRING", 25, 120);

        g.setColor(Color.GREEN);
        g.drawLine(25, 140, 100, 200);

        g.setColor(Color.black);
        g.drawRect(25, 220, 100, 30);

        g.setColor(Color.PINK);
        g.fillOval(25, 260, 100, 30);

        g.setColor(Color.ORANGE);
        g.fill3DRect(25, 300, 100, 50, true);
    }
}
