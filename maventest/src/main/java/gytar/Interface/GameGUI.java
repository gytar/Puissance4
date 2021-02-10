package gytar.Interface;

import javax.swing.JFrame;
import java.awt.EventQueue;


public class GameGUI extends JFrame {
    private static final long serialVersionUID = 1L;

    public GameGUI() {
        initUI(); 
    }

    private void initUI() {
        add(new Board());

        setTitle("falling down");
        setSize(1000, 700); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
    }

    public static void main(String[] args) {
        // permet de voir l'animation
        EventQueue.invokeLater(() -> {
            JFrame ex = new GameGUI(); 
            ex.setVisible(true);
        });
    }
}
