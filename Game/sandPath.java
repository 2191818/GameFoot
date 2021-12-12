import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class sandPath here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class sandPath extends Actor
{
    /**
     * Act - do whatever the Pasth wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int turn;
    public boolean straigth;
    public sandPath(boolean straigth)
    {
        getImage().scale(60, 60);
        this.straigth = straigth;
    }
        public sandPath(int turn)
    {
        getImage().scale(60, 60);
        this.turn = turn;
    }
    public void act()
    {
        // Add your action code here.
    }
}
