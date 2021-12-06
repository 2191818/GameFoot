import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelSelection here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelSelection extends World
{

    /**
     * Constructor for objects of class LevelSelection.
     * 
     */
    public LevelSelection()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(840, 531, 1); 
    }
    
    public void act()
    {   if(Greenfoot.isKeyDown("1"))
        {
            Greenfoot.setWorld(new GrassField());        
        }
        if(Greenfoot.isKeyDown("2"))
        {
            Greenfoot.setWorld(new DesertField());        
        }
        if(Greenfoot.isKeyDown("3"))
        {
            Greenfoot.setWorld(new IceField());        
        }    
        if(Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new StartMenu());
        }
    }
    }
