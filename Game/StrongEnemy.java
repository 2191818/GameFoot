import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StrongEnemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    IceField world3;
    
    public int health = 20;
    
    public void act()
    {
        moveAlongIcePath();
        hitByProjectile();
    }
    
    public void moveAlongIcePath()
    {
        move(1);
        List <icePath> icepath90 = getObjectsAtOffset(-30, 0, icePath.class);
        for(icePath icepaths: icepath90)
        {
            if(icepaths.straigth == false && getRotation() == 0)
            {
                setRotation(icepaths.turn);
            }
        }
        List <icePath> icepath270 = getObjectsAtOffset(30, 0, icePath.class);
        for(icePath icepaths: icepath270)
        {
            if(icepaths.straigth == false && getRotation() == 180)
            {
                setRotation(icepaths.turn);
            }
        }  
        List <icePath> icepath180 = getObjectsAtOffset(0, 30, icePath.class);
        for(icePath icepaths: icepath180)
        {
            if(icepaths.straigth == false && getRotation() == 270)
            {
                setRotation(icepaths.turn);
            }
        }
        List <icePath> icepath0 = getObjectsAtOffset(0, -30, icePath.class);
        for(icePath icepaths: icepath0)
        {
            if(icepaths.straigth == false && getRotation() == 90)
            {
                setRotation(icepaths.turn);
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
            world3.Currency += 45;
            world3.EnemiesDestroyed++;
            getWorld().removeObject(this);
        }
        else if(isAtEdge())
        {
            getWorld().removeObject(this);
            world3.Lives--;
        }
    }
}


