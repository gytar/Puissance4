package Elements;

public class Red {
    // the code speaks for itself
    Token red = new Token(); 

    public Token initRedToken(){
        this.red.setColor("R");
        this.red.setNum(1);
        return red; 
    }
    public int num(){
        return this.red.getNum();
    } 
    public String color(){
        return this.red.getColor();
    }
    
}
