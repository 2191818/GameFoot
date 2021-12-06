import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Controls here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controls extends World
{

    /**
     * Constructor for objects of class Controls.
     * 
     */
    public Controls()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 800, 1); 
        
        getBackground().setColor(Color.RED);
        getBackground().setFont(new Font(45));
        getBackground().drawString("1 = Bullet Tower", 230, 250);

        getBackground().setColor(Color.RED);
        getBackground().setFont(new Font(45));
        getBackground().drawString("2 = Advanced Bullet Tower", 150, 400);
        
        getBackground().setColor(Color.RED);
        getBackground().setFont(new Font(45));
        getBackground().drawString("Space = Return", 250, 550);
 
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new StartMenu());
        }
    }
    
}
