package gytar.Interface;

import gytar.DataBase.DataBase;
import gytar.Elements.*;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*; 

public class Board extends JPanel implements ActionListener {

    private static final long serialVersionUID = -5129586821830018760L;
    DataBase data;
    Token red = new Token();
    Token yellow = new Token();  
    Case gridCase;
    // Grid grid = new Grid();
    Column[] column = new Column[7]; 
    int turn = 0; 

    public Board(User user) {

    } 

    public JPanel grille() {
        JPanel grid = new JPanel(); 
        grid.setLayout(new GridLayout(1, 7));
        // ajouter des cases dans la grille 
        grid.setPreferredSize(new Dimension(770, 600));
        grid.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));

        for(int i = 0; i < 7; i++) {            
            column[i] = new Column();
            column[i].initColumn();
            column[i].getPlay().addActionListener(this);
            column[i].setId(i);
            grid.add(column[i].getLbl());
        }
        grid.setVisible(true);

        return grid;
    }

    public ImageIcon redIcon() {
        red.initRedToken();
        return red.getIcon();
    }

    public ImageIcon yellowIcon() {
        yellow.initYellowToken();
        return yellow.getIcon();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        int idButtonClicked = column[3].getId();
        System.out.println("button ");
        for(int i = 0; i < 6; i++) {
            if(column[idButtonClicked].getCase(i).getContenant().equals(".")) {
                column[idButtonClicked].getCase(i).getLbl().setIcon(yellowIcon());
                column[idButtonClicked].getCase(i).setContenant("Y");
                turn++; 
                break; 
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        
    }
}
