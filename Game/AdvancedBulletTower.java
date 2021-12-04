import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class AdvancedBulletTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AdvancedBulletTower extends Actor
{
    /**
     * Act - do whatever the BulletTower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int fireRate = 0;
    public AdvancedBulletTower()
    {
        getImage().scale(60, 60);
    }
    public void act()
    {
       enemyDetector();
    }
    public void enemyDetector()
    {
       fireRate++; 
       List<Enemy> enemies = getObjectsInRange(125, Enemy.class);
       for(Enemy eachEnemy: enemies)
       {
           if(fireRate > 6){
               Projectile projectile = new Projectile();
               getWorld().addObject(projectile, getX(), getY());
               projectile.turnTowards(eachEnemy.getX(), eachEnemy.getY());
               fireRate = 0;
           }
        }
    }
}
