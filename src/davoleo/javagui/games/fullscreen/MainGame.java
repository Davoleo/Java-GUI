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

    public static void main(String[] args)
    {
        DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
        MainGame main = new MainGame();
        main.run(dm);
    }

    private Screen screen;
    private Image bg;
    private Image pic;
    private Animation animation;
    private boolean loaded;

    private void run(DisplayMode dm)
    {
        setBackground(Color.PINK);
        setForeground(Color.BLACK);
        setFont(new Font("Arial", Font.PLAIN, 24));
        loaded = false;

        screen = new Screen();
        try {
            screen.setFullScreen(dm, this);
            loadImages();
            movieLoop();
        }finally {
            screen.setWindowed();
        }
    }

    private void loadImages()
    {
        bg = new ImageIcon(getClass().getResource("../../../../resources/js.png")).getImage();
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

            Graphics graphics = screen.getFullScreenWindow().getGraphics();
            graphics.drawImage(animation.getFrame(), 0, 0, null);
            graphics.dispose();

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
            g.drawImage(bg, 200, 200, null);
            g.drawImage(pic, 1000, 500, null);
        }
        g.drawString("Awesome!", 200, 200);
    }
}
