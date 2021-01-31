package gytar.DataBase;

import java.io.Console;
import java.util.Scanner;
import gytar.Elements.User;

public class Auth {
    DataBase data = new DataBase(); 
    Console console = System.console();
    Scanner sc = new Scanner(System.in);
    
    public User Connection(){
        User user = new User(); 
        System.out.println("Welcome to the best Connect4 you've ever played! \\o/");
        while(true){
            System.out.print("Have you got an account here? (y/n) ");
            String choice = sc.nextLine().toLowerCase().trim();
            if(choice.contains("y")){
                user = LogIn();
                break;  
            } else if(choice.contains("n")){
                user = createAnAccount();
                break; 
            } else {
                System.out.println("invalid answer.");
            }
        }
        
       
        return user; 
    }

    public User LogIn(){
        User user = new User(); 
        for(int i = 0; i < 15; i++){
            System.out.println("Please enter infos");
            user.setUsername(console.readLine("Username: ").trim());
            user.setPassword(new String(console.readPassword("Password: ")));

    
            String password = user.getPassword(); 
            String username = user.getUsername();
    
            if(data.getUserIdConnection(username, password) == true){
                System.out.println("you are connected!");
                user = data.getUserData(username);
                System.out.println("Welcome back " + username);
                 
                break; 
            } else if(i > 2) {
                System.out.print("are you sure you don't want to create an account? (y/n) ");
                String choice = sc.nextLine().toLowerCase().trim();
                if(choice.contains("y")) {
                    createAnAccount();
                    break; 
                } else 
                    continue;
                
            } else {
                System.out.println("the username or the password might be incorrect");
            }
        }
        
        return user; 
    }

    public User createAnAccount(){
        User newUser = new User(); 
        System.out.println("Please register some infos");
        newUser.setUsername(console.readLine("Username: ").trim());
        newUser.setPassword(new String(console.readPassword("Password: ")));

        String username = newUser.getUsername();
        String password = newUser.getPassword(); 
        data.addUserDB(username, password);

        System.out.println("You have been added to the game!");
        System.out.println("welcome " + username);

        return newUser; 
    }

    

}
