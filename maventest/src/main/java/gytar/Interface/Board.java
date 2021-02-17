package gytar.Interface;


import gytar.Main;
import gytar.DataBase.DataBase;
import gytar.Elements.*;

import javax.swing.*;

import java.awt.event.*; 
import java.awt.*; 

public class Board extends JFrame implements ActionListener {

    // Token yellow = new Token(); 
    MainInt main; 
    DataBase data; 
    User user = null;
    // IA ia = new IA();
    // Game game = new Game(); 
    private static final long serialVersionUID = 4746733928727453745L;

    public Board() {
        String username = main.myUser().getUsername();
        String message = username + "'s turn! Enter choice (1-7): ";
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        getContentPane().setBackground(new Color(210, 210, 210));
        setSize(new Dimension(1000, 700));
        JLabel theMessage = new JLabel(message);
        JPanel theGrid = new JPanel(new GridLayout(6, 7));
        theGrid.setPreferredSize(new Dimension(800, 500));
        theGrid.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));

        for(int i = 0; i < (7*6); i++) {
            JLabel j = new JLabel("case");
            j.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            theGrid.add(j);
        }
        
        JPanel contentPane = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints(); 
        
        gbc.gridx = 0; 
        gbc.gridy = 0; 
        contentPane.add(theMessage, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        contentPane.add(theGrid, gbc); 
         
        add(contentPane); 

        setLocationRelativeTo(null);
        setFocusable(true);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent arg0) {

    }
    
}
