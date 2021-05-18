package net.davoleo.javagui.games.sprite;

import net.davoleo.javagui.games.animation.Animation;

import java.awt.*;

/*************************************************
 * Author: Davoleo
 * Date / Hour: 14/08/2019 / 21:49
 * Class: Sprite
 * Project: JavaGUI
 * Copyright - © - Davoleo - 2019
 **************************************************/

public class Sprite {

    private Animation animation;
    private float x;
    private float y;
    private float velocityX;
    private float velocityY;

    public Sprite(Animation animation)
    {
        this.animation = animation;
    }

    //change position
    public void update(long timePassed)
    {
        x += velocityX * timePassed;
        y += velocityY * timePassed;
        animation.update(timePassed);
    }

    //Getters and Setters
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getSpriteWidth() {
        return animation.getFrame().getWidth(null);
    }

    public int getSpriteHeight() {
        return animation.getFrame().getHeight(null);
    }

    public float getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(float velocityX) {
        this.velocityX = velocityX;
    }

    public float getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(float velocityY) {
        this.velocityY = velocityY;
    }

    public Image getImage()
    {
        return animation.getFrame();
    }
}
