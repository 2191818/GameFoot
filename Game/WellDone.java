import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WellDone here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WellDone extends World
{

    /**
     * Constructor for objects of class WellDone.
     * 
     */
    public WellDone()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(850, 550, 1);

        getBackground().setColor(Color.WHITE);
        getBackground().setFont(new Font(20));
        getBackground().drawString("Press 'Space' to return to Menu", 275, 500);

        prepare();
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new StartMenu());
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
