package gytar.Interface;

import java.awt.Color; 
import java.awt.Graphics2D; 
import java.awt.Graphics; 
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent; 
 
import javax.swing.JPanel;
import javax.swing.Timer; 

public class Autre extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    
    private Timer timer; 
    private int DELAY = 2; 
    private RedToken bille = new RedToken(); 

    public Autre() {
        initBoard(); 
    }

   

    private void initBoard() {

        addKeyListener(new TAdapter()); 
        setBackground(new Color(0, 0, 128));
        setFocusable(true);
        setVisible(true);

        timer = new Timer(DELAY, this);
        timer.start();  
        
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);  
        Toolkit.getDefaultToolkit().sync(); 
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g; 
        g2d.drawImage(bille.getImage(), bille.getX(), bille.getY(), this); //why null pointer ? 

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        step(); 
    }

    private void step() {

        bille.move();
        repaint(bille.getX() - 1, bille.getY() - 1, bille.getWidth() + 2, bille.getHeight() + 2);
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            bille.keyReleased(e);
        }
        @Override
        public void keyPressed(KeyEvent e) {
            bille.keyPressed(e);
        }
    }
}
