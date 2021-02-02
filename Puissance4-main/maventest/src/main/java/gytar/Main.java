package gytar;

import java.util.Scanner;

import gytar.DataBase.*;
import gytar.Elements.*;

public class Main{
    private static final String SPACE = " ";
    public static void main(String[] args) {
        // déclaration des objets
        Grid grid = new Grid(); 
        Column column = new Column();
        Red r = new Red(); 
        Yellow y = new Yellow(); 
        // initialisation des objets
        grid.initGrid();
        column.initColumn();
        r.initRedToken();
        r.printR();
        y.initYellowToken();
        y.printY();

        // impression de la table dans le bon ordre
        for(int i = 5; i >= 0; i--){
            for(int j = 0; j < 7; j++){
                System.out.print(String.valueOf(grid.getGridAtPos(i, j).getX()) + SPACE + String.valueOf(grid.getGridAtPos(i, j).getY()));
            }
        System.out.println();
        }
        // impression de la colonne 
        for(int i = 0; i < column.getColumn().length; i++){
            System.out.print(SPACE + String.valueOf(column.getColumnAtId(i).getX()) + SPACE);
        }
        System.out.println();

        User user = new User();
        Auth auth = new Auth();   
        Scanner sc = new Scanner(System.in); 


        user = auth.Connection(); 

        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());
        System.out.println("wins: " + user.getWinnings());
        System.out.println("lost: " + user.getLosings());
        System.out.println("ratio: " + user.getRatio());
        System.out.println("games played: " + user.getGamePlayed());
        

        sc.close();
    }
}