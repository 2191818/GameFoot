import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CurrencyDisplay2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CurrencyDisplay2 extends Actor
{
 /**
     * Act - do whatever the CurrencyDisplay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    DesertField game;
    public CurrencyDisplay2()
    {
        setImage(new GreenfootImage("Currency: " + DesertField.Currency, 40,Color.BLACK, new Color(0,0,0,0)));
    }
    public void act()
    {
        setImage(new GreenfootImage("Currency: " + DesertField.Currency, 40,Color.BLACK, new Color(0,0,0,0)));
        if(Greenfoot.mouseClicked(this))
            game.Currency = 100;
    }
}
