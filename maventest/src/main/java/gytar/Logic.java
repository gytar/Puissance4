package gytar;

import gytar.Elements.*;


import gytar.DataBase.*;
import gytar.IA.*;
import gytar.Interface.*;  

public class Logic {

    DataBase data = new DataBase();

    Auth auth = new Auth();
    IA iaTeube = new IA(); 




    public int columnCount(int userChoice, Grid grid){
        int columnCount = 0; 
        for(int i = 0; i < 6; i++){
            if(grid.getGridAtPos(i, userChoice).getContenant().equals(".")){
                columnCount++;
            }
        }
        return columnCount; 
    }
    

    public void userTurn(Grid grid, int turn, int id, Token red, Token yellow) {
        if(turn % 2 == 0) {
            // should make a function about it (in Game)
            for(int j = 0; j < 6; j++) {
                if(grid.getGuiGridAtPos(id).getCase(j).getContenant().equals(".")) {
                    grid.getGuiGridAtPos(id).getCase(j).getLbl().setIcon(red.getIcon()); 
                    grid.getGuiGridAtPos(id).getCase(j).setContenant("R");
                    grid.setGridAtPos(j, id, red);
                    Menu.message = "Player 2's turn";
                    Menu.theMessage.setText(Menu.message);
                    break;
                }
            }
        }
        if(turn % 2 == 1) {
            for(int j = 0; j < 6; j++) {
                if(grid.getGuiGridAtPos(id).getCase(j).getContenant().equals(".")) {
                    grid.getGuiGridAtPos(id).getCase(j).getLbl().setIcon(yellow.getIcon()); 
                    grid.getGuiGridAtPos(id).getCase(j).setContenant("Y");
                    grid.setGridAtPos(j, id, yellow);
                    Menu.message = MainInt.user.getUsername() + "'s turn";
                    Menu.theMessage.setText(Menu.message);
                    break;
                }
            }
        }
    }

    public boolean addDataAtTheEndOfGame(Grid grid, User user, Token red, Token yellow, boolean won) {
        if(hasWon(grid, red)) {
            System.out.println("red has won");
            Board.winner = MainInt.user.getUsername(); 
            // on ajoute +1 sur le compte de victoire et jeux joués
            int winPlusUn = user.getWinnings() + 1; 
            user.setWinnings(winPlusUn);
            int gamePlayedPlusUn = user.getGamePlayed() + 1; 
            user.setGamePlayed(gamePlayedPlusUn);

            // on calcule le ratio
            user.calculateRatio(); 
            
            // on ajoute le score à la base de données 
            data.addScoreToDB(user.getUsername(), user.getWinnings(), user.getLosings(), user.getRatio());
            
            // on déclare vrai la valeur win pour sortir du jeu
            won = true;
        }

        if(hasWon(grid, yellow)) {
            System.out.println("yellow has won");
            Board.winner = "AI";  
        
            int losePlusUn = user.getLosings() + 1; 
            // on ajoute +1 sur le compte de défaites et jeux joués 
            user.setLosings(losePlusUn);
            int gamePlayedPlusUn = user.getGamePlayed() + 1; 
            user.setGamePlayed(gamePlayedPlusUn);
    
            // on calculte le ratio
            user.calculateRatio(); 
            // on ajoute le score à la base de données
            data.addScoreToDB(user.getUsername(), user.getWinnings(), user.getLosings(), user.getRatio());
    
            // on déclare vrai la valeur win pour sortir du jeu
            won = true; 
        }

        return won; 
        
    }


    public boolean hasWon(Grid g, Token t){

        boolean victory = false;
        int champion = 0; 

        //condition de victoire dans le sens horizontal
        for(int i = 0; i < 6; i++) {
            if(victory == true) {break;}
            // au changement de ligne on rétablit le compte à 0 
            champion = 0; 

            for(int j = 0; j < 7; j++) {
                if(champion == 4){
                    victory = true;
                    break;
                }
                if(g.getGridAtPos(i, j).getContenant().equals(t.getColor())) {
                    champion += 1; 
                } else {
                    champion = 0; 
                }
                
            }
        }
        // condition de vicoire dans le sens vertical
        for(int i = 0; i < 7; i++) {
            if(victory == true) {break;} 
            // au changement de colonne, on rétablit le compte à 0
            champion = 0;

            for(int j = 0; j < 6; j++) {
                if(champion == 4){
                    victory = true;
                    break;
                }

                if(g.getGridAtPos(j, i).getContenant().equals(t.getColor())) {
                    champion += 1;                  
                } else {
                    champion = 0; 
                }
                
            }
        }
        // condition victoire pour la diagonale dans ce sens -> "/"
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 3; j++) {
                
                if(g.getGridAtPos(j, i).getContenant().equals(t.getColor())) {
                    
                    int iPosition1 = i + 1;
                    int iPosition2 = i + 2;
                    int iPosition3 = i + 3;

                    int jPosition1 = j + 1;
                    int jPosition2 = j + 2;
                    int jPosition3 = j + 3;
                    // si on a les trois jetons alignés après le premier, le joueur a gagné
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
