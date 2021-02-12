package gytar.Interface;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Component; 
import java.awt.event.*; 
import gytar.DataBase.DataBase;
import gytar.Elements.User;



public class Authentification extends JFrame {
    DataBase data = new DataBase(); 
    User user = new User(); 
    public Authentification() {
        init(); 
    }   

    private void init() {
        setTitle("Log In");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton login = new JButton(); 
        login.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                //user = data.getUserData(username); 
            }
            
        });

    }
}
