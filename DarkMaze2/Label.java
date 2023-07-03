import greenfoot.*;    // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Label here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Label extends Actor
{
     private int delayR; 
    private int count;

    public Label() {
        count = 100;
       
        updateImage();
    }

    public void act() {
         
    }
      // count--;
       // updateImage();
       public int act2(){
         delayR=Greenfoot.getRandomNumber(3);
         count-=delayR;
         Greenfoot.delay(delayR);
          if(count > 0){
            updateImage();
          }else{
           count=0;
           updateImage();
          }// Cambio: se verifica si el temporizador aún no ha terminado
           return count;
       }
      private void updateImage() {
        GreenfootImage image = new GreenfootImage("Vida: " + count, 25, Color.WHITE, Color.BLACK);
        setImage(image);
    }
    public int getCount() {
    return count;
    }

}
