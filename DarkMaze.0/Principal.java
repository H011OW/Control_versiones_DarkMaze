import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Principal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Principal extends Actor
{
    /**
     * Act - do whatever the Principal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] walkForward = new GreenfootImage[4];
    private GreenfootImage[] backgrounds = new GreenfootImage[7];
    private int currentBackgroundIndex = 0;
    
    int animCounter = 0;
    private int keyCooldown = 0;
    private final int COOLDOWN_TIME = 7;
    private Backgro world;
    
    public Principal(Backgro world){
        initAnimationSprites();
        this.world = world;
    }
    public void act()
    {
        // Add your action code here.
        checkKeys();

    }
    public void checkKeys(){
        if (keyCooldown > 0)
        {
            keyCooldown--;
        }
        if(Greenfoot.isKeyDown("w") && keyCooldown == 0){
            moveForward();
            world.checkKeyPressBck();
            //moveForwardBack();
            keyCooldown = COOLDOWN_TIME;
        }
    }
    public void moveForward(){
        animateFoward();
        setLocation(getX(),getY());
    }
    /*public void moveForwardBack(){
        currentBackgroundIndex = (currentBackgroundIndex + 1) % backgrounds.length;
            //setBackground(backgrounds[currentBackgroundIndex]);
            initBackgrounds();
    }
    
    public void initBackgrounds()
    {
        for (int i = 0; i < 8; i++)
        {
            String filename = "img" + i + ".jpeg";
            backgrounds[i] = new GreenfootImage(filename);
        }
    }*/
    
    public void initAnimationSprites(){
        for(int i = 0; i<4; i++){
            String filename = "s"+i+".png";
            walkForward[i] = new GreenfootImage(filename);
            
        }
    }
    public void animateFoward(){
        setImage(walkForward[animCounter%4]);
        animCounter++;
    }
}
