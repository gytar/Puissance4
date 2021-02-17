package gytar.Interface;



import javax.swing.*;

import java.awt.event.*; 
import java.awt.*; 

public class Board extends JFrame implements ActionListener {


    private static final long serialVersionUID = 4746733928727453745L;

    public Board(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        getContentPane().setBackground(new Color(210, 210, 210));
        setSize(new Dimension(1000, 700));
        JLabel osef = new JLabel("osef");
        JPanel theGrid = new JPanel(new GridLayout(6, 7));
        theGrid.setPreferredSize(new Dimension(800, 500));
        theGrid.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));

        for(int i = 0; i < (7*6); i++) {
            JLabel j = new JLabel("case");
            j.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
            theGrid.add(j);
        }

        add(theGrid);
        setLocationRelativeTo(null);
        setFocusable(true);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent arg0) {

    }
    
}
