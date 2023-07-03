import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Corazon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Corazon extends Actor
{
    private int nCorazon;
    public Corazon(){
        
       
    } 
    
    public void act()
    {
        // Add your action code here.
    }
    public void removeVida(){
         getWorld().removeObject(this);
    }
    
}

