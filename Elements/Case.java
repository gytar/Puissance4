public class Case{
    // create variables 
    private String contenant; 
    private int x; 
    private int y;
    // getters and setters 
<<<<<<< HEAD:Case.java
    

=======
>>>>>>> folders:Elements/Case.java
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
    // we need to know when a case has something, so we create a function that returns true when it does. 
<<<<<<< HEAD:Case.java

=======
>>>>>>> folders:Elements/Case.java
    public boolean isFull(){
        if(!this.contenant.equals(".")){
            return true; 
        } else {
            return false; 
        }
    }
}