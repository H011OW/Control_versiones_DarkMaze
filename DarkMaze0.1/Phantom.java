import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Rectangle;
/**
 * Write a description of class Phantom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Phantom extends Actor
{
    GreenfootImage[] idle = new GreenfootImage[12];
    GreenfootImage[] spawn = new GreenfootImage[12];
    
    private int velocidadMaxima = 5;
    private int velocidadActual = 0;
    private int aceleracion = 1;
    private int direccionX = 1;
    private int direccionY = 1;
    

    private int colisionadorSize = 1;
    private Rectangle colisionador;
    private int animIdleCounter = 0;
    private int animCounterSpawn = 0;
    private int delayCounter = 0;
    private int delayDuration = 10; // Duración del retraso en act cycles
    //private boolean velocidadAumentada = false;
  
    Label la = new Label();
    public Phantom (){
        colisionador = new Rectangle(1,1);
        initAnimationSpritesIdle();
        initAnimationSpritesSpawn();
        getWorld().addObject(la, getWorld().getWidth()-200, getWorld().getHeight() / 10);
    }
    public void act()
    {
        //animateidle();
        mover();
        animateIdleWithDelay();
        //if(isTouching(Colisionador.class)){
            //la.act2();
        //} 
    }
    private void mover() {
        // Actualizar la velocidad actual según la aceleración
        velocidadActual += aceleracion;

        // Limitar la velocidad máxima
        if (velocidadActual > velocidadMaxima) {
            velocidadActual = velocidadMaxima;
        }

        // Actualizar la posición según la velocidad actual y la dirección de movimiento
        int x = getX() + (direccionX * velocidadActual);
        int y = getY() + (direccionY * velocidadActual);

        // Verificar si el objeto está cerca de los límites de la pantalla
        World world = getWorld();
        int maxX = world.getWidth() - 1;
        int maxY = world.getHeight() - 1;

        if ((direccionX == 1 && direccionY == 1) && (x >= maxX || y >= maxY)) {
            // Cambiar la dirección hacia arriba o hacia la izquierda para evitar la esquina
            if (Greenfoot.getRandomNumber(2) == 0) {
                direccionX = -1;
            } else {
                direccionY = -1;
            }
        } else if ((direccionX == -1 && direccionY == 1) && (x <= 0 || y >= maxY)) {
            // Cambiar la dirección hacia arriba o hacia la derecha para evitar la esquina
            if (Greenfoot.getRandomNumber(2) == 0) {
                direccionX = 1;
            } else {
                direccionY = -1;
            }
        } else if ((direccionX == 1 && direccionY == -1) && (x >= maxX || y <= 0)) {
            // Cambiar la dirección hacia abajo o hacia la izquierda para evitar la esquina
            if (Greenfoot.getRandomNumber(2) == 0) {
                direccionX = -1;
            } else {
                direccionY = 1;
            }
        } else if ((direccionX == -1 && direccionY == -1) && (x <= 0 || y <= 0)) {
            // Cambiar la dirección hacia abajo o hacia la derecha para evitar la esquina
            if (Greenfoot.getRandomNumber(2) == 0) {
                direccionX = 1;
            } else {
                direccionY = 1;
            }
        }

        // Actualizar la posición del objeto
        setLocation(x, y);
        
    }

    
    
    public void idle (){
        //animateidle();
        animateIdleWithDelay();
        setLocation(getX(),getY());
    }
    public void initAnimationSpritesIdle() {
        int index = 13;
        for (int i = 0; i < 12; i++) {
            String formattedIndex = String.format("%04d", index);
            String filename = "idle" + formattedIndex + ".png";
            idle[i] = new GreenfootImage(filename);
            index += 1;
        }
    }
    /*public void animateidle(){
        setImage(idle[animIdleCounter%4]);
        animIdleCounter++;
    }*/
    public void animateIdleWithDelay() {
        if (delayCounter < delayDuration) {
            delayCounter++;
        } else {
            setImage(idle[animIdleCounter % 12]);
            animIdleCounter++;
            delayCounter = 0;
        }
    }
    

    
    
    public void initAnimationSpritesSpawn(){
        int index2 = 1;
        for (int i = 0; i < 12; i++) {
        String formattedIndex = String.format("%04d", index2);
            String filename = "Spawn" + formattedIndex + ".png";
            spawn[i] = new GreenfootImage(filename);
            index2 += 1;  // Increment the index by 2
        }
    }
    public void spawn() {
        for (int i = 0; i < 12; i++) {
            animateSpawn();
            setLocation(getX(),getY());
            Greenfoot.delay(2); // Agregar un pequeño retraso entre cada fotograma
        }
    }
    public void animateSpawn(){
        if (animCounterSpawn == 7){
                Greenfoot.delay(15);
            }
        setImage(spawn[animCounterSpawn % 12]);
        animCounterSpawn++;
    }
}
