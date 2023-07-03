import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fin extends World
{

    private GreenfootImage[] fin = new GreenfootImage[15];
    private int currentBackgroundIndex = 0;
    //private GreenfootSound amb;
    private int z,n;
    private Fed fedIn;
    private boolean time = false;
    public Fin()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        //this.n=n;
        initBackgrounds();
        //setBackground(fin[currentBackgroundIndex]);
        //amb = new GreenfootSound("sounds/amb.mp3");
        //amb.playLoop();
    }
     public void act()
    {
        if(time == false){
            currentBackgroundIndex = (currentBackgroundIndex + 1) % fin.length;
            setBackground(fin[currentBackgroundIndex]);
            clearPreviousBackground();
            fedIn = new Fed();
            addObject(fedIn ,getWidth()/2 , getHeight()/2);
            fedIn.fedInAnim();
            removeObject(fedIn);
            
            time=true;
        }
        checkKeyPressBck();
        
    }

    public void checkKeyPressBck()
    {
        if (Greenfoot.isKeyDown("w"))
        {
            Greenfoot.delay(5);
            currentBackgroundIndex = (currentBackgroundIndex + 1) % fin.length;
            setBackground(fin[currentBackgroundIndex]);
            clearPreviousBackground();
            z++;
            if(z>14){
                // amb.stop();
                 Greenfoot.setWorld(new GameOver());                
            }
        }
    }

    public void initBackgrounds() {
    int index = 20;
    for (int i = 0; i < 15; i++) {
        String formattedIndex = String.format("%04d", index);
        String filename = "fin" + formattedIndex + ".jpg";
        fin[i] = new GreenfootImage(filename);
        index += 19; 
    }
    }
  
    public void clearPreviousBackground() {
        int previousIndex = (currentBackgroundIndex - 1 + fin.length) % fin.length;
        fin[previousIndex].clear();
    }
}