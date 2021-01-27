package Elements;

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
                this.grid[i][j].setContenant("." + i);
                this.grid[i][j].setX(i);
                this.grid[i][j].setY(j);

            }
        }
        return grid; 
    }
    // to do: a boolean that returns TRUE when the grid id full
    
}