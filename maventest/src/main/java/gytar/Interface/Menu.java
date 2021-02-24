package gytar.Interface;

import gytar.Elements.*; 

import  java.awt.*; 
import java.awt.event.*;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSliderUI.ComponentHandler; 

public class Menu extends JFrame implements ActionListener {
    
    private static final long serialVersionUID = 1L;

 

    public Menu(User user) {

        String username = user.getUsername();
        String message = username + "'s turn! Enter choice (1-7): ";
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        getContentPane().setBackground(new Color(210, 210, 210));
        setSize(new Dimension(1000, 700));
        JLabel theMessage = new JLabel(message);
        theMessage.setFont(new Font("Confortaa", Font.PLAIN, 20));
        
        JPanel contentPane = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPane.add(theMessage, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        Board b = new Board(user); 
        
        contentPane.add(b.grille(), gbc); 
         
        add(contentPane);

        setTitle("Board");
        setSize(1000, 700); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

    }

     
    
}
