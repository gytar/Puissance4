package gytar.Elements;

public class Yellow {
    // speaks for itself
    Token yellow = new Token();


    public Token initYellowToken(){
        this.yellow.setColor("Y");
        this.yellow.setNum(0);
        return yellow; 
    }
    public int num(){
        return this.yellow.getNum();
    } 
    public String color(){
        return this.yellow.getColor();
    }
    public void printY (){
        System.out.println(color() + " " + num());

    }

}
