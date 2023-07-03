import greenfoot.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.awt.Rectangle;

public class PrimCorredor extends World
{
    private GreenfootImage[] backgrounds = new GreenfootImage[22];
    private int currentBackgroundIndex = 0;
    private YellowCircle yc = new YellowCircle(70);
    private GreenfootSound amb;
    private int z;
    private Corazon c1, c2,c3;
    private int n,banderaNivel;
    private Fed fedIn;
     public PrimCorredor()
    {   
        super(1280, 720, 1);
        n=3;//num corazon
        banderaNivel=1;
      
        c1=new Corazon();
        c2=new Corazon();
        c3=new Corazon();
        addObject(c3, 425 , 70 ); 
        addObject(c2, 350 , 70 );
        addObject(c1, 275 , 70 );
               
        Principal principal = new Principal();
        addObject(principal, getWidth()-1000 , getHeight()-50);
        initBackgrounds();
        setBackground(backgrounds[currentBackgroundIndex]);
        addObject(yc, getWidth()/2 , getHeight()/2 );
        amb = new GreenfootSound("sounds/amb.mp3");
        amb.playLoop();
    }
      public PrimCorredor(int n, int banderaNivel)
    {    
        super(1280, 720, 1);
        this.n=n;
        this.banderaNivel=banderaNivel;
        if(n==2){
        c1=new Corazon();
        c2=new Corazon();
        addObject(c1, 275 , 70 );
        addObject(c2, 350 , 70 );
        }else if(n==1){
            c1=new Corazon();
            addObject(c1, 275 , 70 );
        }else if(n==3){
            c1=new Corazon();
            c2=new Corazon();
            c3=new Corazon();
            addObject(c3, 425 , 70 ); 
            addObject(c2, 350 , 70 );
            addObject(c1, 275 , 70 );
        }
          
        Principal principal = new Principal();
        addObject(principal, getWidth()-1000 , getHeight()-50);
        initBackgrounds();
        setBackground(backgrounds[currentBackgroundIndex]);
        addObject(yc, getWidth()/2 , getHeight()/2 );
        amb = new GreenfootSound("sounds/amb.mp3");
        amb.play();
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
            currentBackgroundIndex = (currentBackgroundIndex + 1) % backgrounds.length;
            setBackground(backgrounds[currentBackgroundIndex]);
            clearPreviousBackground();
            z++;
            if(z>19){
                fedIn = new Fed();
                addObject(fedIn ,getWidth()/2 , getHeight()/2);
                fedIn.fedOutAnim();
                amb.stop();
                Greenfoot.setWorld(new BlackWorld(n,banderaNivel));
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
  
    public void clearPreviousBackground() {
        int previousIndex = (currentBackgroundIndex - 1 + backgrounds.length) % backgrounds.length;
        backgrounds[previousIndex].clear();
    }
}
