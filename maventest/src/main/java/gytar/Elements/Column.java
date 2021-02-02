package gytar.Elements;

public class Column {
    // create the column from the Case class 
    private Case[] column = new Case[7]; 
    // getters and setters 
    public Case[] getColumn() {
        return column;
    }
    public void setColumn(Case[] column) {
        this.column = column;
    }
    //we need to find an element form a specific index
    public Case getColumnAtId(int i){
        return column[i]; 
    }
    // dunno if necessary 
    public void setColumnAtId(int i, Case num){
        this.column[i] = num; 
    }
    // initialisation of the column. 
    public void initColumn(){
        for(int i = 0; i < column.length; i++){
            column[i] = new Case(); 
            // here setX() is used only, because the rest is not needed. 
            column[i].setX(i);
            column[i].setContenant(".");
        }
    }

    // créer fonction est pleine
    // créer fonction impression
    
}
