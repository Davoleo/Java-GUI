package davoleo.javagui.games.input;

import davoleo.javagui.games.Core;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 27/08/2019 / 19:29
 * Class: KeyTest
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class KeyTest extends Core implements KeyListener {

    public static void main(String[] args) {
        new KeyTest().run();
    }

    private String message = "";

    //init
    @Override
    public void init() {
        super.init();
        Window window = screenManager.getFullScreenWindow();
        //Special keys like TAB don't do their usual thing
        window.setFocusTraversalKeysEnabled(false);
        window.addKeyListener(this);
        message = "Press ESC to Exit";

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_ESCAPE)
            quit();
        else {
            message = "Key Pressed = " + KeyEvent.getKeyText(keyCode);
            e.consume();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        message = "Key Released = " + KeyEvent.getKeyText(keyCode);
        e.consume();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        e.consume();
    }

    @Override
    public synchronized void paint(Graphics2D graphics) {
        Window window = screenManager.getFullScreenWindow();
        graphics.setColor(window.getBackground());
        graphics.fillRect(0, 0, screenManager.getWidth(), screenManager.getHeight());
        graphics.setColor(window.getForeground());
        graphics.drawString(message, 250, 250);
    }
}
