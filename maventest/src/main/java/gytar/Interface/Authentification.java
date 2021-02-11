package gytar.Interface;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Authentification {
  
    public static void main(String[] args) {  // main obligatoire pour run le programme

        JFrame frame = new JFrame(); // création d'un cadre 
        JPanel panel = new JPanel(); //création d'un panneau  

        frame.setSize(500,500); // taille cadre 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // permet de fermer le cadre
        
        frame.add(panel); // permet d'ajouter la panneau dans le cadre 
       
        panel.setLayout(null); // permet l'affichage de texte dans l'interface 

        JLabel playerLabel = new JLabel("Player"); // permet la création d'un affichage texte ici player 
        playerLabel.setBounds(10, 100, 150, 25); //défini la position et la taille du composant de l'interface graphique player
        panel.add(playerLabel); //ajout de la zone player

        JTextField playerText = new JTextField(20); // zone d'édition de texte ( getText() et setText(String s) permettent de récupérer le texte tapé par l'utilisateur, ou d'affecter un texte )
        playerText.setBounds(100, 100, 150, 25); // défini la taille et la position de la zone de texte player (abscisse,ordonnée,largeur,hauteur,)
        panel.add(playerText); // ajout de la zone de saisie player

        JLabel passwordLabel = new JLabel("Password"); // permet la création d'un affichage texte ici password
        passwordLabel.setBounds(10 , 200, 150, 25); // défini la taille et la position de la zone de texte password
        panel.add(passwordLabel); // ajout de la zone password

        JPasswordField passwordText = new JPasswordField(20);// zone d'édition de texte 
        passwordText.setBounds(100, 200, 150, 25); //défini taille et position
        panel.add(passwordText); // ajout de la zone de saisie password

        frame.setVisible(true); //rend le cadre visible 
    }
}
