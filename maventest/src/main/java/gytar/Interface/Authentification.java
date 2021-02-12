package gytar.Interface;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Authentification {
  
    public static void main(String[] args) {  // main obligatoire pour run le programme

        JFrame frame = new JFrame("CONNECT FOUR"); // création d'un cadre 
        JPanel panel = new JPanel(); //création d'un panneau  

        frame.setSize(350,150); // taille cadre (largeur,hauteur)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // permet de fermer le cadre
        
        frame.add(panel); // permet d'ajouter la panneau dans le cadre 
       
        panel.setLayout(null); // permet l'affichage de texte dans l'interface 

        JLabel playerLabel = new JLabel("Player"); // permet la création d'un affichage texte ici player 
        playerLabel.setBounds(20, 20, 80, 25); //défini la position et la taille du composant de l'interface graphique player
        panel.add(playerLabel); //ajout de la zone player

        JTextField playerText = new JTextField(20); // zone d'édition de texte ( getText() et setText(String s) permettent de récupérer le texte tapé par l'utilisateur, ou d'affecter un texte )
        playerText.setBounds(100, 20, 165, 25); // défini la taille et la position de la zone de texte player (abscisse,ordonnée,largeur,hauteur,)
        panel.add(playerText); // ajout de la zone de saisie player

        JLabel passwordLabel = new JLabel("Password"); // permet la création d'un affichage texte ici password
        passwordLabel.setBounds(20 , 50, 80, 25); // défini la taille et la position de la zone de texte password
        panel.add(passwordLabel); // ajout de la zone password

        JPasswordField passwordText = new JPasswordField(20);// zone d'édition de texte 
        passwordText.setBounds(100, 50, 165, 25); //défini taille et position
        panel.add(passwordText); // ajout de la zone de saisie password

        JButton button = new JButton("Connection"); //création d'un bouton
        button.setBounds(100,80,100,25); //défini la taille et la position
        panel.add(button);//ajout du bouton au panneau

        JButton back = new JButton ("<");
        back.setBounds(223,80,41,25);
        panel.add(back);

        frame.setVisible(true); //rend le cadre visible 
    }
}
