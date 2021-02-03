package gytar.Elements;

public class Token {
    private String color; 
    private int num; 

    
    public String getColor() {
        return color;
    }
    public int getNum() {
        return num;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public void initYellowToken(){
        this.color = "Y";
        this.num = 0; 
    }

    public void initRedToken(){
        this.color = "R";
        this.num = 1; 
    }

    public void printToken(){
        System.out.println(this.color + " " + this.num);

    }
}
