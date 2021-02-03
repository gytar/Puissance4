package gytar;

import gytar.DataBase.*;
import gytar.Elements.*;
import gytar.IA.IA;

import java.math.*;

public class Main{
    public static void main(String[] args) {
        // déclaration des objets
        Grid grid = new Grid(); 
        Column column = new Column();
        Token red = new Token();
        Token yellow = new Token(); 
        Game g = new Game(); 
        User user = new User();
        IA ia = new IA(); 
        
        // initialisation des elements
        grid.initGrid();
        column.initColumn();
        red.initRedToken();
        yellow.initYellowToken();

        // attribution des jetons
        user.setToken(red); 
        ia.setToken(yellow);

        // ON JOUE !!!
        g.theGame(grid, red, yellow, user, ia);
        
        
    }  
}
