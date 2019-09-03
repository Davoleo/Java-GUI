package davoleo.javagui.games.input;

import davoleo.javagui.games.Core;

import java.awt.*;
import java.awt.event.*;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 03/09/2019 / 19:16
 * Class: MouseTest
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class MouseTest extends Core implements MouseMotionListener, MouseListener, MouseWheelListener, KeyListener {

    private String mess = "";

    public static void main(String[] args) {
        new MouseTest().run();
    }

    //init
    @Override
    public void init() {
        super.init();
        Window window = screenManager.getFullScreenWindow();
        window.addMouseListener(this);
        window.addMouseMotionListener(this);
        window.addMouseWheelListener(this);
        window.addKeyListener(this);
    }

    @Override
    public synchronized void paint(Graphics2D graphics) {
        Window window = screenManager.getFullScreenWindow();
        graphics.setColor(window.getBackground());
        graphics.fillRect(0, 0, screenManager.getWidth(), screenManager.getHeight());
        graphics.setColor(window.getForeground());
        graphics.drawString(mess, 400, 400);
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
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e) {
        mess = "You pressed a mouse button";
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mess = "You released a mouse button";
    }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void mouseDragged(MouseEvent e) {
        mess = "You are dragging the mouse";
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mess = "You're moving the mouse";
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        mess = "You've scrolled the mouse wheel";
    }
}
