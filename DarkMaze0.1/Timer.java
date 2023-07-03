import greenfoot.*;

public class Timer extends Actor 
{
    private int timer=60 ; // about 60 seconds = 55 * 10
    private GreenfootImage[] walkForward = new GreenfootImage[5];
    private int animCounter = 0;
     //private int animationTimer = 55 * 2;
   
    /**
     * Constructor for objects of class Timer
     */
    public Timer()
    {
        //timer;
        initAnimationSprites();
        //updateImage();
      
    }

    public void act() {
      
       timer--;
       Greenfoot.delay(10);
        if (timer>= 0) { // Cambio: se verifica si el temporizador aún no ha terminado
            if (timer % 12 == 0) {
            animateForward(); // Cambia la imagen utilizando el método animateForward()
            }
            //timer--;
            //updateImage();
           // animateForward();
            
        }
        if (timer < 1) Greenfoot.stop();
    }
      private void updateImage() {
        GreenfootImage image = new GreenfootImage("timer: " + timer, 30, Color.WHITE, Color.BLACK);
        setImage(image);
    }
    
     public void initAnimationSprites()
    {
        for (int i = 0; i < 5; i++) {
            String filename = "a" + (i + 1) + ".png";
            walkForward[i] = new GreenfootImage(filename);
        }
    }
    
    public void animateForward()
    {
        setImage(walkForward[animCounter % 5]);
        animCounter++;
      
    }
}