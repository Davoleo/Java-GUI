package davoleo.javagui.games.fullscreen;

import javax.swing.*;
import java.awt.*;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 22/06/2019 / 16:51
 * Class: Screen
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class Screen {

    private GraphicsDevice videoCard;

    public Screen(){
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        videoCard = environment.getDefaultScreenDevice();
    }

    public void setFullScreen(DisplayMode dm, JFrame window)
    {
        window.setUndecorated(true);
        window.setResizable(false);
        videoCard.setFullScreenWindow(window);

        if (dm != null && videoCard.isDisplayChangeSupported())
        {
            try {
                videoCard.setDisplayMode(dm);
            }catch (Exception e) {System.out.println("HEH");}
        }
    }

    public Window getFullScreenWindow(){
        return videoCard.getFullScreenWindow();
    }

    public void setWindowed()
    {
        Window window = videoCard.getFullScreenWindow();
        if (window != null)
            window.dispose();

        //Null (it makes sure your window is in windowed mode)
        videoCard.setFullScreenWindow(null);
    }

}
