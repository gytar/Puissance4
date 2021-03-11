package gytar.Elements;

import java.awt.Color;

import javax.swing.*;

public class Case {
    // create variables 
    private String contenant; 
    private int x; 
    private int y;
    private JLabel lbl = new JLabel("", JLabel.CENTER); 
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

    public JLabel getLbl() {
        lbl.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        lbl.setName("case");
        return lbl;
    }

    public void setLbl(JLabel lbl) {
        this.lbl = lbl;
    }
    
    public boolean isFull(){
        if(this.contenant.equals(".")){
            return false; 
        } else {
            return true; 
        }
    }
}