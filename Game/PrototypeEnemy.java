import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class PrototypeEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PrototypeEnemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    TutorialLevel world;
    
    public int health = 5;
    
    public void act()
    {
        moveAlongPath();
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
            world.Currency += 25;
            world.EnemiesDestroyed++;
            getWorld().removeObject(this);
        }
        else if(isAtEdge())
        {
            getWorld().removeObject(this);
            world.Lives--;
        }
    }
}
