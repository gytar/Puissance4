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
       
        grid.initGrid();
        column.initColumn();
        red.initRedToken();
        yellow.initYellowToken();

        red.printToken();
        yellow.printToken();
        grid.printGrid();

        System.out.println();
        grid.setGridAtPos(0, 0, red);
        grid.printGrid();
    
        // User user = new User();
        // Auth auth = new Auth();
        // user = auth.Connection(); 
    }
}