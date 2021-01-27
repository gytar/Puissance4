public class Grid{
    private String[][] grid = new String[6][7];

    public String[][] getGrid() {
        return grid;
    }
    public void setGrid(String[][] grid) {
        this.grid = grid;
    }

    public void setGridAtPos(int i, int j, String sth){
        this.grid[i][j] = sth; 
    }
    public String getGridAtPos(int i, int j){
        return grid[i][j];
    }

    public String[][] initGrid(){
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                this.grid[i][j] = "." + i; 
            }
        }
        return grid; 
    }
}