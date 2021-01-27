public class Red {
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
