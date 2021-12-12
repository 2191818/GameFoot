import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GrassField here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GrassField extends World
{
    public static int Currency = 400;

    public static int Lives = 10;

    public static int towerLimit = 6;

    public static int EnemiesDestroyed = 0;

    private int timer = 1500;

    double towerVariable = 1;

    int BulletTowerPrice = 75;

    int AdvancedBulletTowerPrice = 150;

    int worldTime;

    int map [][] = {
            {0,0,0,0,0,0,0,0,0,0},
            {0,2,3,3,3,3,3,0,0,0},
            {0,2,0,0,0,0,5,3,3,3},
            {0,2,0,0,0,0,0,0,0,0},
            {2,3,0,0,0,0,0,0,0,0},
            {2,0,0,0,0,0,0,0,0,0},
            {4,4,4,4,4,2,0,0,0,0},
            {0,0,0,0,0,4,4,4,4,2},
            {0,0,0,0,0,0,0,0,0,2},
            {0,0,0,0,0,0,0,0,0,2},
        };

    public GrassField()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(840, 600, 1);
        Menu menu = new Menu();
        addObject(menu,721,301);
        addObject(new CurrencyDisplay1(), 720, 30);
        addObject(new LivesDisplay1(), 720, 90);
        addObject(new TowersDisplay1(), 720, 150);
        addObject(new EnemiesDestroyedDisplay1(), 720, 210);
        Currency = 400;
        Lives = 10;
        towerLimit = 6;
        EnemiesDestroyed = 0;
        GrassField();
        prepare();
    }

    public void act()
    {
        addInBulletTowers();
        worldTime++;
        spawnWave();
        timer();
        transitionToWorld();
    }

    public void spawnWave()
    {
        if(worldTime % 20 == 0 && worldTime > 200 && worldTime < 1050)
        {
            addObject(new Enemy(), 587, 148);
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void GrassField()
    {
        for(int i = 0; i < 10; i++)
            for(int p = 0; p < 10; p++)
            {
                if(map[p][i] == 1)
                {
                    addObject(new dirtPath(true), 30 + i * 60, 30 + p * 60);
                }
                if(map[p][i] == 2)
                {
                    addObject(new dirtPath(90), 30 + i * 60, 30 + p * 60);
                }
                if(map[p][i] == 3)
                {
                    addObject(new dirtPath(180), 30 + i * 60, 30 + p * 60);
                }
                if(map[p][i] == 4)
                {
                    addObject(new dirtPath(0), 30 + i * 60, 30 + p * 60);
                }
                if(map[p][i] == 5)
                {
                    addObject(new dirtPath(270), 30 + i * 60, 30 + p * 60);
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
        if(EnemiesDestroyed == 45)
        {
            Greenfoot.setWorld(new DesertField());
        }
        if(EnemiesDestroyed >= 30 && timer < 1)
        {
            Greenfoot.setWorld(new DesertField());    
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Player player = new Player();
        addObject(player,586,542);
    }
}
