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
    }
    
    public void act()
    {   if(Greenfoot.isKeyDown("c"))
        {
            Greenfoot.setWorld(new Test());        
        }
        //MouseInfo mouse = Greenfoot.getMouseInfo();
        //if (mouse != null) {
        //int x = mouse.getX();
        //int y = mouse.getY();
        //if (Greenfoot.mouseClicked(null)){
            //if (mouse.getX() > 575 && mouse.getX() < 285 && mouse.getY() > 270 && mouse.getY() < 75){
            //Level1 q = new Level1();
           //Greenfoot.setWorld(q);    
            }
        }
