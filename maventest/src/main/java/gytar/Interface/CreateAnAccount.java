package gytar.Interface;

import javax.swing.JFrame;

import java.awt.Color; 

public class CreateAnAccount extends JFrame{
    public CreateAnAccount() {
        init(); 
    }   

    private void init() {
        
        setTitle("Create an account");
        setSize(1000, 700);
        setBackground(new Color(0, 0, 128));
        setLocationRelativeTo(null);
        setFocusable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}