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
    private boolean beingTouched = false;
    private Label label;
    private Timer timer;
    private Corazon c1;
    private Corazon c2;
    private Corazon c3;
    private boolean aparece =false;
    
    private boolean bandera=true;
    public Phantom (Label label, Timer timer){
        this.label = label;
        this.timer=timer;
       // this.bandera=true;
        colisionador = new Rectangle(colisionadorSize, colisionadorSize);
        initAnimationSpritesIdle();
        initAnimationSpritesSpawn();
     
      
    }
    public void act()
    {
        
        //animateidle();
         if(aparece == false){
          spawn();
          aparece=true;
          //setLocation(getX(), getY());
          return;
        }
        mover();
        checkCollision();
        checkLabelCount();
        checkTimerCount();
        updateLabelPosition();
    }
    private void mover() {
        if (!beingTouched) {
        // Restablecer velocidad normal
        velocidadMaxima = 5;
        aceleracion = 1;
        }
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
        animateIdleWithDelay();
    }
    

    public void idle (){
        //animateidle();
        animateIdleWithDelay();
       // setLocation(getX(),getY());
       
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
            //setLocation(getX(),getY());
            Greenfoot.delay(5); // Agregar un pequeño retraso entre cada fotograma
        }
    
      //  spawn = null;
       
    }
    public void animateSpawn(){
        if (animCounterSpawn == 7){
                Greenfoot.delay(15);
            }
        setImage(spawn[animCounterSpawn % 12]);
        animCounterSpawn++;
    }
    
    public void checkCollision() {
    CircleCollider collider = (CircleCollider) getOneIntersectingObject(CircleCollider.class);
    if (collider != null) {
        increaseSpeed();
        label.act2();
        beingTouched = true; // Está siendo tocado
    } else {
        beingTouched = false; // No está siendo tocado
    }
    }
   
    public void increaseSpeed() {
    velocidadMaxima += 2; // Aumentar la velocidad máxima en 2 unidades
    aceleracion += 1; // Aumentar la aceleración en 1 unidad
    }
    
    public void checkLabelCount() { //VENCE PERSONAJE A FANTASMA
    if (label != null && label.getCount() == 0) {
        // El contador del Label llegó a 0, desaparecer el fantasma y el Label
        
        World world= getWorld();
        if (getWorld() != null) {
            world.removeObject(this);
            world.removeObject(label);
            world.removeObject(timer);
            Greenfoot.setWorld(new Backgro());
        }
      }
    }

       public void checkTimerCount() {//PIERDE PERSONAJE CON FANTASMA
    if (timer != null && timer.getTime() < 0) {
        World world= getWorld();
        initAnimationSpritesSpawn();
        spawn();
        Greenfoot.setWorld(new Backgro());
      }
  
    }
    
    private void updateLabelPosition() {
    if (label != null && getWorld() != null) {
        int offsetX = 10; // Ajusta el desplazamiento horizontal de la etiqueta
        int offsetY = 10; // Ajusta el desplazamiento vertical de la etiqueta
        if (getWorld().getObjects(Phantom.class).contains(this)) {
            label.setLocation(getX() + offsetX, getY() + offsetY -120);
        }
    }
    }

    

}
