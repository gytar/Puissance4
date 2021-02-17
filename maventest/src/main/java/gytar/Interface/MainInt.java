package gytar.Interface;

import java.awt.EventQueue;
import gytar.Elements.*;
import gytar.DataBase.*; 
import javax.swing.JFrame;

public class MainInt extends JFrame {

    User user = new User(); 
    Auth auth = new Auth(); 
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
    public User myUser() {
        return user; 
    }
    
}
