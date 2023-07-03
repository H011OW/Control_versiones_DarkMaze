import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
     private GreenfootImage[] gOver = new GreenfootImage[23];
    private int currentBackgroundIndex = 0;
    //private GreenfootSound amb;
    int n;
    
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
       
        initBackgrounds();
        setBackground(gOver[currentBackgroundIndex]);
       // amb = new GreenfootSound("sounds/amb.mp3");
        //amb.stop();
    }
     public void act()
    {
        checkKeyPressBck();
       
        
    }

    public void checkKeyPressBck()
    {
            currentBackgroundIndex = (currentBackgroundIndex + 1) % gOver.length;
            setBackground(gOver[currentBackgroundIndex]);
            clearPreviousBackground();
             if(currentBackgroundIndex==22){
                 //amb.stop();
                 Greenfoot.stop();
             }
               
            
    }
  
    public void initBackgrounds() {
    int index = 100;
    for (int i = 0; i < 23; i++) {
        String formattedIndex = String.format("%04d", index);
        String filename = "gOver" + formattedIndex + ".jpg";
        gOver[i] = new GreenfootImage(filename);
        index += 2; 
    }
    }
  
    public void clearPreviousBackground() {
        int previousIndex = (currentBackgroundIndex - 1 + gOver.length) % gOver.length;
        gOver[previousIndex].clear();
    }
   
}
