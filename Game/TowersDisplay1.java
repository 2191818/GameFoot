import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TowersDisplay1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TowersDisplay1 extends Actor
{
    /**
     * Act - do whatever the TowersDisplay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GrassField game;
    public TowersDisplay1()
    {
        setImage(new GreenfootImage("Towers Remaining: " + GrassField.towerLimit, 25,Color.BLACK, new Color(0,0,0,0)));
    }
    public void act()
    {
        setImage(new GreenfootImage("Towers Remaining: " + GrassField.towerLimit, 25,Color.BLACK, new Color(0,0,0,0)));
        if(Greenfoot.mouseClicked(this))
            game.towerLimit = 5;
    }
}
