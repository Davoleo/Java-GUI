package davoleo.javagui.games.fullscreen;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 22/06/2019 / 16:51
 * Class: ScreenManager
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class ScreenManager {

    private GraphicsDevice videoCard;

    // Gives video card access to monitor screen
    public ScreenManager(){
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        videoCard = environment.getDefaultScreenDevice();
    }

    //gets all compatible display modes
    public DisplayMode[] getCompatibleDisplayModes()
    {
        return videoCard.getDisplayModes();
    }

    //compares a certain display mode with the one set in the video card to see if they match and returns it returns
    public DisplayMode findFirstCompatibleMode(DisplayMode[] modes)
    {
        DisplayMode[] compatibleModes = videoCard.getDisplayModes();
        for (DisplayMode mode : modes)
        {
            for (DisplayMode compatibleMode : compatibleModes)
            {
                if (displayModesMatch(mode, compatibleMode))
                    return mode;
            }
        }
        return null;
    }

    //Gets Current Display Mode
    public DisplayMode getCurrentDisplayMode()
    {
        return videoCard.getDisplayMode();
    }

    //Returns true if two modes match each other
    private boolean displayModesMatch(DisplayMode mode1, DisplayMode mode2)
    {
        if (mode1.getWidth() != mode2.getWidth() || mode1.getHeight() != mode2.getHeight())
            return false;
        if (mode1.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && mode2.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && mode1.getBitDepth() != mode2.getBitDepth())
            return false;
        if (mode1.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && mode2.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && mode1.getRefreshRate() != mode2.getRefreshRate())
            return false;
        return true;
    }

    //sets fullscreen window
    public void setFullScreen(DisplayMode dm)
    {
        JFrame window = new JFrame();
        window.setUndecorated(true);
        window.setIgnoreRepaint(true);
        window.setResizable(false);
        videoCard.setFullScreenWindow(window);

        if (dm != null && videoCard.isDisplayChangeSupported())
        {
            try {
                videoCard.setDisplayMode(dm);
            }catch (Exception e) {System.out.println("HEH");}
        }

        //corresponding to the two frames of the animation
        window.createBufferStrategy(2);
    }

    public Graphics2D getGraphics()
    {
        Window window = videoCard.getFullScreenWindow();
        if (window != null)
        {
            BufferStrategy buffer = window.getBufferStrategy();
            return (Graphics2D) buffer.getDrawGraphics();
        }
        else return null;
    }

    //updates display
    public void update()
    {
        Window window = videoCard.getFullScreenWindow();

        if (window != null)
        {
            BufferStrategy buffer = window.getBufferStrategy();
            if (!buffer.contentsLost())
                buffer.show();
        }
    }

    //returns fullscreen window
    public Window getFullScreenWindow(){
        return videoCard.getFullScreenWindow();
    }

    //returns window's width
    public int getWidth()
    {
        return getFullScreenWindow() != null ? getFullScreenWindow().getWidth() : 0;
    }

    //return window's height
    public int getHeight()
    {
        return getFullScreenWindow() != null ? getFullScreenWindow().getHeight() : 0;
    }

    public void setWindowed()
    {
        Window window = getFullScreenWindow();
        if (window != null)
            window.dispose();

        //Null (it makes sure your window is in windowed mode)
        videoCard.setFullScreenWindow(null);
    }

    //makes a compatible image with your device
    public BufferedImage createCompatibleImage(int width, int height, int transparency)
    {
        Window window = getFullScreenWindow();
        if (window != null)
        {
            GraphicsConfiguration graphicsConfiguration = window.getGraphicsConfiguration();
            return graphicsConfiguration.createCompatibleImage(width, height, transparency);
        }
        return null;
    }

}
