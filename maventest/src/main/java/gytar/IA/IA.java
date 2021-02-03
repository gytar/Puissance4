package gytar.IA;

import gytar.Elements.Token;

public class IA {
    private String difficulty; 
    private Token token; 
    private String name;
    
    public String getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    } 
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setToken(Token token) {
        this.token = token;
    }
    public Token getToken() {
        return token;
    }

    /** 
     * To Code: 
     * the 'I suck at this game IA' : picks a random number between 0 and 6 and returns it 
     * the 'arcade IA': improved 'I suck at this game' IA 
     * add some other elements: it is also a "player" so it has to be put 
     */
    
    public int chooseNumber(){
<<<<<<< HEAD
        // l'IA choisi un nombre au hasard entre 1 et 7
=======
>>>>>>> 9d72c3a (IA, game, and all done)
        int number = 1 + (int) (Math.random() * 7);
        return number; 
    }

}
