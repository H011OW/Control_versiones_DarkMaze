import greenfoot.*; 

public class CircleCollider extends Actor {
    private int radius; // Radio del colisionador

    public CircleCollider(int radius) {
        this.radius = radius;
        GreenfootImage image = new GreenfootImage(2 * radius, 2 * radius);
        image.setColor(Color.RED); // El color rojo es solo para visualización, puedes cambiarlo si lo deseas
        image.fillOval(0, 0, 2 * radius, 2 * radius);
        setImage(image);
    }
    public void act() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            setLocation(mouse.getX(), mouse.getY());
        }
    }
}
