import greenfoot.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.awt.Rectangle;

public class blackWorld extends World
{
    //private Principal principal = new Principal();
    /*private Door door1 = new Door();
    private Door door2 = new Door();
    private Door door3 = new Door();*/
    private Timer timer = new Timer();
    private Label label = new Label();
    private Phantom phantom;
    private YellowCircle yc = new YellowCircle(70);
    private GreenfootSound jumpscare;
    Corazon c1;
    public blackWorld()
    {    
        super(1280, 720, 1);
       // Principal principal = new Principal(this);
        //addObject(principal, getWidth()-400 , getHeight()-100 );
        setBackground("back0316.jpg"); 
       
       /* this.c1=c1;
        this.c2=c2;
        this.c3=c3;
        if(c3!=null) addObject(c3, 425 , 70 ); 
        if(c2!=null) addObject(c2, 350 , 70 );
        if(c1!=null)
           addObject(c1, 275 , 70 ); */
        
        //addObject(principal, getWidth()-830 , getHeight()-120 );
        addObject(yc, getWidth()/2 , getHeight()/2 );
       /* addObject(door1, getWidth()/3 , getHeight()/3);
        addObject(door2, getWidth()/3*2 , getHeight()/3);
        addObject(door3, getWidth()/3*3 , getHeight()/3);*/

        apareceFantasma();
        
    }
   
    public void act()
    {
        //updateImage();
        //checkKeyPressBck();
    }

    public void apareceFantasma() {
        jumpscare = new GreenfootSound("sounds/jumps.mp3");
        jumpscare.play();
        phantom = new Phantom(label, timer);
        addObject(phantom, getWidth() / 2, getHeight() / 2 + 50);
       addObject(timer, getWidth()-500, getHeight() / 10);
       addObject(label, getWidth()-200, getHeight() / 10);
        CircleCollider collider = new CircleCollider(15);
        addObject(collider, getWidth() / 2, getHeight() / 2);
      
        
    }
    
    public void desapareceFantasma() {
         if (label.act2() == 0) {
        removeObject(phantom);
        }
    }
}

