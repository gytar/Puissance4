package gytar.Interface;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import gytar.DataBase.*;
import gytar.Elements.User;



public class Authentification extends JFrame implements ActionListener {
 
    private static final long serialVersionUID = -681219389204111002L;

    // création de la base de données + un nouvel utilisateur
    // éléments utlilisés dans la classe: 
    JLabel userLabel; 
    JLabel passwordLabel; 
    JLabel message; 
    // saisie de l'utilisateur: son nom et son mot de passe
    JTextField usernameText; 
    JPasswordField passwordField; 

    JButton login; 

    MainInt main; 
    DataBase data = new DataBase();

    // constructeur de la page authentification
    public Authentification(User user) {
         super("Authentification");
         this.setSize(1000, 700);
         init(user); 
    } 
    

    @Override
    public void actionPerformed(ActionEvent arg0) {
        
        String username = usernameText.getText(); 
        String password = String.valueOf(passwordField.getPassword());
        boolean isConnected = data.getUserIdConnection(username, password);

        if(isConnected ==  true) {
            MainInt.user = data.getUserData(username);
            message.setText("You are connected! Welcome " + MainInt.user.getUsername() + "!");
        } else {
            message.setText("Invalid username or password...");
        }

        new Menu(MainInt.user); // créer une autre classe un peu comme main mais différente pour le board (qui a JFrame)
    }

    private void init(User user) {
        // pour avoir le background de la bonne couleur, le getContentPane() -> obligatoire
        getContentPane().setBackground(new Color(171, 228, 255));
        setPreferredSize(new Dimension(1000, 700));
        //pour mettre la fenêtre au centre 
        setLocationRelativeTo(null);
        setFocusable(true);
        // quand on click la croix, on ferme l'application
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        // création du label "username"
        userLabel = new JLabel(); 
        userLabel.setText("Username: ");
        // police d'écriture
        userLabel.setFont(new Font("Confortaa", Font.BOLD, 14));
        // bonnes dimension: sinon trop petit
        userLabel.setPreferredSize(new Dimension(100, 40));

        // création de la zone d'input de l'username
        usernameText = new JTextField(); 
        usernameText.setBackground(new Color(180, 180, 180));
        usernameText.setFont(new Font("Confortaa", Font.PLAIN, 14)); 
        usernameText.setPreferredSize(new Dimension(150, 30)); 

        passwordLabel = new JLabel();
        passwordLabel.setText("Password");
        passwordLabel.setFont(new Font("Confortaa", Font.BOLD, 14));
        passwordLabel.setPreferredSize(new Dimension(100, 30));

        // création de la zone de mot de passe.
        // ici police pas intantiée: no need
        passwordField = new JPasswordField();  
        passwordField.setBackground(new Color(180, 180, 180));
        passwordField.setPreferredSize(new Dimension(150, 30));

        // bouton login
        login = new JButton("Log in!"); 
        // ici l'actionListener est dans init car besoin de User.
        login.addActionListener(this);

        message = new JLabel(); 

        JButton goBack = new JButton("↩");
        // quand on clique sur ce boutton, on veut retourner à la page précédente
        goBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                FirstPage f = new FirstPage(user); 
                f.setVisible(true);
            }
        });

        // création du contentPane, qui permet de mettre tous les éléments dans un cardre
        JPanel contentPane = (JPanel) this.getContentPane(); 
        // gridBagLayout est utilisé pour pouvoir garder nos preferredSize de nos éléments
        contentPane.setLayout(new GridBagLayout());
        // permet de positionner les éléments où on veut
        GridBagConstraints gbc = new GridBagConstraints();
        // contentPane.setBackground(new Color(200,180,255));
        // police d'écriture 
        contentPane.setFont(new Font("Confortaa", Font.PLAIN, 14));
        // premier élément dans la grille: en position (0, 0) de la grille
        gbc.gridx = 0; 
        gbc.gridy = 0; 
        contentPane.add(userLabel, gbc);

        gbc.gridx = 1; 
        gbc.gridy = 0; 
        contentPane.add(usernameText, gbc);
        
        gbc.gridx = 0; 
        gbc.gridy = 1;
        contentPane.add(passwordLabel, gbc);

        gbc.gridx = 1; 
        gbc.gridy = 1;
        contentPane.add(passwordField, gbc);
        
        gbc.gridx = 1; 
        gbc.gridy = 2;  
        contentPane.add(login, gbc);

        gbc.gridx = 0; 
        gbc.gridy = 3;
        contentPane.add(message, gbc); 

        
        gbc.gridx = 2; 
        gbc.gridy = 3; 
        contentPane.add(goBack, gbc);
        pack();
        setVisible(true);  
    }
}
