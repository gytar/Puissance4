package gytar.Interface;

import java.awt.EventQueue;
import java.awt.Color;

import javax.swing.JFrame;

public class MainInt extends JFrame {
    public MainInt() {
        initMain(); 
    }
    private void initMain() {
        add(new FirstPage());
        
        setTitle("Hello!");
        setSize(1000, 700); 
        setBackground(new Color(0,0,128));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);        
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame f = new MainInt(); 
            f.setVisible(true);
        });
    }
    
}
