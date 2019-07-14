package davoleo.javagui.games.fullscreen;

import davoleo.javagui.games.animation.Animation;

import javax.swing.*;
import java.awt.*;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 22/06/2019 / 17:05
 * Class: MainGame
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class MainGame extends JFrame {

    private ScreenManager screen;
    private Image bg;
    private Image js;
    private Image pic;
    private Animation animation;
    private boolean loaded;

    private static final DisplayMode[] modes = {
            new DisplayMode(1920, 1080, DisplayMode.BIT_DEPTH_MULTI, DisplayMode.REFRESH_RATE_UNKNOWN),
            new DisplayMode(800, 600, 32, DisplayMode.REFRESH_RATE_UNKNOWN),
            new DisplayMode(800, 600, 24, DisplayMode.REFRESH_RATE_UNKNOWN),
            new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN),
            new DisplayMode(640, 480, 32, DisplayMode.REFRESH_RATE_UNKNOWN),
            new DisplayMode(604, 480, 24, DisplayMode.REFRESH_RATE_UNKNOWN),
            new DisplayMode(604, 480, 16, DisplayMode.REFRESH_RATE_UNKNOWN)
    };

    public static void main(String[] args)
    {
        MainGame main = new MainGame();
        main.run();
    }

    private void run()
    {
        setFont(new Font("Arial", Font.PLAIN, 24));
        loaded = false;

        screen = new ScreenManager();
        try {
            DisplayMode dm = screen.findFirstCompatibleMode(modes);
            screen.setFullScreen(dm);
            loadImages();
            movieLoop();
        }finally {
            screen.setWindowed();
        }
    }

    private void loadImages()
    {
        bg = new ImageIcon(getClass().getResource("../../../../resources/forest_bg.jpg")).getImage();
        js = new ImageIcon(getClass().getResource("../../../../resources/js.png")).getImage();
        pic = new ImageIcon(getClass().getResource("../../../../resources/40x40.png")).getImage();

        Image face1 = new ImageIcon(getClass().getResource("../../../../resources/happy.png")).getImage();
        Image face2 = new ImageIcon(getClass().getResource("../../../../resources/sad.png")).getImage();

        animation = new Animation();
        animation.addScene(face1, 250);
        animation.addScene(face2, 250);

        loaded = true;
        repaint();
    }

    private void movieLoop()
    {
        long startingTime = System.currentTimeMillis();
        long animTime = startingTime;

        while (animTime - startingTime < 5000)
        {
            long timePassed = System.currentTimeMillis() - animTime;
            animTime += timePassed;
            animation.update(timePassed);

            Graphics2D graphics = screen.getGraphics();
            paint(graphics);
            graphics.dispose();
            screen.update();

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g)
    {
        if (g instanceof Graphics2D)
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        if (loaded) {
            g.drawImage(bg, 0, 0, null);
            g.drawImage(js, 0, 0, null);
            g.drawImage(pic, 50, 50, null);
            g.drawImage(animation.getFrame(), 300, 50, null);
        }
        g.drawString("Awesome!", 200, 200);
    }
}
