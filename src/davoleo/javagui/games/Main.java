package davoleo.javagui.games;

import javax.swing.*;
import java.awt.*;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 22/06/2019 / 17:05
 * Class: Main
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class Main extends JFrame {

    public static void main(String[] args)
    {
        DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
        Main main = new Main();
        main.run(dm);
    }

    private void run(DisplayMode dm)
    {
        setBackground(Color.PINK);
        setForeground(Color.BLACK);
        setFont(new Font("Arial", Font.PLAIN, 24));

        Screen screen = new Screen();
        screen.setFullScreen(dm, this);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            screen.setWindowed();
        }
    }

    @Override
    public void paint(Graphics g)
    {
        g.drawString("Awesome!", 200, 200);
    }
}
