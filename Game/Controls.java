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
        super(800, 600, 1); 

        getBackground().setColor(Color.BLACK);
        getBackground().setFont(new Font(45));
        getBackground().drawString("1 = Bullet Tower", 230, 175);

        getBackground().setColor(Color.BLACK);
        getBackground().setFont(new Font(45));
        getBackground().drawString("2 = Advanced Bullet Tower", 150, 325);

        getBackground().setColor(Color.BLACK);
        getBackground().setFont(new Font(45));
        getBackground().drawString("Space = Return", 250,475);

        getBackground().setColor(Color.WHITE);
        getBackground().setFont(new Font(20));
        getBackground().drawString("Press 'Space' to return to Menu", 275, 550);

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
