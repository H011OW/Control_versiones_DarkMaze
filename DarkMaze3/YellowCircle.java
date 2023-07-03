import greenfoot.*; 

public class YellowCircle extends Actor {
    private int radius; // Radio del círculo
    
    

    public YellowCircle(int radius) {
        this.radius = radius;
        GreenfootImage image = new GreenfootImage(2 * radius, 2 * radius);
        image.setColor(Color.YELLOW);
        image.fillOval(0, 0, 2 * radius, 2 * radius);
        setImage(image);
        setTransparency(50);
    }
    
    public void act() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            setLocation(mouse.getX(), mouse.getY());
        }
    }
    public void setTransparency(int alpha) {
        GreenfootImage image = getImage();
        image.setTransparency(alpha);
        setImage(image);
    }

}
