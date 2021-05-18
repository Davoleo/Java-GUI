package net.davoleo.javagui.games.animation;

import java.awt.*;
import java.util.ArrayList;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 03/07/2019 / 08:10
 * Class: Animation
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class Animation {

    private ArrayList scenes;
    private int sceneIndex;
    private long movieTime;
    private long totalTime;

    //Constructor
    public Animation() {
        scenes = new ArrayList();
        totalTime = 0;
        start();
    }

    /**
     * Adds a scene to the scenes
     * synchronized: makes sure it doesn't run concurrently on other threads
     */
    public synchronized void addScene(Image img, long time)
    {
        totalTime += time;
        scenes.add(new Scene(img, totalTime));
    }

    //Starts the animation
    private synchronized void start()
    {
        movieTime = 0;
        sceneIndex = 0;
    }

    //update the animation (changes frame)
    public synchronized void update(long timePassed)
    {
        if (scenes.size() > 1)
        {
            movieTime += timePassed;
            if (movieTime >= totalTime)
                start();

            while (movieTime > getScene(sceneIndex).endTime)
                sceneIndex++;
        }
    }

    //Current animation frame AKA Scene
    public synchronized Image getFrame()
    {
        if (scenes.size() == 0)
            return null;
        else
            return getScene(sceneIndex).pic;
    }

    //get scene
    private Scene getScene(int index)
    {
        return (Scene) scenes.get(index);
    }

    ///////// Private inner Scene Class /////////////
    private class Scene {

        private Image pic;
        private long endTime;

        Scene(Image pic, long endTime)
        {
            this.pic = pic;
            this.endTime = endTime;
        }
    }

}
