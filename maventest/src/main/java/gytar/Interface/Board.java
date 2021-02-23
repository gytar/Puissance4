package gytar.Interface;

import gytar.DataBase.DataBase;
import gytar.Elements.*;

import javax.swing.*;

import java.awt.event.*; 
import java.awt.*; 

public class Board extends JFrame implements ActionListener {

    DataBase data; 
    Token red; 

    private static final long serialVersionUID = 4746733928727453745L;

    public Board(User user) {
        String username = user.getUsername();
        String message = username + "'s turn! Enter choice (1-7): ";
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        getContentPane().setBackground(new Color(210, 210, 210));
        setSize(new Dimension(1000, 700));
        JLabel theMessage = new JLabel(message);
        theMessage.setFont(new Font("Confortaa", Font.PLAIN, 20));
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


        red = new Token(); 
        red.initRedToken();
        int w = red.getImage().getWidth(this);
        int h = red.getImage().getHeight(this); 
        setPreferredSize(new Dimension(w, h));



        setTitle("Board");
        setSize(1000, 700); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent arg0) {

    }

    
    public void paintComponent(Graphics g) {
        g.drawImage(red.getImage(), 0, 0, null);
    }
    
}
