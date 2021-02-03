package gytar.DataBase;

import gytar.Elements.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.BCrypt;



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
            user.setHashedPassword(BCrypt.hashpw(password, BCrypt.gensalt(10)));
            sql = "INSERT INTO puis4 (username, password) VALUES (?, ?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, user.getHashedPassword());
            
            stmt.execute();

            System.out.println(user.getHashedPassword());

            if (BCrypt.checkpw(password, user.getHashedPassword())){
                System.out.println("It matches");
                System.out.println("elements added");
            }
            else{
	            System.out.println("It does not match");
            }
            


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

    public boolean getUserIdConnection(String username, String password){
        boolean connected = false; 
        Connection conn = null; 
        try{
            Class.forName(JDBC_DRIVER);
            
            System.out.println("Connecting to data base...");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD); 
            
            String sql;
            List<String> usernames = new ArrayList<>();
            List<String> passwords = new ArrayList<>(); 
            sql = "SELECT username, password FROM puis4;";
            // do query
            Statement stmt = conn.createStatement(); 
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                usernames.add(rs.getString("username")); 
                passwords.add(rs.getString("password"));
            }
            
            for(int i = 0; i < usernames.size(); i++){
                if((usernames.get(i).equals(username)) && (BCrypt.checkpw(password, passwords.get(i)))){
                    System.out.println("found combo " + username + ", " + password);
                    connected = true; 
                    break; 
                }
            }
            
            rs.close();
            stmt.close();
            conn.close();
            
        } catch(SQLException e){
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }

        return connected; 
    }

    public User getUserData(String username){
        User user = new User(); 
        Connection conn = null;  
        try{
            Class.forName(JDBC_DRIVER);
            
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD); 

            String query = "SELECT * FROM groupe2.puis4 WHERE username = ?"; 
            PreparedStatement stmt = conn.prepareStatement(query); 
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery(); 
            while(rs.next()){
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setWinnings(rs.getInt("win"));
                user.setLosings(rs.getInt("lose"));
                user.setRatio(rs.getFloat("ratio"));
                user.setGamePlayed(user.getWinnings() + user.getLosings());
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch(SQLException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return user; 
    }
}
