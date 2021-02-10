package gytar;

import gytar.DataBase.*;
import gytar.Elements.*;
import gytar.IA.*;


public class Main{
    /**
     * --- Puissance 4 - Projet Cyberfull ---
     * All credits to Benjamin Dupuis, Alexis Pons,
     * Jordan Kraria and Guillaume Perrot
     *
     * Special thanks to Eric Moleon for supervising the project
     *
     */
    public static void main(String[] args) {
        // déclaration des objets
        Grid grid = new Grid();
        Column column = new Column();
        Token red = new Token();
        Token yellow = new Token();
        Game g = new Game();
        User user = new User();
        Auth auth = new Auth();
        IA iaTeube = new IA();

        // initialisation des elements
        grid.initGrid();
        column.initColumn();
        red.initRedToken();
        yellow.initYellowToken();

        user = auth.Connection();
        // attribution des jetons
        user.setToken(red);
        iaTeube.setToken(yellow);

        // ON JOUE !!!
        g.theGame(grid, red, yellow, user, iaTeube);


    }
}
