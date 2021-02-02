package gytar;

import java.util.Scanner;

import gytar.DataBase.*;
import gytar.Elements.*;

public class Main{
    public static void main(String[] args) {
        // déclaration des objets
        Grid grid = new Grid(); 
        Column column = new Column();
        Token red = new Token();
        Token yellow = new Token(); 
        Game g = new Game(); 
        Scanner sc = new Scanner(System.in); 
       
        grid.initGrid();
        column.initColumn();
        red.initRedToken();
        yellow.initYellowToken();

        // red.printToken();
        // yellow.printToken();
        // grid.printGrid();

        // user choose a column 
        
        // column is 
        grid.printGrid();
        System.out.println();

        grid.printGrid();
        System.out.println();

        String color;
        int turn = 0; 
        boolean win = false; 

        while((win == false) || grid.isFull()) {
            
            
            color = turn % 2 == 0 ? "R" : "Y"; 

            if(color.equals("R")){
                System.out.print(color + "'s turn! \nEnter choice: ");
                int userChoice = sc.nextInt();
                for(int i = 0; i < 6; i++){
                    if(grid.getGridAtPos(i, userChoice).getContenant().equals(".")){
                        grid.setGridAtPos(i, userChoice, red);
                        break;
                    }
                }
            }

            if(color.equals("Y")){
                System.out.print(color + "'s turn! \nEnter choice: ");
                int userChoice = sc.nextInt();
                for(int i = 0; i < 6; i++){
                    if(grid.getGridAtPos(i, userChoice).getContenant().equals(".")){
                        grid.setGridAtPos(i, userChoice, yellow);
                        break;
                    }
                }
                System.out.println(g.winningCondition(grid, yellow));
            } 

            grid.printGrid();

            if(g.winningCondition(grid, red)){
                System.out.println("Player 1 wins!");
                win = true;

            }
            if(g.winningCondition(grid, yellow)){
                System.out.println("Player 2 wins !");
                win = true; 
            }

            turn ++; 
        }
    }    


        // User user = new User();
        // Auth auth = new Auth();''
        // user = auth.Connection(); 
}
