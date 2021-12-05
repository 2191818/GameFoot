import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LivesDisplay1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LivesDisplay1 extends Actor
{
    /**
     * Act - do whatever the LivesDisplay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GrassField game;
    public LivesDisplay1()
    {
        setImage(new GreenfootImage("Lives: " + GrassField.Lives, 40,Color.BLACK, new Color(0,0,0,0)));
    }
    public void act()
    {
        setImage(new GreenfootImage("Lives: " + GrassField.Lives, 40,Color.BLACK, new Color(0,0,0,0)));
        if(Greenfoot.mouseClicked(this))
            game.Lives = 7;
    }
}
