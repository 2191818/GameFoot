import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemiesDestroyedDisplay1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemiesDestroyedDisplay1 extends Actor
{
    /**
     * Act - do whatever the CurrencyDisplay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GrassField game;
    public EnemiesDestroyedDisplay1()
    {
        setImage(new GreenfootImage("Enemies Destroyed (/45): " + GrassField.EnemiesDestroyed, 20,Color.BLACK, new Color(0,0,0,0)));
    }
    public void act()
    {
        setImage(new GreenfootImage("Enemies Destroyed (/45): " + GrassField.EnemiesDestroyed, 20,Color.BLACK, new Color(0,0,0,0)));
    }
}
