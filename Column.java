public class Column {
    private Case[] column = new Case[7]; 

    public Case[] getColumn() {
        return column;
    }
    public void setColumn(Case[] column) {
        this.column = column;
    }
    public Case getColumnAtId(int i){
        return column[i]; 
    }

    public void setColumnAtId(int i, Case num){
        this.column[i] = num; 
    }

    public void initColumn(){
        for(int i = 0; i < column.length; i++){
            column[i] = new Case(); 
            column[i].setX(i);
        }
    }
}
