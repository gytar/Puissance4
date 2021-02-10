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

<<<<<<< HEAD
    public void addScoreToDB(String username, int win, int lost, double ratio){
=======
    public void addScoreToDB(String username, int win, int lost, float ratio){
>>>>>>> 33da3ea (hash passwords pom.xml dependencies database)
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
            
            System.out.println("Connecting to data base...");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD); 
>>>>>>> 1e4df34 (cryptage)
            
            System.out.println("Connecting to data base...");
=======

            System.out.println("Connecting to data base...");
>>>>>>> 33da3ea (hash passwords pom.xml dependencies database)
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            String sql;
            List<String> usernames = new ArrayList<>();
            List<String> passwords = new ArrayList<>();
            sql = "SELECT username, password FROM puis4;";
            // do query
<<<<<<< HEAD
<<<<<<< HEAD
            Statement stmt = conn.createStatement();
=======
            Statement stmt = conn.createStatement(); 
>>>>>>> 1e4df34 (cryptage)
=======
            Statement stmt = conn.createStatement();
>>>>>>> 33da3ea (hash passwords pom.xml dependencies database)
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                usernames.add(rs.getString("username"));
                passwords.add(rs.getString("password"));
            }

            for(int i = 0; i < usernames.size(); i++){
                if((usernames.get(i).equals(username)) && passwords.get(i).equals(password)){
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
<<<<<<< HEAD
<<<<<<< HEAD
        User user = new User();
        Connection conn = null;

=======
        User user = new User(); 
        Connection conn = null;  
>>>>>>> 1e4df34 (cryptage)
=======
        User user = new User();
        Connection conn = null;

>>>>>>> 33da3ea (hash passwords pom.xml dependencies database)
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
<<<<<<< HEAD
<<<<<<< HEAD

        return user;
=======
        
        return user; 
>>>>>>> 1e4df34 (cryptage)
=======

        return user;
>>>>>>> 33da3ea (hash passwords pom.xml dependencies database)
    }
}
