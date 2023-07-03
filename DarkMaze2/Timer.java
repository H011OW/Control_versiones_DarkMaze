/*import greenfoot.*;  

public class Timer extends Actor 
{
    private int timer=60 ; // about 60 seconds = 55 * 10
    private GreenfootImage[] walkForward = new GreenfootImage[5];
    private int animCounter = 0;
     //private int animationTimer = 55 * 2;
   
    
    public Timer()
    {
        //timer;
       // initAnimationSprites();
       // updateImage();
        //getTime();
    }

    public void act() {
      if (getTime()<11) { // Cambio: se verifica si el temporizador aún no ha terminado
          //  if (timer % 12 == 0) {  
           // animateForward(); // Cambia la imagen utilizando el método animateForward()
            updateImage();
       // }
    //}    
            
        }
        //if (timer < 1) Greenfoot.stop();
        getTime();
       
    }
    public int getTime(){
        timer--;
        Greenfoot.delay(5);   
        return timer;
    }
      public void updateImage() {
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
}*/

import greenfoot.*;  

public class Timer extends Actor 
{
    private int timer = 400; // aproximadamente 60 segundos = 55 * 10
    private GreenfootImage[] walkForward = new GreenfootImage[5];
    private int animCounter = 0;
    private int mod=timer/5;
    public Timer()
    {
        initAnimationSprites();
       // updateImage();
    }

    public void act() {
        timer--; 
        if (timer%mod==0) {
          //  updateImage();
            animateForward();
        }
        
        /*if (timer < 1) {
            Greenfoot.stop();
        }*/
    }
    
    public int getTime() {  
        return timer;
    }
    
    public void updateImage() {
        GreenfootImage image = new GreenfootImage("timer: " + timer/60, 30, Color.WHITE, Color.BLACK);
        setImage(image);
    }
    
    public void initAnimationSprites() {
        for (int i = 0; i < 5; i++) {
            String filename = "a" + (i + 1) + ".png";
            walkForward[i] = new GreenfootImage(filename);
        }
    }
    
    public void animateForward() {
        setImage(walkForward[animCounter % 5]);
        animCounter++;
    }
}
