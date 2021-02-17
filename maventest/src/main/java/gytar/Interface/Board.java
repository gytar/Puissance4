package gytar.Interface;



import javax.swing.JFrame;

import java.awt.event.*; 
import java.awt.*; 

public class Board extends JFrame implements ActionListener {


    private static final long serialVersionUID = 4746733928727453745L;

    public Board(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(210, 210, 210));
        setSize(new Dimension(1000, 700));


    }


    @Override
    public void actionPerformed(ActionEvent arg0) {

    }
    
}
