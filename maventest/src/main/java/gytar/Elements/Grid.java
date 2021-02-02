package gytar.Elements;

import java.io.Console;

public class Grid {
    // create the grid from the Case class
    // getters and setters
    private Case[][] grid = new Case[6][7];
    // getters and setters
    public Case[][] getGrid() {
        return grid;
    }
    public void setGrid(Case[][] grid) {
        this.grid = grid;
    }
    // we need a specific location in order to return a specific element from the grid

    public void setGridAtPos(int i, int j, Case sth){
        this.grid[i][j] = sth; 
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
                this.grid[i][j].setX(i);
                this.grid[i][j].setY(j);
            }
        }
        return grid; 
    }
    // to do: a boolean that returns TRUE when the grid id full
    public void printGrid(){
        for(int i = 5; i >= 0; i--){
            for(int j = 0; j < 7; j++){
                System.out.print(getGridAtPos(i, j).getContenant() + "  ");
            }
            System.out.println();
        }

    }
    
    public boolean isFull(){
        boolean full = false; 
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                if(this.grid[i][j].isFull() == false){
                    break;
                } else{
                    full = true; 
                    continue;
                }
            }
        }
        
        return full; 
    }
}