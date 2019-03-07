package swing.jframe.graphics.oval;

import javax.swing.*;
import java.awt.*;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 20/02/2019 / 20:26
 * Class: Oval
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class Oval extends JPanel {

    private int d =  10;

    /**
     * Paints the circle/oval on the screen
     */
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.fillOval(10, 10, d, d);
    }

    public void setD(int d)
    {
        if (d > 0)
            this.d = d;

        //repaints everything in paintComponent
        repaint();
    }

    /**
     * Used by the layout manager to determine the preferred size of the panel
     * @return The dimension of the panel
     */
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(200, 200);
    }

    /**
     * Used by the layout manager to determine the minimum size of the panel
     * @return The same value as (@Link #getPreferredSize)
     */
    @Override
    public Dimension getMinimumSize()
    {
        return getPreferredSize();
    }
}