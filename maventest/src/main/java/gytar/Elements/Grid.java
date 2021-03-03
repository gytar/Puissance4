package gytar.Elements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Grid{
    // create the grid from the Case class
    // getters and setters
    private Case[][] grid = new Case[6][7];

    private Column[] guiGrid = new Column[7];

    private int columnClicked; 




    // getters and setters
    public Case[][] getGrid() {
        return grid;
    }
    public void setGrid(Case[][] grid) {
        this.grid = grid;
    }
    // we need a specific location in order to return a specific element from the grid

    public void setGridAtPos(int i, int j, Token t){
        this.grid[i][j].setContenant(t.getColor()); 
    }
    public Case getGridAtPos(int i, int j){
        return grid[i][j];
    }
    // initialisation of the grid (create it)

    public Case[][] initGrid(){
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                this.grid[i][j] = new Case();
                this.grid[i][j].setContenant(".");
                this.grid[i][j].setX(j);
                this.grid[i][j].setY(i);
                
                
            }
        }
        return grid; 
    }
    //affichage de la grille dans le bon sens
    public void printGrid(){
        for(int i = 5; i >= 0; i--){
            for(int j = 0; j < 7; j++){
                System.out.print(getGridAtPos(i, j).getContenant() + "  ");
            }
            System.out.println();
        }

    }
    // cherche à savoir si la grille est pleine
    public boolean isFull(){

        //déclaration d'un integer qui compte les points, s'il y en a aucun, c'est que la grille est pleine
        int countDots = 0; 

        //on regarde la grille avec la double boucle for
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                // si on a une case vide, c'est que la grille n'est pas pleine 
                if(this.grid[i][j].getContenant().equals(".")){
                    countDots++;  
                    
                }   
            }
        }
        return (countDots == 0); // si 0 c'est plein. 
    }

    public void setColumnClicked(int columnClicked) {
        this.columnClicked = columnClicked;
    }
    public int getColumnClicked() {
        return columnClicked;
    }

    public JPanel initGuiGrid() {
        JPanel grid = new JPanel(); 
        grid.setLayout(new GridLayout(1, 7));
        grid.setPreferredSize(new Dimension(770, 600));
        grid.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));

        for(int i = 0; i < 7; i++) {            
            guiGrid[i] = new Column();
            guiGrid[i].initColumn();
            guiGrid[i].setId(i); 
            grid.add(guiGrid[i].getLbl());
        }
        grid.setVisible(true);

        return grid; 

    }

    public Column getGuiGridAtPos(int numColumn) {
        return guiGrid[numColumn];
    }
    public void setGuiGridAtPos(Column[] guiGrid) {
        this.guiGrid = guiGrid;
    }

    public void setGuiGrid(Column[] guiGrid) {
        this.guiGrid = guiGrid;
    }
    public Column[] getGuiGrid() {
        return guiGrid;
    }

    
}