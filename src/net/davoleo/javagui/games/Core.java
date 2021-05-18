package net.davoleo.javagui.games;

import net.davoleo.javagui.games.fullscreen.ScreenManager;

import java.awt.*;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 25/08/2019 / 14:15
 * Class: Core
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2019
 **************************************************/

public abstract class Core {

    private static final DisplayMode[] modes = {
            new DisplayMode(1920, 1080, DisplayMode.BIT_DEPTH_MULTI, DisplayMode.REFRESH_RATE_UNKNOWN),
            new DisplayMode(800, 600, 32, DisplayMode.REFRESH_RATE_UNKNOWN),
            new DisplayMode(800, 600, 24, DisplayMode.REFRESH_RATE_UNKNOWN),
            new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN),
            new DisplayMode(640, 480, 32, DisplayMode.REFRESH_RATE_UNKNOWN),
            new DisplayMode(604, 480, 24, DisplayMode.REFRESH_RATE_UNKNOWN),
            new DisplayMode(604, 480, 16, DisplayMode.REFRESH_RATE_UNKNOWN)
    };

    private boolean running;
    protected ScreenManager screenManager;

    public void quit() {
        running = false;
    }

    //init and gameloop
    public void run() {
        try {
            init();
            gameloop();
        } finally {
            screenManager.setWindowed();
        }
    }

    public void gameloop() {

        long startTime = System.currentTimeMillis();
        long cumulativeTime = startTime;

        while(running) {
            long timePassed = System.currentTimeMillis() - cumulativeTime;
            cumulativeTime += timePassed;

            update(timePassed);

            Graphics2D graphics = screenManager.getGraphics();
            paint(graphics);
            graphics.dispose();
            screenManager.update();

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //sets to full screen
    public void init() {
        screenManager = new ScreenManager();
        DisplayMode displayMode = screenManager.findFirstCompatibleMode(modes);
        screenManager.setFullScreen(displayMode);

        Window window = screenManager.getFullScreenWindow();
        window.setFont(new Font("Arial", Font.PLAIN, 20));
        window.setBackground(Color.ORANGE);
        window.setForeground(Color.BLACK);
        running = true;
    }

    public void update (long timePassed) {

    }

    public abstract void paint(Graphics2D graphics);


}
