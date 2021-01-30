package gytar.DataBase;

import gytar.Elements.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DataBase {

    // variable declaration 
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://infra.idfor-consulting.fr:31800/groupe2";

    static final String USER = "groupe2";
    static final String PASSWORD = "o6iwoQX8VMrtSaf5";
    
    // we need a user for the database
    User user = new User(); 
    
    public void addUserDB(String username, String password){
        Connection conn = null; 
        try{
            Class.forName(JDBC_DRIVER); 
            
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD); 

            System.out.println("Creating Statement...");
            String sql; 
            sql = "INSERT INTO puis4 (username, password) VALUES (?, ?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            stmt.execute();

            System.out.println("elements added");


        } catch(SQLException e){
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void addScoreToDB(String username, int win, int lost, float ratio){
        Connection conn = null; 
        try{
            Class.forName(JDBC_DRIVER); 
            
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD); 

            System.out.println("Creating Statement...");
            // 1st query
            String sql1; 
            sql1 = "SELECT win, ratio, lose FROM puis4 WHERE username = ?;"; 
            PreparedStatement stmt1 = conn.prepareStatement(sql1);
            stmt1.setString(1, username);

            stmt1.execute(); 

            
            // 2nd query
            String sql;
            sql = "UPDATE puis4 SET win = ?, ratio = ?, lose = ? WHERE username = ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, win); 
            stmt.setFloat(2, ratio);
            stmt.setInt(3, lost);
            stmt.setString(4, username);
            
            stmt.execute();

            System.out.println("elements added");

            // clean up
            stmt1.close();
            stmt.close();
            conn.close();
        } catch(SQLException e){
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void getUserData(String username, String password){
        Connection conn = null; 
        try{
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to data base...");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD); 
            
            String sql; 
            sql = "SELECT username, password FROM puis4;";
            // do query
            // 
            List<String> usernames = new ArrayList<>();
            List<String> passwords = new ArrayList<>();
            
            // for(int i = 0; i < something; i++){
            //     usernames.add(puis4user); 
            //     passwords.add(puis4pass); 
            // }
            
            for(int i = 0; i < usernames.size(); i++){
                if((username == usernames.get(i)) && (password == passwords.get(i))){
                // connect
                } else {
                    System.out.println("wrong username or password, try again!");
                }
            }
            


        
        } catch(SQLException e){
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
