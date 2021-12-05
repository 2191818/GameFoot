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
    Test world;
    GrassField world1;
    DesertField world2;
    IceField world3;
    public int health = 4;
    
    public void act()
    {
        moveAlongPath();
        moveAlongDirtPath();
        moveAlongSandPath();
        moveAlongIcePath();
        hitByProjectile();
    }
    
    public void moveAlongPath()
    {
        move(5);
        List <Path> path90 = getObjectsAtOffset(-30, 0, Path.class);
        for(Path paths: path90)
        {
            if(paths.straigth == false && getRotation() == 0)
            {
                setRotation(paths.turn);
            }
        }
        List <Path> path270 = getObjectsAtOffset(30, 0, Path.class);
        for(Path paths: path270)
        {
            if(paths.straigth == false && getRotation() == 180)
            {
                setRotation(paths.turn);
            }
        }  
        List <Path> path180 = getObjectsAtOffset(0, 30, Path.class);
        for(Path paths: path180)
        {
            if(paths.straigth == false && getRotation() == 270)
            {
                setRotation(paths.turn);
            }
        }
        List <Path> path0 = getObjectsAtOffset(0, -30, Path.class);
        for(Path paths: path0)
        {
            if(paths.straigth == false && getRotation() == 90)
            {
                setRotation(paths.turn);
            }
        }
    }
    
        public void moveAlongDirtPath()
    {
        move(1);
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
        move(1);
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
            world.Currency += 15;
            world.EnemiesDestroyed++;
            world1.Currency += 15;
            world1.EnemiesDestroyed++;
            world2.Currency += 15;
            world2.EnemiesDestroyed++;
            world3.Currency += 15;
            world3.EnemiesDestroyed++;
            getWorld().removeObject(this);
        }
        else if(isAtEdge())
        {
            getWorld().removeObject(this);
            world.Lives--;
            world1.Lives--;
            world2.Lives--;
            world3.Lives--;
        }
    }
}
