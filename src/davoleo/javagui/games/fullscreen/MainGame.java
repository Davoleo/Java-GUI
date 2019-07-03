package davoleo.javagui.games.fullscreen;

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
    private boolean loaded;

    private void run(DisplayMode dm)
    {
        setBackground(Color.PINK);
        setForeground(Color.BLACK);
        setFont(new Font("Arial", Font.PLAIN, 24));
        loaded = false;

        screen = new Screen();
        screen.setFullScreen(dm, this);
        loadImages();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            screen.setWindowed();
        }
    }

    private void loadImages(){
        bg = new ImageIcon(getClass().getResource("../../../resources/js.png")).getImage();
        pic = new ImageIcon(getClass().getResource("../../../resources/40x40.png")).getImage();
        loaded = true;
        repaint();
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
