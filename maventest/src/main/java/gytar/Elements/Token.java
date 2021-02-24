package gytar.Elements;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Token {
    private String color;
    private int num;
    private Image image;
    private ImageIcon icon; 
    
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
        icon = new ImageIcon("/home/gytar/Documents/Dev/p4-cf/Puissance4/maventest/src/main/java/gytar/Elements/ressources/yellowToken.png");
        image = icon.getImage(); 
        
    }

    public Image getImage() {
        return image;
    }

    public ImageIcon getIcon() {
        return icon;
    }
    

    public void initRedToken(){
        this.color = "R";
        this.num = 1; 
        icon = new ImageIcon("/home/gytar/Documents/Dev/p4-cf/Puissance4/maventest/src/main/java/gytar/Elements/ressources/redToken.png");
        image = icon.getImage(); 
    }

    public void printToken(){
        System.out.println(this.color + " " + this.num);

    }
}
