package net.davoleo.javagui.games.input;

import net.davoleo.javagui.games.Core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 04/09/2019 / 23:58
 * Class: MouseLook
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class MouseLook extends Core implements MouseMotionListener, KeyListener {

    public static void main(String[] args) {
        new MouseLook().run();
    }

    private Image background;
    private Robot robot;
    private Point mousePos;
    private Point centerPos;
    private Point bgPos;
    private boolean centering;

    @Override
    public void init() {

        super.init();
        mousePos = new Point();
        centerPos = new Point();
        bgPos = new Point();
        centering = false;

        try {
            robot = new Robot();
            recenterMouse();
            mousePos.x = centerPos.x;
            mousePos.y = centerPos.y;
        } catch (AWTException e) {
            e.printStackTrace();
        }

        Window window = screenManager.getFullScreenWindow();
        window.addMouseMotionListener(this);
        window.addKeyListener(this);
        background = new ImageIcon(getClass().getResource("../../../../resources/forest_bg.jpg")).getImage();

    }

    @Override
    public synchronized void paint(Graphics2D graphics) {

        int width = screenManager.getWidth();
        int height = screenManager.getHeight();

        //if bg x is less than width it's gonna output bg x, else if bg x is more than width it's gonna output how much it overlaps
        bgPos.x %= width;
        bgPos.y %= height;

        if (bgPos.x < 0)
            bgPos.x += width;

        if (bgPos.y < 0)
            bgPos.y += height;

        graphics.drawImage(background, bgPos.x, bgPos.y, null);
        graphics.drawImage(background, bgPos.x - width, bgPos.y, null);
        graphics.drawImage(background, bgPos.x, bgPos.y - height, null);
        graphics.drawImage(background, bgPos.x - width, bgPos.y - height, null);

    }

    private synchronized void recenterMouse() {
        Window window = screenManager.getFullScreenWindow();

        if (robot != null && window.isShowing())
        {
            centerPos.x = window.getWidth() / 2;
            centerPos.y = window.getHeight() / 2;
            SwingUtilities.convertPointToScreen(centerPos, window);
            centering = true;
            robot.mouseMove(centerPos.x, centerPos.y);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            quit();
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseMoved(e);
    }

    @Override
    public synchronized void mouseMoved(MouseEvent e) {
        if (centering && centerPos.x == e.getX() && centerPos.y == e.getY())
            centering = false;
        else {
            int dx = e.getX() - mousePos.x;
            int dy = e.getY() - mousePos.y;
            bgPos.x += dx;
            bgPos.y += dy;
            recenterMouse();
        }

        mousePos.x = e.getX();
        mousePos.y = e.getY();
    }
}
