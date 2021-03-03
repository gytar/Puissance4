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

    Grid grid = new Grid(); 
    int turn = 0; 

    public Board(User user) {
        initBoard();
        redIcon();
        yellowIcon(); 

    }
    

    public void initBoard() {
        JPanel g = grid.initGuiGrid();
        for(int i = 0; i < grid.getGuiGrid().length; i++) {
            grid.getGuiGridAtPos(i).getPlay().addActionListener(this);
        }
        add(g); 
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
        grid.getGuiGridAtPos(1).getCase(1).getLbl().setIcon(yellow.getIcon());
    }

    @Override
    public void paintComponent(Graphics g) {
        
    }
}
