import greenfoot.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.awt.Rectangle;

public class Backgro extends World
{
    private GreenfootImage[] backgrounds = new GreenfootImage[22];
    private int currentBackgroundIndex = 0;
    private YellowCircle yc = new YellowCircle(70);
    private GreenfootSound amb;
    private int z;
    private Corazon c1, c2,c3;
    public Backgro(Corazon c1, Corazon c2, Corazon c3)
    {    
        super(1280, 720, 1);
       /* this.c1=c1;
        this.c2=c2;
        this.c3=c3;
        if(c3!=null) addObject(c3, 425 , 70 ); 
        if(c2!=null) addObject(c2, 350 , 70 );
        if(c1!=null){
           addObject(c1, 275 , 70 ); 
        }else
        Greenfoot.stop();*/
        c1=new Corazon(1);
        addObject(c1, 275 , 70 ); 
        Principal principal = new Principal();
        addObject(principal, getWidth()-830 , getHeight()-120 );
        initBackgrounds();
        setBackground(backgrounds[currentBackgroundIndex]);
        addObject(yc, getWidth()/2 , getHeight()/2 );
        amb = new GreenfootSound("sounds/amb.mp3");
        amb.playLoop();
    }
     public Backgro()
    {    
        super(1280, 720, 1);
        /*addObject(c3, 425 , 70 ); 
        addObject(c2, 350 , 70 );
        addObject(c1, 275 , 70 ); */
               
        Principal principal = new Principal();
        addObject(principal, getWidth()-830 , getHeight()-120 );
        initBackgrounds();
        setBackground(backgrounds[currentBackgroundIndex]);
        addObject(yc, getWidth()/2 , getHeight()/2 );
        amb = new GreenfootSound("sounds/amb.mp3");
        amb.playLoop();
    }
    public void act()
    {
        checkKeyPressBck();
        //updateImage();
        //checkKeyPressBck();
    }

    public void checkKeyPressBck()
    {
        if (Greenfoot.isKeyDown("w"))
        {
            Greenfoot.delay(5);
            currentBackgroundIndex = (currentBackgroundIndex + 1) % backgrounds.length;
            setBackground(backgrounds[currentBackgroundIndex]);
            clearPreviousBackground();
            z++;
            if(z>15){
                Greenfoot.setWorld(new blackWorld());
            }
        }
    }

    public void initBackgrounds() {
    int index = 1;
    for (int i = 0; i < 21; i++) {
        String formattedIndex = String.format("%04d", index);
        String filename = "back" + formattedIndex + ".jpg";
        backgrounds[i] = new GreenfootImage(filename);
        index += 15;  // Increment the index by 2
    }
    }
    /*public void apareceFantasma() {
        //addObject(timerLabel, getWidth() - 400, getHeight() / 10);
        jumpscare = new GreenfootSound("sounds/jumps.mp3");
        jumpscare.play();
        phantom = new Phantom(label);
        addObject(phantom, getWidth() / 2, getHeight() / 2 + 50);
        
        phantom.spawn();
        //addObject(timer, getWidth()-500, getHeight() / 10);
        
        
        addObject(label, getWidth()-200, getHeight() / 10);
     
        //PhantomCount();
        
        //int colisionadorSize = 20; // Tamaño deseado del colisionador
        //int halfSize = colisionadorSize / 2;
        //Rectangle colisionador = new Rectangle(colisionadorSize, colisionadorSize);
        //colisionador.setLocation(phantom.getX() - halfSize, phantom.getY() - halfSize);
        //phantom.setColisionador(colisionador);
        CircleCollider collider = new CircleCollider(15);
        addObject(collider, getWidth() / 2, getHeight() / 2);
        
        
    }*/
    public void clearPreviousBackground() {
        int previousIndex = (currentBackgroundIndex - 1 + backgrounds.length) % backgrounds.length;
        backgrounds[previousIndex].clear();
    }
}
