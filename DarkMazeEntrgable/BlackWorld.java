import greenfoot.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
public class BlackWorld extends World
{
    //private Principal principal = new Principal();
    private int n,banderaNivel;
    private Timer timer = new Timer();
    private Label label = new Label();
    private Phantom phantom;
    private YellowCircle yc = new YellowCircle(70);
    private List<Integer> numbers = new ArrayList<>();
    private GreenfootSound jumpscare;
    Corazon c1,c2,c3;
    private Door door1;
    private Door door2;
    private Door door3;
    private int numR1, numR2, numR3;
    private Fed fedIn;
    private boolean time = false;
    public BlackWorld(int n, int banderaNivel)
    {  
        super(1280, 720, 1);
        this.n=n;
        this.banderaNivel=banderaNivel;
        numbers= generateRandomNumbers();
        numR1= numbers.get(0);
        numR2= numbers.get(1);
        numR3= numbers.get(2);
        setBackground("fondoNegro.jpg"); 
        door1 = new Door(this,numR1,n,banderaNivel);
        door2 = new Door(this, numR2,n,banderaNivel);
        door3 = new Door(this,numR3,n,banderaNivel);
        
       
        
        
    }
   
    public void act()
    {
       if(time == false){
            fedIn = new Fed();
            addObject(fedIn ,getWidth()/2 , getHeight()/2);
            fedIn.fedInAnim();
            removeObject(fedIn);
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
            time=true;
        }
    }
   public List<Integer> generateRandomNumbers() {
  //  List<Integer> numbers = new ArrayList<>();

    // Generar tres números aleatorios
    for (int i = 0; i < 3; i++) {
        int number;
        do {
            number = Greenfoot.getRandomNumber(3) + 1;
        } while (numbers.contains(number));
        numbers.add(number);
    }

    return numbers;
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