import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test extends World
{
    public static int Currency = 100;
    
    public static int Lives = 10;
    
    public static int towerLimit = 4;
    
    double towerVariable = 1;
    
    int BulletTowerPrice = 50;
    
    int AdvancedBulletTowerPrice = 125;
    
    int worldTime;
    
    int waveNumber = 1;
    
    int map [][] = {
                    {0,0,0,0,0,0,0,0,0,1},
                    {1,1,1,2,0,0,0,0,0,1},
                    {0,0,0,1,0,0,4,1,1,5},
                    {0,0,0,1,0,0,1,0,0,0},
                    {0,2,1,3,0,0,5,3,0,0},
                    {0,1,0,0,0,0,0,1,0,0},
                    {0,1,0,0,0,0,0,5,3,0},
                    {0,1,0,4,1,2,0,0,1,0},
                    {0,4,1,5,0,1,0,0,1,0},
                    {0,0,0,0,0,4,1,1,5,0},
                };
    
    public Test()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(840, 600, 1);
        Menu menu = new Menu();
        addObject(menu,721,301);
        addObject(new CurrencyDisplay(), 720, 30);
        addObject(new LivesDisplay(), 720, 90);
        addObject(new TowersDisplay(), 720, 150);
        Test();
    }
    
    public void act()
    {
       addInBulletTowers();
       addInAdvancedBulletTowers();
       worldTime++;
       spawnWave();
       transitionToWorld();
    }
    
    public void spawnWave()
    {
        if(worldTime % 20 == 0 && worldTime < 400)
        {
            addObject(new Enemy(waveNumber), 1, 90);
        }
        if(worldTime % 200 == 199)
        {
            waveNumber++;
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void Test()
    {
        for(int i = 0; i < 10; i++)
            for(int p = 0; p < 10; p++)
            {
                if(map[p][i] == 1)
                {
                    addObject(new Path(true), 30 + i * 60, 30 + p * 60);
                }
                if(map[p][i] == 2)
                {
                    addObject(new Path(90), 30 + i * 60, 30 + p * 60);
                }
                if(map[p][i] == 3)
                {
                    addObject(new Path(180), 30 + i * 60, 30 + p * 60);
                }
                if(map[p][i] == 4)
                {
                    addObject(new Path(0), 30 + i * 60, 30 + p * 60);
                }
                if(map[p][i] == 5)
                {
                    addObject(new Path(270), 30 + i * 60, 30 + p * 60);
                }
            }
    }
    
    public void addInBulletTowers()
    {
        if(Greenfoot.isKeyDown("1") && Greenfoot.getMouseInfo().getActor() == null && Currency >= BulletTowerPrice && towerLimit > 0)
        {
            addObject(new BulletTower(), (Greenfoot.getMouseInfo().getX() / 60) * 60 + 30, (Greenfoot.getMouseInfo().getY() / 60) * 60 + 30);
            Currency -= BulletTowerPrice;
            towerLimit -= towerVariable;
        }
    }
    
    public void addInAdvancedBulletTowers()
    {
            if(Greenfoot.isKeyDown("2") && Greenfoot.getMouseInfo().getActor() == null && Currency >= AdvancedBulletTowerPrice && towerLimit > 0)
        {
            addObject(new AdvancedBulletTower(), (Greenfoot.getMouseInfo().getX() / 60) * 60 + 30, (Greenfoot.getMouseInfo().getY() / 60) * 60 + 30);
            Currency -= AdvancedBulletTowerPrice;
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
