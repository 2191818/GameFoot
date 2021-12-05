import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SimpleEnemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GrassField world;
    public int health = 5;
    public void act()
    {
        moveAlongPath();
        hitByProjectile();
    }
    
    public void moveAlongPath()
    {
        move(5);
        List <dirtPath> dirtpath90 = getObjectsAtOffset(-30, 0, dirtPath.class);
        for(dirtPath dirtpaths: dirtpath90)
        {
            if(dirtpaths.straigth == false && getRotation() == 0)
            {
                setRotation(dirtpaths.turn);
            }
        }
        List <dirtPath> dirtpath270 = getObjectsAtOffset(30, 0, dirtPath.class);
        for(dirtPath dirtpaths: dirtpath270)
        {
            if(dirtpaths.straigth == false && getRotation() == 180)
            {
                setRotation(dirtpaths.turn);
            }
        }  
        List <dirtPath> path180 = getObjectsAtOffset(0, 30, dirtPath.class);
        for(dirtPath dirtpaths: path180)
        {
            if(dirtpaths.straigth == false && getRotation() == 270)
            {
                setRotation(dirtpaths.turn);
            }
        }
        List <dirtPath> dirtpath0 = getObjectsAtOffset(0, -30, dirtPath.class);
        for(dirtPath dirtpaths: dirtpath0)
        {
            if(dirtpaths.straigth == false && getRotation() == 90)
            {
                setRotation(dirtpaths.turn);
            }
        } 
    }
    
    public void hitByProjectile()
    {
        Actor projectile = getOneIntersectingObject(Projectile.class);
        if(projectile != null)
        {
            health--;
            getWorld().removeObject(projectile);
        }
        if(health < 1)
        {
            world.Currency += 15;
            getWorld().removeObject(this);
        }
        else if(isAtEdge())
        {
            getWorld().removeObject(this);
            world.Lives--;
        }
    }
}

