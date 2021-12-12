import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartMenu extends World
{

    /**
     * Constructor for objects of class StartMenu.
     * 
     */
    public StartMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1430, 900, 1); 
        GreenfootSound backgroundMusic = new GreenfootSound("gameplay.wav");
        backgroundMusic.playLoop();
        
        getBackground().setColor(Color.RED);
        getBackground().setFont(new Font(45));
        getBackground().drawString("Start Game", 600, 320);
        getBackground().setColor(Color.RED);
        getBackground().drawRect(575, 270, 285, 75);

        getBackground().setColor(Color.RED);
        getBackground().setFont(new Font(45));
        getBackground().drawString("Tutorial", 635, 445);
        getBackground().setColor(Color.RED);
        getBackground().drawRect(575, 370, 285, 130);

        getBackground().setColor(Color.RED);
        getBackground().setFont(new Font(45));
        getBackground().drawString("Controls", 635, 575);
        getBackground().setColor(Color.RED);
        getBackground().drawRect(575, 525, 285, 75);
        
        getBackground().setColor(Color.WHITE);
        getBackground().setFont(new Font(20));
        getBackground().drawString("Muhammad Arsalan Saeed and Valentin Atanasov", 500, 850);
        prepare();
        
        }

    public void act()
    {   if(Greenfoot.isKeyDown("2"))
        {
            Greenfoot.setWorld(new TutorialLevel());        
        }
        if(Greenfoot.isKeyDown("1"))
        {
            Greenfoot.setWorld(new LevelSelection());        
        }
        if(Greenfoot.isKeyDown("3"))
        {
            Greenfoot.setWorld(new Controls());
        }
           
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Vanier vanier = new Vanier();
        addObject(vanier,741,526);
        vanier.setLocation(229,92);
        vanier.setLocation(247,71);
        vanier.setLocation(282,86);
        vanier.setLocation(237,107);
        vanier.setLocation(206,99);
    }
}
