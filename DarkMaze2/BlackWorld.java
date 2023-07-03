import greenfoot.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.awt.Rectangle;

public class BlackWorld extends World
{
    //private Principal principal = new Principal();
    private int n,banderaNivel;
    private Timer timer = new Timer();
    private Label label = new Label();
    private Phantom phantom;
    private YellowCircle yc = new YellowCircle(70);
    private GreenfootSound jumpscare;
    Corazon c1,c2,c3;
    private Door door1;
    private Door door2;
    private Door door3;
   // private rand=Green
    public BlackWorld(int n, int banderaNivel)
    {  
        super(1280, 720, 1);
        this.n=n;
       // Principal principal = new Principal();
       // addObject(principal, getWidth()-830 , getHeight()-120 );
        setBackground("fondoNegro.jpg"); 
        door1 = new Door(this,3,n,banderaNivel);
        door2 = new Door(this, 2,n,banderaNivel);
        door3 = new Door(this,1,n,banderaNivel);
        addObject(door1, getWidth()-1065 , getHeight()-305);
        addObject(door2, getWidth()-640 , getHeight()-305);
        addObject(door3, getWidth()-212 , getHeight()-305);
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
        
      
      //  apareceFantasma();
        
    }
   
    public void act()
    {
       
    }

    public void apareceFantasma() {
        jumpscare = new GreenfootSound("sounds/jumps.mp3");
        jumpscare.play();
        phantom = new Phantom(label, timer,n,banderaNivel);
        addObject(phantom, getWidth() / 2, getHeight() / 2 + 50);
        addObject(timer, getWidth()-500, getHeight() / 10);
        addObject(label, getWidth()-200, getHeight() / 10);
        CircleCollider collider = new CircleCollider(15);
        addObject(yc, getWidth()/2 , getHeight()/2 );
        addObject(collider, getWidth() / 2, getHeight() / 2);
        removeObject(door1);
       // removeObject(door2);
        removeObject(door3);
        
    }
    
    public void desapareceFantasma() {
         if (label.act2() == 0) {
        removeObject(phantom);
        }
    }
}

