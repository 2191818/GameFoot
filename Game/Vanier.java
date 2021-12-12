import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vanier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vanier extends Actor
{
    /**
     * Act - do whatever the Vanier wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    public Vanier()
    {
        GreenfootImage img = new GreenfootImage("vanier.png");
        img.scale(img.getWidth()/4, img.getHeight()/4);
        setImage(img);
    }
}
