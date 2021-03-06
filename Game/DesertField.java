import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DesertField here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DesertField extends World
{
    public static int Currency = 325;

    public static int Lives = 7;

    public static int towerLimit = 4;

    public static int EnemiesDestroyed = 0;

    private int timer = 1750;

    double towerVariable = 1;

    int BulletTowerPrice = 75;

    int AdvancedBulletTowerPrice = 150;

    int worldTime;

    int map [][] = {
            {0,0,0,0,2,0,0,0,0,0},
            {0,0,0,0,2,0,0,0,0,0},
            {0,0,2,3,3,0,0,0,0,0},
            {0,0,2,0,0,0,0,0,0,0},
            {0,0,4,4,4,4,4,4,4,2},
            {0,0,0,0,0,0,0,0,0,2},
            {0,0,0,0,0,0,0,0,0,2},
            {3,3,3,0,0,0,0,2,3,3},
            {0,0,5,0,0,0,0,2,0,0},
            {0,0,5,3,3,3,3,3,0,0},
        };

    public DesertField()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(840, 600, 1);
        Menu menu = new Menu();
        addObject(menu,721,301);
        addObject(new CurrencyDisplay2(), 720, 30);
        addObject(new LivesDisplay2(), 720, 90);
        addObject(new TowersDisplay2(), 720, 150);
        addObject(new EnemiesDestroyedDisplay2(), 720, 210);
        Currency = 325;
        Lives = 7;
        towerLimit = 4;
        EnemiesDestroyed = 0;
        DesertField();
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
        if(worldTime % 20 == 0 && worldTime > 100 && worldTime < 600)
        {
            addObject(new Enemy(), 270, 10);
        }
        if(worldTime % 20 == 0 && worldTime >= 600 && worldTime < 1210)
        {
            addObject(new FastEnemy(), 270, 10);
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void DesertField()
    {
        for(int i = 0; i < 10; i++)
            for(int p = 0; p < 10; p++)
            {
                if(map[p][i] == 1)
                {
                    addObject(new sandPath(true), 30 + i * 60, 30 + p * 60);
                }
                if(map[p][i] == 2)
                {
                    addObject(new sandPath(90), 30 + i * 60, 30 + p * 60);
                }
                if(map[p][i] == 3)
                {
                    addObject(new sandPath(180), 30 + i * 60, 30 + p * 60);
                }
                if(map[p][i] == 4)
                {
                    addObject(new sandPath(0), 30 + i * 60, 30 + p * 60);
                }
                if(map[p][i] == 5)
                {
                    addObject(new sandPath(270), 30 + i * 60, 30 + p * 60);
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
        if(EnemiesDestroyed == 55)
        {
            Greenfoot.setWorld(new IceField());
        }
        if (EnemiesDestroyed >= 48 && timer < 1)
        {
            Greenfoot.setWorld(new IceField());    
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Player player = new Player();
        addObject(player,46,415);
    }
}
