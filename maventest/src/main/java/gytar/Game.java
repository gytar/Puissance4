package gytar;

import gytar.Elements.*;

public class Game {
    /* si on a 4 jetons de même couleur qui s'allignent = daig, horizon, verti. 
     alors on a un gagnant; 
    **/ 

    public boolean winningCondition(Grid g, Token t){
        boolean victory = false;
        int redChampion = 0; 
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                
                
                if(g.getGridAtPos(i, j).getContenant().equals(t.getColor())){
                    redChampion += 1; 
                } else {
                    redChampion = 0; 
                }
                if(redChampion == 4){
                    victory = true;
                    break;
                }
            }
        }

        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 6; j++){
                
                
                if(g.getGridAtPos(j, i).getContenant().equals(t.getColor())){
                    redChampion += 1; 
                   
                } else {
                    redChampion = 0; 
                }
                if(redChampion == 4){
                    victory = true;
                    break;
                }
            }
        }

        return victory;
    }
}
