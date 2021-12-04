import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LivesDisplay3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LivesDisplay3 extends Actor
{
    /**
     * Act - do whatever the LivesDisplay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    IceField game;
    public LivesDisplay3()
    {
        setImage(new GreenfootImage("Lives: " + IceField.Lives, 40,Color.BLACK, new Color(0,0,0,0)));
    }
    public void act()
    {
        setImage(new GreenfootImage("Lives: " + IceField.Lives, 40,Color.BLACK, new Color(0,0,0,0)));
        if(Greenfoot.mouseClicked(this))
            game.Lives = 10;
    }
}
