package gytar.Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class MainInt extends JFrame {
    public MainInt() {
        initMain(); 
        setVisible(true);
    }
    private void initMain() {
        add(new FirstPage());
        
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame f = new MainInt(); 
            
        });
    }
    
}
