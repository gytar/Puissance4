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
       
        grid.initGrid();
        column.initColumn();
        r.initRedToken();
        y.initYellowToken(); 

        r.printR();
        y.printY();
        grid.printGrid();


    
        User user = new User();
        Auth auth = new Auth();   
        Scanner sc = new Scanner(System.in); 
        user = auth.Connection(); 
    }
}