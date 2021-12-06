import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IceField here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IceField extends World
{
    public static int Currency = 250;

    public static int Lives = 4;

    public static int towerLimit = 3;

    public static int EnemiesDestroyed = 0;

    private int timer = 2500;

    double towerVariable = 1;

    int BulletTowerPrice = 50; 

    int AdvancedBulletTowerPrice = 125;

    int worldTime;

    int map [][] = {
            {0,0,0,0,0,1,0,0,0,0},
            {0,0,0,0,0,5,1,3,0,0},
            {0,0,0,0,0,0,0,1,0,0},
            {1,1,1,2,0,0,0,1,0,0},
            {0,0,0,1,0,0,0,1,0,0},
            {0,0,2,3,0,0,0,1,0,0},
            {0,0,1,0,0,0,0,1,0,0},
            {0,0,1,0,0,0,4,5,0,0},
            {0,0,4,1,1,1,5,0,0,0},
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
        addObject(new EnemiesDestroyedDisplay3(), 720, 210);
        Currency = 250;
        Lives = 4;
        towerLimit = 4;
        EnemiesDestroyed = 0;
        IceField();
        prepare();
    }

    public void act()
    {
        addInBulletTowers();
        addInAdvancedBulletTowers();
        worldTime++;
        spawnWave();
        timer();
        transitionToWorld();
    }

    public void spawnWave()
    {
        if(worldTime % 20 == 10 && worldTime < 700)
        {
            addObject(new Enemy(), 8, 209);
        }
        if(worldTime % 20 == 0 && worldTime >= 700 && worldTime < 1300)
        {
            addObject(new FastEnemy(), 8, 209);
        }
        if(worldTime % 20 == 0 && worldTime >= 1300 && worldTime < 1510)
        {
            addObject(new StrongEnemy(), 8, 209);
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

    public void addInAdvancedBulletTowers()
    {
        if(Greenfoot.isKeyDown("2") && Greenfoot.getMouseInfo().getActor() == null && Currency >= AdvancedBulletTowerPrice && towerLimit > 0)
        {
            addObject(new AdvancedBulletTower(), (Greenfoot.getMouseInfo().getX() / 60) * 60 + 30, (Greenfoot.getMouseInfo().getY() / 60) * 60 + 30);
            Currency -= AdvancedBulletTowerPrice;
            towerLimit -= towerVariable;
        }    
    }

    public void timer()
    {
        timer--;
        showText("Time Left: " +timer, 720, 270);
    }

    public void transitionToWorld()
    {
        if(Lives < 1)
        {
            Greenfoot.setWorld(new GameOverScreen());
        }
        if(timer < 1)
        {
            Greenfoot.setWorld(new GameOverScreen());
        }
        if(EnemiesDestroyed == 75)
        {
            Greenfoot.setWorld(new WellDone());
        }
        if (EnemiesDestroyed >= 70 && timer < 1)
        {
            Greenfoot.setWorld(new LevelSelection());    
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Player player = new Player();
        addObject(player,349,49);
    }
}
