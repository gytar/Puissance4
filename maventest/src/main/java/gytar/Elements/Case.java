package gytar.Elements;

public class Case {
    // create variables 
    private String contenant; 
    private int x; 
    private int y;
    // getters and setters 
    

    public String getContenant() {
        return contenant;
    }
    public void setContenant(String contenant) {
        this.contenant = contenant;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    
    public boolean isFull(){
        if(this.contenant.equals(".")){
            return false; 
        } else {
            return true; 
        }
    }
}