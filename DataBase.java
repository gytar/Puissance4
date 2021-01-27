import java.sql.*; 

public class DataBase {
    // variable declaration 
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://infra.idfor-consulting.fr:31800/groupe2";

    static final String USER = "groupe2";
    static final String PASSWORD = "o6iwoQX8VMrtSaf5";
    // we need a user fot the database
    User user = new User(); 
    
    public void addUserDB(){
        Connection conn = null; 
        try{
            Class.forName(JDBC_DRIVER); 
            
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD); 

            System.out.println("Creating Statement...");
            String sql; 
            sql = "INSERT INTO puis4 (username, password, score, ratio) VALUES (?,?,?,?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());

            // maybe later for this: 

            // stmt.setInt(3, this.score);
            // stmt.setFloat(4, this.ratio);
            
            stmt.executeUpdate();

            System.out.println("elements added");


        } catch(SQLException e){
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void addScoreToDB(){
        Connection conn = null; 
        try{
            Class.forName(JDBC_DRIVER); 
            
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD); 

            System.out.println("Creating Statement...");
            // 1st query
            String sql1; 
            sql1 = "SELECT win, ratio, lose FROM puis4 WHERE username = '?';"; 
            PreparedStatement stmt1 = conn.prepareStatement(sql1);
            stmt1.setString(1, user.getUsername());

            stmt1.execute(); 

            // 2nd query
            String sql;
            sql = "UPDATE puis4 SET win = ?, ratio = ?, lose = ? WHERE username = '?' ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, user.getWinnings()); 
            stmt.setFloat(2, user.getRatio());
            stmt.setInt(3, user.getLosings());
            stmt.setString(4, user.getUsername());
            
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

    public void getUserData(){
        Connection conn = null; 
        try{
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD); 
            
            

        } catch(SQLException e){
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
