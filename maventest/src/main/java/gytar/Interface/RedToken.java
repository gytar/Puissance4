package gytar.Interface;
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 

public class RedToken {
    private int dx, dy; 
    private int x = 450; 
    private int y = 100; 
    private int w = 100, h = 85; 
    private Image image; 

    public RedToken() {
        loadImage();
    }

    private void loadImage() {
        ImageIcon ii = new ImageIcon("/home/gytar/Documents/Dev/Cyberfull/java-algo/src/cyberfull_java/java_animation/resources/realredball.png"); 
        image = ii.getImage(); 
  
        
    }

    public void move() {
        x += dx; 
        y += dy; 
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return w;
    }

    public int getHeight() {
        return h;
    }

    public Image getImage() {
        return image;
    }

    

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_RIGHT) {
            dx = 10; 
        }

        if(key == KeyEvent.VK_LEFT) {
            dx = -10; 
        }

        if(key == KeyEvent.VK_ENTER) { 
            dy = 5;   
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode(); 

        if(key == KeyEvent.VK_RIGHT) {
            dx = 0; 
        }
        if(key == KeyEvent.VK_LEFT) {
            dx = 0;
        }
    }
}
