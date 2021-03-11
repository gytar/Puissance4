package gytar.Interface;

import gytar.DataBase.DataBase;
import gytar.Elements.*;
import gytar.*;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*; 

public class Board extends JPanel implements ActionListener {

    private static final long serialVersionUID = -5129586821830018760L;
    DataBase data;
    Token red = new Token();
    Token yellow = new Token();  

    Logic logic = new Logic(); 

    Grid grid = new Grid(); 
    int turn = 0; 
    boolean won = false; 


    public static String winner; 

    public Board(User user) {
        initBoard();

        red.initRedToken();
        yellow.initYellowToken();

        

    }
    

    public void initBoard() {
        // creattion of the grid
        JPanel g = grid.initGuiGrid();
        grid.initGrid(); 
        for(int i = 0; i < grid.getGuiGrid().length; i++) {
            // action command is used to get column's id
            grid.getGuiGridAtPos(i).getPlay().setActionCommand(""+i);
            grid.getGuiGridAtPos(i).getPlay().addActionListener(this);
        }
        add(g); 
    }


    @Override
    public void actionPerformed(ActionEvent arg0) { 
        red.initRedToken();
        yellow.initYellowToken();
        // get the button id
        int id = Integer.parseInt(arg0.getActionCommand());
        // check whether this is yellow's or red's turn 
        logic.userTurn(grid, turn, id, red, yellow);
        // turn's over, add 1 to count of turns 
        turn++;
        // checks if one or another won
        won = logic.addDataAtTheEndOfGame(grid, MainInt.user, red, yellow, won); 
        // display end of game window if one has won 
        if(won) {
            new EndofGame(); 
        }
    
    }

    @Override
    public void paintComponent(Graphics g) {
        
    }

   
}
