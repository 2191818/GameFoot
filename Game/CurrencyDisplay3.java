import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CurrencyDisplay3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CurrencyDisplay3 extends Actor
{
 /**
     * Act - do whatever the CurrencyDisplay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    IceField game;
    public CurrencyDisplay3()
    {
        setImage(new GreenfootImage("Currency: " + IceField.Currency, 40,Color.BLACK, new Color(0,0,0,0)));
    }
    public void act()
    {
        setImage(new GreenfootImage("Currency: " + IceField.Currency, 40,Color.BLACK, new Color(0,0,0,0)));
        if(Greenfoot.mouseClicked(this))
            game.Currency = 100;
    }
}
