import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemiesDestroyedDisplay3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemiesDestroyedDisplay3 extends Actor
{
    /**
     * Act - do whatever the CurrencyDisplay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    IceField game;
    public EnemiesDestroyedDisplay3()
    {
        setImage(new GreenfootImage("Enemies Destroyed (/75): " + IceField.EnemiesDestroyed, 20,Color.BLACK, new Color(0,0,0,0)));
    }
    public void act()
    {
        setImage(new GreenfootImage("Enemies Destroyed (/75): " + IceField.EnemiesDestroyed, 20,Color.BLACK, new Color(0,0,0,0)));
    }
}
