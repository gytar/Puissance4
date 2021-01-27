public class Grid{
    private Case[][] grid = new Case[6][7];

    public Case[][] getGrid() {
        return grid;
    }
    public void setGrid(Case[][] grid) {
        this.grid = grid;
    }

    public void setGridAtPos(int i, int j, Case sth){
        this.grid[i][j] = sth; 
    }
    public Case getGridAtPos(int i, int j){
        return grid[i][j];
    }

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
}