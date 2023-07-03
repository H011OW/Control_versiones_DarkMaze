import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inicio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inicio extends World
{
    private GreenfootImage[] inicio = new GreenfootImage[22];
    private int currentBackgroundIndex = 0;
    private GreenfootSound amb;
    private int z=0;
    public Inicio()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        initBackgrounds();
        setBackground(inicio[currentBackgroundIndex]);
        amb = new GreenfootSound("sounds/amb.mp3");
        amb.playLoop();
    }
     public void act()
    {
        checkKeyPressBck();
        
    }

    public void checkKeyPressBck()
    {
        if (Greenfoot.isKeyDown("w"))
        {
            Greenfoot.delay(5);
            currentBackgroundIndex = (currentBackgroundIndex + 1) % inicio.length;
            setBackground(inicio[currentBackgroundIndex]);
            clearPreviousBackground();
            z++;
            if(z>20){
                Greenfoot.setWorld(new Backgro());
            }
        }
    }

    public void initBackgrounds() {
    int index = 1;
    for (int i = 0; i < 21; i++) {
        String formattedIndex = String.format("%04d", index);
        String filename = "inicio" + formattedIndex + ".jpg";
        inicio[i] = new GreenfootImage(filename);
        index += 12; 
    }
    }
  
    public void clearPreviousBackground() {
        int previousIndex = (currentBackgroundIndex - 1 + inicio.length) % inicio.length;
        inicio[previousIndex].clear();
    }
}
