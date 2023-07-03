import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fed extends Actor
{
    /**
     * Act - do whatever the Fed wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage[] fed = new GreenfootImage[4];
    private int currentBackgroundIndex = 0;
    
    public Fed(){
        initFedIn();
    }
    public void act()
    {
        
        
    }
    public void fedInAnim(){
        
        setImage(fed[0]);
        Greenfoot.delay(25); 
        for(int i = 0;i<4;i++){
            /*
            Greenfoot.delay(10);    
            currentBackgroundIndex = (currentBackgroundIndex + 1) % fed.length;
            setImage(fed[currentBackgroundIndex]);
            clearPreviousBackground();
            */
            //jumpscare.play();
            Greenfoot.delay(9); 
            setImage(fed[i]);
        }     
    }
    public void fedOutAnim(){
        
        for(int i = 3;  i>0;i--){
            //jumpscare.play();
            Greenfoot.delay(5);    
            setImage(fed[i]);
        }     
    }
    public void clearPreviousBackground() {
        int previousIndex = (currentBackgroundIndex - 1 + fed.length) % fed.length;
        fed[previousIndex].clear();
    }
    public void initFedIn() {
        fed[0]=new GreenfootImage("fed1.png");
        fed[1]=new GreenfootImage("fed2.png");
        fed[2]=new GreenfootImage("fed3.png");
        fed[3]=new GreenfootImage("fed4.png");
    }
}
