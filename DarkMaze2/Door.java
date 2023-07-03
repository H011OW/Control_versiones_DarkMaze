import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class g here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends Actor
{
    /**
     * Act - do whatever the g wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private BlackWorld world;
    int destino;
    int n,banderaNivel;
    private GreenfootImage[] anima = new GreenfootImage[16];
    private int animCounter = 0;
    private boolean aparece =false;
    public Door (BlackWorld world,int destino, int n,int banderaNivel){
        this.world = world;
        this.destino = destino;
        this.n=n;
        this.banderaNivel=banderaNivel;
        setImage("doorClosed.jpg"); 
        initAnimationSprites();

    }
    public void act()
    {
      
        if (Greenfoot.mouseClicked(this)) {
        // Se ha hecho clic en la puerta
         //setImage("doorOpen.jpg"); // Cambiar la imagen a "doorOpen.jpg"
            if(destino==3){
                banderaNivel++;
                bandera();
                if(banderaNivel==2){
                    Greenfoot.setWorld(new Resplandor(n,banderaNivel));
                }else if(banderaNivel==3)
                    Greenfoot.setWorld(new TerCorredor(n,banderaNivel));
                else if(banderaNivel==4)
                    Greenfoot.setWorld(new Fin()); 
            }else if(destino==2){
                bandera();
                world.apareceFantasma();
                
            }else if(destino==1){
                bandera();
                Greenfoot.setWorld(new Backgro());
            }
        }
        
        
    }
    public void bandera(){
        if(aparece == false){
              openDoor();
              aparece=true;
             // return;
            }
    }
      public void initAnimationSprites() {
    int index = 1;
    for (int i = 0; i < 16; i++) {
        String formattedIndex = String.format("%04d", index);
        String filename = "anima" + formattedIndex + ".jpg";
        anima[i] = new GreenfootImage(filename);
        index += 12; 
        }
   
    }
  
    public void animateDoor(){   
        setImage(anima[animCounter % 16]);
        animCounter++;
        
    }
     public void openDoor() {
       
        for (int i = 0; i < 16; i++) {
            Greenfoot.delay(3);// Agregar un pequeño retraso entre cada fotograma
            animateDoor();
           
        }
       
    }
    
}
