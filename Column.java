public class Column {
    private int[] column = new int[7]; 

    public int[] getColumn() {
        return column;
    }
    public void setColumn(int[] column) {
        this.column = column;
    }
    public int getColumnAtId(int i){
        return column[i]; 
    }

    public void setColumnAtId(int i, int num){
        this.column[i] = num; 
    }

    public void initColumn(){
        for(int i = 0; i < column.length; i++){
            column[i] = i+1; 
        }
    }
}
