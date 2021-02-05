package gytar.Elements;

public class User {
    // variables declaration
    private String username; 
    private int score; 
    private Token token;
    private String password; 
    private double ratio;
    private int gamePlayed; 
    private int winnings; 
    private int losings; 
    private String hashedPassword;

    
    // getters and setters 

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Token getToken() {
        return token;
    }
    public void setToken(Token token) {
        this.token = token;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
    public double getRatio() {
        return ratio;
    }
    public void setLosings(int losings) {
        this.losings = losings;
    }
    public int getLosings() {
        return losings;
    }
    public void setWinnings(int winnings) {
        this.winnings = winnings;
    }
    public int getWinnings() {
        return winnings;
    }
    public void setGamePlayed(int gamePlayed) {
        this.gamePlayed = gamePlayed;
    }
    public int getGamePlayed() {
        return gamePlayed;
    }
    public String getHashedPassword() {
        return hashedPassword;
    }
    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
    // functions
    public double calculateRatio(){
        this.ratio = (double)this.winnings / ((double)this.winnings + (double)this.losings); 
        return this.ratio;
    }

}