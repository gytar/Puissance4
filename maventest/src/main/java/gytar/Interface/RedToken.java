package gytar.Interface;
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 

public class RedToken {
    private int dx, dy; 
    private int x = 450; 
    private int y = 0; 
    private int w = 130, h = 130; 
    private Image image; 

    public RedToken() {
        loadImage();
    }

    private void loadImage() {
        ImageIcon ii = new ImageIcon("/home/gytar/Documents/Dev/p4-cf/Puissance4/maventest/src/main/java/gytar/Interface/ressources/redToken.png"); 
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
            if(x < 890) {
                dx = 1;
            } else {
                dx = 0;     
            }         
        }

        if(key == KeyEvent.VK_LEFT) {
            if(x > 5) {
                dx = -1; 
            } else {
                dx = 0; 
            }
            
        }

        if(key == KeyEvent.VK_ENTER) { 
            if(y < 600) {
                dy = 1; 
            } else {
                dy = 0; 
            }
            
             
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
