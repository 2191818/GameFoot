import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndMenu extends World
{
    
    double timeEndScreenCreation = System.currentTimeMillis();
    
    /**
     * Constructor for objects of class EndMenu.
     * 
     */
    public EndMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(840, 590, 1); 
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("space"))
        {
           Greenfoot.setWorld(new StartMenu());  
        }
        
         if (System.currentTimeMillis() >= (timeEndScreenCreation + 10000))
        {
            Greenfoot.setWorld(new StartMenu());
        }
    }
}