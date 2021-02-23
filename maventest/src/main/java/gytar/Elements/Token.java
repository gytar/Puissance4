package gytar.Elements;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Token {
    private String color;
    private int num;
    private Image image;
    
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
        ImageIcon ii = new ImageIcon("Elements/ressources/yellowToken.png");
        image = ii.getImage(); 
        
    }

    public Image getImage() {
        return image;
    }
    

    public void initRedToken(){
        this.color = "R";
        this.num = 1; 
        ImageIcon ii = new ImageIcon("Elements/ressources/redToken.png");
        image = ii.getImage(); 
    }

    public void printToken(){
        System.out.println(this.color + " " + this.num);

    }
}
