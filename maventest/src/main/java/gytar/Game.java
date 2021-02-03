package gytar;

import java.util.*;

import gytar.Elements.*;
import gytar.IA.*;

public class Game {

    public void theGame(Grid grid, Token red, Token yellow, User user, IA ia){


        Scanner sc  = new Scanner(System.in);  

        String color;
        int turn = 0;
        int userChoice = 579435;
        String userInput;
        String[] digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        boolean win = false;

        grid.printGrid();
        System.out.println();

        // le jeu en tant que tel. 
        while((win == false) || grid.isFull()) {
            
            // tour par tour, si le tour est pair, Rouge (utilisateur) joue, sinon Jaune (IA)
            color = turn % 2 == 0 ? "R" : "Y"; 
            // tant que vrai, on demande à l'utilisateur de saisir un chiffre
            
            while(true){
                System.out.println("pick a number 1-7");

                if(color.equals("R")){
                    System.out.print(user.getUsername() + "'s turn! \nEnter choice: ");
                    userInput = sc.nextLine();
                    for(int i = 0; i < digits.length; i++){
                        if(userInput.equals(digits[i])){
                            userChoice = Integer.parseInt(userInput); 
                            System.out.println(userChoice);
                        }
                    }
                    
                    //si c'est le bon chiffre, on sort de la boucle
                    if(1 <= userChoice && userChoice <= 7) {
                    userChoice -= 1; 
                    break; 
                    }
                } else {
                    System.out.println("IA's turn!");
                    userChoice = ia.chooseNumber(); 
                    userChoice -= 1; 
                    break; 
                }
            }
            
            // tour du joueur rouge
            if(color.equals("R")){
                for(int i = 0; i < 6; i++){
                    if(grid.getGridAtPos(i, userChoice).getContenant().equals(".")){
                        grid.setGridAtPos(i, userChoice, red);
                        break;
                    }
                }
            }

            // tour du joueur jaune
            if(color.equals("Y")){
                for(int i = 0; i < 6; i++){
                    if(grid.getGridAtPos(i, userChoice).getContenant().equals(".")){
                        grid.setGridAtPos(i, userChoice, yellow);
                        break;
                    }
                }
            } 

            // test si l'utilisateur gagne
            if(winningCondition(grid, red)){
                System.out.println("You win!");

                // on ajoute +1 sur le compte de victoire et jeux joués
                int winPlusUn = user.getWinnings() + 1; 
                user.setWinnings(winPlusUn);
                int gamePlayedPlusUn = user.getGamePlayed() + 1; 
                user.setGamePlayed(gamePlayedPlusUn);

                // on calcule le ratio
                user.calculateRatio(); 
                win = true;

            }

            //test si l'IA gagne
            if(winningCondition(grid, yellow)){
                System.out.println("IA wins !");
                int losePlusUn = user.getLosings() + 1; 
                // on ajoute +1 sur le compte de défaites et jeux joués 
                user.setLosings(losePlusUn);
                int gamePlayedPlusUn = user.getGamePlayed() + 1; 
                user.setGamePlayed(gamePlayedPlusUn);
                win = true; 
            }

            // test pour l'égalité, si la grille est pleine
            if(grid.isFull()){
                System.out.println("It's a draw");
                break;
            }
            grid.printGrid();

            // compte les tours 
            turn ++; 
        }  
        sc.close();
    }         
    

    public boolean winningCondition(Grid g, Token t){

        boolean victory = false;
        int champion = 0; 

        //condition de victoire dans le sens horizontal
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                if(g.getGridAtPos(i, j).getContenant().equals(t.getColor())){
                    champion += 1; 
                } else {
                    champion = 0; 
                }
                if(champion == 4){
                    victory = true;
                    break;
                }
            }
        }
        // condition de vicoire dans le sens vertical
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 6; j++){
                if(g.getGridAtPos(j, i).getContenant().equals(t.getColor())){
                    champion += 1; 
                   
                } else {
                    champion = 0; 
                }
                if(champion == 4){
                    victory = true;
                    break;
                }
            }
        }
        // condition victoire pour la diagonale dans ce sens -> "/"
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                
                if(g.getGridAtPos(j, i).getContenant().equals(t.getColor())) {
                    
                    int iPosition1 = i + 1;
                    int iPosition2 = i + 2;
                    int iPosition3 = i + 3;

                    int jPosition1 = j + 1;
                    int jPosition2 = j + 2;
                    int jPosition3 = j + 3;
                    
                    if (g.getGridAtPos(jPosition1, iPosition1).getContenant().equals(t.getColor())
                        && g.getGridAtPos(jPosition2, iPosition2).getContenant().equals(t.getColor())
                        && g.getGridAtPos(jPosition3, iPosition3).getContenant().equals(t.getColor())) {
                        victory = true; 
                    }
                }
            }
        }
        // condition de victoire pour la diagonale dans ce sens -> "\"
        for(int i = 6; i >= 3; i--){
            for(int j = 0; j < 3; j++){
                
                if(g.getGridAtPos(j, i).getContenant().equals(t.getColor())){
                    int iBack1 = i - 1;
                    int iBack2 = i - 2;
                    int iBack3 = i - 3; 

                    int jBack1 = j + 1; 
                    int jBack2 = j + 2;
                    int jBack3 = j + 3; 

                    if (g.getGridAtPos(jBack1, iBack1).getContenant().equals(t.getColor())
                        && g.getGridAtPos(jBack2, iBack2).getContenant().equals(t.getColor())
                        && g.getGridAtPos(jBack3, iBack3).getContenant().equals(t.getColor())) {
                        victory = true; 
                    }
                }
            }
        }

        return victory;
    }
}
