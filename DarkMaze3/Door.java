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
    private Fed fedIn;
    private GreenfootSound answer;
    private boolean aparece =false;
    public Door (BlackWorld world,int destino, int n,int banderaNivel){
        this.world = world;
        this.destino = 3;
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
                answer = new GreenfootSound("sounds/correct.mp3");
                answer.play();
                fedIn = new Fed();
                world.addObject(fedIn ,world.getWidth()/2 , world.getHeight()/2);
                fedIn.fedOutAnim();
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
                answer = new GreenfootSound("sounds/incorrect.mp3");
                answer.play();
                Greenfoot.setWorld(new Backgro(n,1));
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
