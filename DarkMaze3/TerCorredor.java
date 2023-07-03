import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class terCorredor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TerCorredor extends World
{
    private GreenfootImage[] terCorredor = new GreenfootImage[24];
    private int currentBackgroundIndex = 0;
    private GreenfootSound amb;
    private int z=0;
     private YellowCircle yc = new YellowCircle(70);
    private Corazon c1, c2,c3;
    private int n,banderaNivel;
    private Fed fedIn;
    public TerCorredor(int n, int banderaNivel)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
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
        
        initBackgrounds();
        setBackground(terCorredor[currentBackgroundIndex]);
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
            Greenfoot.delay(8);
            currentBackgroundIndex = (currentBackgroundIndex + 1) % terCorredor.length;
            setBackground(terCorredor[currentBackgroundIndex]);
            clearPreviousBackground();
            z++;
            if(z>23){
                amb.stop();
                fedIn = new Fed();
                addObject(fedIn ,getWidth()/2 , getHeight()/2);
                fedIn.fedOutAnim();
                Greenfoot.setWorld(new BlackWorld(n,banderaNivel ));
            }
        }
    }

    public void initBackgrounds() {
    int index = 1;
    for (int i = 0; i < 24; i++) {
        String formattedIndex = String.format("%04d", index);
        String filename = "terCorredor" + formattedIndex + ".jpg";
        terCorredor[i] = new GreenfootImage(filename);
        index += 22; 
    }
    }
  
    public void clearPreviousBackground() {
        int previousIndex = (currentBackgroundIndex - 1 + terCorredor.length) % terCorredor.length;
        terCorredor[previousIndex].clear();
    }
}
