package gytar.Elements;

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
<<<<<<< HEAD

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
=======
        boolean full = true; 
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                if(this.grid[i][j].isFull() == false){
                    break;
                } else {
                    full = false; 
                }
            }
        }
        return full; 
>>>>>>> 8dacb61 (game almost done)
    }
}