public class Main{
    private static final String SPACE = " ";
    public static void main(String[] args) {
        // déclaration des objets
        Grid grid = new Grid(); 
        Column column = new Column();
        Red r = new Red(); 
        Yellow y = new Yellow(); 
        // initialisation des objets
        grid.initGrid();
        column.initColumn();
        r.initRedToken();
        y.initYellowToken();

        // impression des jetons
        System.out.println(r.color() + " " + y.color());
        System.out.println(r.num() + " " + y.num());
        // impression de la table dans le bon ordre
        for(int i = 5; i >= 0; i--){
            for(int j = 0; j < 7; j++){
                System.out.print(grid.getGridAtPos(i, j) + SPACE);
            }
        System.out.println();
        }
        // impression de la colonne 
        for(int i = 0; i < column.getColumn().length; i++){
            System.out.print(SPACE + column.getColumnAtId(i) + SPACE);
        }
        System.out.println();
    }
}