import greenfoot.*;

public class Backgro extends World
{
    private GreenfootImage[] backgrounds = new GreenfootImage[12];
    private int currentBackgroundIndex = 0;

    public Backgro()
    {    
        super(600, 400, 1);
        Principal principal = new Principal(this);
        addObject(principal, getWidth() / 2, getHeight() / 2);
        initBackgrounds();
        setBackground(backgrounds[currentBackgroundIndex]);
    }

    public void act()
    {
        //checkKeyPressBck();
    }

    public void checkKeyPressBck()
    {
        //if (Greenfoot.isKeyDown("w"))
        //{
            currentBackgroundIndex = (currentBackgroundIndex + 1) % backgrounds.length;
            setBackground(backgrounds[currentBackgroundIndex]);
        //}
    }

    public void initBackgrounds()
    {
        for (int i = 0; i < 12; i++)
        {
            String filename = "es" + (i+1) + ".png";
            backgrounds[i] = new GreenfootImage(filename);
        }
    }
}
