import greenfoot.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.awt.Rectangle;

public class Backgro extends World
{
    //private GreenfootImage[] backgrounds = new GreenfootImage[36];
    //private int currentBackgroundIndex = 1;
    private GreenfootImage[] backgrounds = new GreenfootImage[13];
    private int currentBackgroundIndex = 0;
    private Timer timer = new Timer();
    private Phantom phantom = new Phantom();
    private Label label = new Label();
    private GreenfootSound bkgMusic;
    // private int count = 100;
   // TimerLabel timerLabel = new TimerLabel();
    public Backgro()
    {    
        super(1280, 720, 1);
        Principal principal = new Principal(this);
        addObject(principal, getWidth()-400 , getHeight()-100 );
        //Flashlight flashlight = new Flashlight();
        //addObject(flashlight, getWidth()/2 , getHeight()/2 );
        initBackgrounds();
        setBackground(backgrounds[currentBackgroundIndex]);
        Corazon cora = new Corazon();
        addObject(cora, 275 , 70 );
        Corazon cora2 = new Corazon();
        addObject(cora2, 350 , 70 );
        Corazon cora3 = new Corazon();
        addObject(cora3, 425 , 70 );
        int yellowCircleRadius = 50; // Elige el radio deseado para el círculo amarillo
        YellowCircle yellowCircle = new YellowCircle(yellowCircleRadius);
        addObject(yellowCircle, getWidth()/2 , getHeight()/2); // Reemplaza 'world' con la referencia a tu mundo y 'x', 'y' con las coordenadas donde deseas agregar el círculo amarillo

        
    }

    public void act()
    {
        //updateImage();
        //checkKeyPressBck();
    }

    public void checkKeyPressBck()
    {
        //if (Greenfoot.isKeyDown("w"))
        //{
            currentBackgroundIndex = (currentBackgroundIndex + 1) % backgrounds.length;
            setBackground(backgrounds[currentBackgroundIndex]);
            //liberarMemoria();
        //}
    }

    public void initBackgrounds() {
        //int index = 1;
        for (int i = 0; i < 13; i++) {
            //String formattedIndex = String.format("%04d", index);
            //String filename = "back" + formattedIndex + ".png";
            //String filename = "back" + index + ".png";
            String filename = "es" + i + ".png";
            backgrounds[i] = new GreenfootImage(filename);
            //index += 10;  // Increment the index by 2
        }
    }
    public void liberarMemoria() {
    for (int i = 0; i < backgrounds.length; i++) {
        if (i != currentBackgroundIndex) {
            backgrounds[i] = null; // Elimina la referencia a la imagen
        }
    }
    }

    
    public void apareceFantasma() {
    //addObject(timerLabel, getWidth() - 400, getHeight() / 10);    
    //addObject(timer, getWidth()-500, getHeight() / 10);
    addObject(phantom, getWidth() / 2, getHeight() / 2 + 50);
    
    //addObject(label, getWidth()-200, getHeight() / 10);
 
    //PhantomCount();
    
    //int colisionadorSize = 20; // Tamaño deseado del colisionador
    //int halfSize = colisionadorSize / 2;
    //Rectangle colisionador = new Rectangle(colisionadorSize, colisionadorSize);
    //colisionador.setLocation(phantom.getX() - halfSize, phantom.getY() - halfSize);
    //phantom.setColisionador(colisionador);
    bkgMusic = new GreenfootSound("sounds/jumps.mp3");
    phantom.spawn(); // Llamada al método después de agregar el actor al mundo
    
    
    }
    /*public void desapareceFantasma() {
         if (label.act2() == 0) {
        removeObject(phantom);
    }*/
    
    //}
    public void pierdeVida(){
         
    }
}
