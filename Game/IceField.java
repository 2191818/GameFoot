import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IceField here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IceField extends World
{
     public static int Currency = 100;
    
    public static int Lives = 10;
    
    public static int towerLimit = 4;
    
    public static int EnemiesDestroyed = 0;
    
    private int timer = 2500;
    
    double towerVariable = 1;
    
    int BulletTowerPrice = 50; 
    
    int worldTime;
    
    int map [][] = {
                    {1,0,0,0,0,0,0,0,0,0},
                    {1,0,0,0,0,0,0,0,0,0},
                    {1,0,0,0,0,0,0,0,0,0},
                    {5,1,1,3,0,0,0,0,0,0},
                    {0,0,0,1,0,0,0,0,0,0},
                    {0,0,4,5,0,0,0,0,0,0},
                    {0,0,1,0,0,0,0,0,0,0},
                    {0,0,1,0,0,0,2,1,1,1},
                    {0,0,5,1,1,1,1,0,0,0},
                    {0,0,0,0,0,0,0,0,0,0},
                };
    
    public IceField()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(840, 600, 1);
        Menu menu = new Menu();
        addObject(menu,721,301);
        addObject(new CurrencyDisplay3(), 720, 30);
        addObject(new LivesDisplay3(), 720, 90);
        addObject(new TowersDisplay3(), 720, 150);
        IceField();
    }
    
    public void act()
    {
       addInBulletTowers();
       worldTime++;
       spawnWave();
       transitionToWorld();
    }
    
    public void spawnWave()
    {
        if(worldTime % 20 == 0 && worldTime < 400)
        {
            addObject(new Enemy(), 1, 90);
        }
        if(worldTime % 20 == 0 && worldTime >= 400 && worldTime < 800)
        {
            addObject(new FastEnemy(), 1, 90);
        }
        if(worldTime % 20 == 0 && worldTime >= 800 && worldTime < 1000)
        {
            addObject(new StrongEnemy(), 1, 90);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void IceField()
    {
        for(int i = 0; i < 10; i++)
            for(int p = 0; p < 10; p++)
            {
                if(map[p][i] == 1)
                {
                    addObject(new icePath(true), 30 + i * 60, 30 + p * 60);
                }
                if(map[p][i] == 2)
                {
                    addObject(new icePath(90), 30 + i * 60, 30 + p * 60);
                }
                if(map[p][i] == 3)
                {
                    addObject(new icePath(180), 30 + i * 60, 30 + p * 60);
                }
                if(map[p][i] == 4)
                {
                    addObject(new icePath(0), 30 + i * 60, 30 + p * 60);
                }
                if(map[p][i] == 5)
                {
                    addObject(new icePath(270), 30 + i * 60, 30 + p * 60);
                }
            }
    }
    
    public void addInBulletTowers()
    {
        if(Greenfoot.isKeyDown("1") && Greenfoot.getMouseInfo().getActor() == null && Currency >= BulletTowerPrice && towerLimit >= 1)
        {
            addObject(new BulletTower(), (Greenfoot.getMouseInfo().getX() / 60) * 60 + 30, (Greenfoot.getMouseInfo().getY() / 60) * 60 + 30);
            Currency -= BulletTowerPrice;
            towerLimit -= towerVariable;
        }
    }
    
    
    public void transitionToWorld()
    {
        if(Lives < 1)
        {
            Greenfoot.setWorld(new EndMenu());
        }
        else if(worldTime > 1600)
        {
            Greenfoot.setWorld(new StartMenu());
        }
    }
}
