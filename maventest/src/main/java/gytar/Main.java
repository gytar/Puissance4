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
        y.initYellowToken();

        // impression des jetons
        System.out.println(r.color() + " " + y.color());
        System.out.println(r.num() + " " + y.num());
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
        DataBase data = new DataBase();  
        Scanner sc = new Scanner(System.in); 

        
        System.out.print("enter your username: ");
        user.setUsername(sc.nextLine());
        System.out.print("enter password: ");
        user.setPassword(sc.nextLine());

        String password = user.getPassword(); 
        String username = user.getUsername();

        data.addUserDB(username, password);

        sc.close();
        // while(!grid.isFull() || !user.win()){
        //     // code the game
        // }

        
    }
}