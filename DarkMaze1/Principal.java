import greenfoot.*;  
import java.util.ArrayList;

public class Principal extends Actor
{
    private boolean stepRigth = true;
 
    public Principal(){
    }
    public void act()
    {
        checkKeys();

    }
    public void checkKeys(){
        if(Greenfoot.isKeyDown("w")){
            Greenfoot.delay(5);
            moveForward();
        }
        //if(avtivePhatom==true)
        //world.desapareceFantasma();
    }
    public void moveForward(){
        animateFoward();
    }

    public void animateFoward(){
        if(stepRigth){
            setLocation(getX()-7,getY()-10);
            stepRigth=false;
        }else{
            setLocation(getX()+7,getY()+10);
            stepRigth=true;
        }
    }
}
