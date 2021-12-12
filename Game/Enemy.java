import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GrassField world1;
    DesertField world2;
    IceField world3;
    
    public int health = 8;
    
    public void act()
    {
        moveAlongDirtPath();
        moveAlongSandPath();
        moveAlongIcePath();
        hitByProjectile();
    }
    
        public void moveAlongDirtPath()
    {
        move(2);
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
    
    public void moveAlongSandPath()
    {
        move(2);
        List <sandPath> sandpath90 = getObjectsAtOffset(-30, 0, sandPath.class);
        for(sandPath sandpaths: sandpath90)
        {
            if(sandpaths.straigth == false && getRotation() == 0)
            {
                setRotation(sandpaths.turn);
            }
        }
        List <sandPath> sandpath270 = getObjectsAtOffset(30, 0, sandPath.class);
        for(sandPath sandpaths: sandpath270)
        {
            if(sandpaths.straigth == false && getRotation() == 180)
            {
                setRotation(sandpaths.turn);
            }
        }  
        List <sandPath> sandpath180 = getObjectsAtOffset(0, 30, sandPath.class);
        for(sandPath sandpaths: sandpath180)
        {
            if(sandpaths.straigth == false && getRotation() == 270)
            {
                setRotation(sandpaths.turn);
            }
        }
        List <sandPath> sandpath0 = getObjectsAtOffset(0, -30, sandPath.class);
        for(sandPath sandpaths: sandpath0)
        {
            if(sandpaths.straigth == false && getRotation() == 90)
            {
                setRotation(sandpaths.turn);
            }
        }
    }
    
        public void moveAlongIcePath()
    {
        move(2);
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
            world1.Currency += 25;
            world1.EnemiesDestroyed++;
            world2.Currency += 25;
            world2.EnemiesDestroyed++;
            world3.Currency += 25;
            world3.EnemiesDestroyed++;
            getWorld().removeObject(this);
        }
        else if(isAtEdge())
        {
            getWorld().removeObject(this);
            world1.Lives--;
            world2.Lives--;
            world3.Lives--;
        }
    }
}
