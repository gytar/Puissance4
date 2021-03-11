package gytar.Elements;

import java.awt.*; 
import javax.swing.*;



public class Column {
    Case[] columnCase = new Case[6]; 
    JPanel lbl = new JPanel(); 
    int id; 
    JButton play = new JButton(); 
    ImageIcon defaultIcon = new ImageIcon("/home/gytar/Documents/Dev/p4-cf/Puissance4/maventest/src/main/java/gytar/Elements/ressources/triangle.png"); 


    public void initColumn() {
        lbl.setPreferredSize(new Dimension(110, 700));
        lbl.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        lbl.setLayout(new GridLayout(7, 1));
        for(int i = 5; i >= 0; i--) {
            columnCase[i] = new Case(); 
            columnCase[i].setContenant(".");
            columnCase[i].setY(i);
            lbl.add(columnCase[i].getLbl()); 
            
        }
        play = new JButton();
        play.setIcon(defaultIcon); 
        lbl.add(play); 
        lbl.setVisible(true);
    }
    public Case getCase(int i) {
        return columnCase[i];
    }
    public JPanel getLbl() {
        return lbl;
    } 

    public JButton getPlay() {
        return play;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}