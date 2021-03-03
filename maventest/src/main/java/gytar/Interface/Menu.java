package gytar.Interface;

import gytar.Elements.*; 
import  java.awt.*; 
import javax.swing.*;

public class Menu extends JFrame {
    
    private static final long serialVersionUID = 1L;
    public static String message; 
    public static JLabel theMessage; 
 

    public Menu(User user) {

        String username = user.getUsername();
        String message = username + "'s turn!";
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        getContentPane().setBackground(new Color(210, 210, 210));
        setSize(new Dimension(1000, 700));
        theMessage = new JLabel(message);
        theMessage.setFont(new Font("Confortaa", Font.PLAIN, 20));
        
        JPanel contentPane = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPane.add(theMessage, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        Board b = new Board(user); 
        
        contentPane.add(b, gbc); 
         
        add(contentPane);

        setTitle("Menu");
        setSize(1000, 700); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
