import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TowersDisplay3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TowersDisplay3 extends Actor
{
    /**
     * Act - do whatever the TowersDisplay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    IceField game;
    public TowersDisplay3()
    {
        setImage(new GreenfootImage("Towers Remaining: " + IceField.towerLimit, 25,Color.BLACK, new Color(0,0,0,0)));
    }
    public void act()
    {
        setImage(new GreenfootImage("Towers Remaining: " + IceField.towerLimit, 25,Color.BLACK, new Color(0,0,0,0)));
        if(Greenfoot.mouseClicked(this))
            game.towerLimit = 4;
    }
}
