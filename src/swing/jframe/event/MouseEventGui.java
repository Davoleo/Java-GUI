package swing.jframe.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 18/01/2019 / 18:44
 * Class: MouseEventGui
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2018
 **************************************************/

public class MouseEventGui extends JFrame {

    private JPanel mousePanel;
    private JLabel statusBar;

    public MouseEventGui()
    {
        super("Mouse Events!");

        mousePanel = new JPanel();
        mousePanel.setBackground(Color.WHITE);
        add(mousePanel, BorderLayout.CENTER);

        statusBar = new JLabel("Default");
        add(statusBar, BorderLayout.SOUTH);

        //Listener: Makes you override all the methods
        //Adapter: Lets you choose which methods to override

        mousePanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                statusBar.setText(String.format("Clicked at %d, %d", e.getX(), e.getY()));
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                statusBar.setText("The mouse button is pressed down");
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                statusBar.setText("You released the button");
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                statusBar.setText("You entered the Mouse panel");
                mousePanel.setBackground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                statusBar.setText("You left the Mouse panel");
                mousePanel.setBackground(Color.WHITE);
            }
        });

        mousePanel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                statusBar.setText("you are dragging the mouse");
            }

            @Override
            public void mouseMoved(MouseEvent e)
            {
                statusBar.setText("you moved the mouse");
            }
        });
    }

}
