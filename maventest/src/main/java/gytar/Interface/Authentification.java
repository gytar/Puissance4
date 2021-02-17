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

import gytar.DataBase.DataBase;
import gytar.Elements.User;



public class Authentification extends JFrame implements ActionListener {
 
    private static final long serialVersionUID = -681219389204111002L;

    // création de la base de données + un nouvel utilisateur
    DataBase data = new DataBase(); 
    User user = new User(); 
    // éléments utlilisés dans la classe: 
    JLabel userLabel; 
    JLabel passwordLabel; 
    JLabel message; 
    // saisie de l'utilisateur: son nom et son mot de passe
    JTextField usernameText; 
    JPasswordField passwordField; 

    JButton login; 

    public Authentification() {
         super("Authentification");
         this.setSize(1000, 700);
         init(); 
    }   

    private void init() {
       
        
        /**
         * setLayout(new GridBagLayout());
         * JPanel panel = new JPanel();
         * panel.add(new JLabel("This is a label"));
         * panel.setBorder(new LineBorder(Color.BLACK)); // make it easy to see
         * add(panel, new GridBagConstraints());
         * setSize(400, 400);
         * setLocationRelativeTo(null);
         * setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         * setVisible(true);
         */
        getContentPane().setBackground(new Color(0, 0, 128));
        setPreferredSize(new Dimension(1000, 700));
        //pour mettre la fenêtre au centre 
        setLocationRelativeTo(null);
        setFocusable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       

        userLabel = new JLabel(); 
        userLabel.setText("Username: ");
        userLabel.setFont(new Font("Helvetica", Font.PLAIN, 14)); // la police ne fonctionne pas quand on ajoute en général 
        userLabel.setPreferredSize(new Dimension(100, 40));


        usernameText = new JTextField(); 
        usernameText.setBackground(new Color(180, 180, 180));
        usernameText.setPreferredSize(new Dimension(150, 30));

       

        passwordLabel = new JLabel();
        passwordLabel.setText("Password");
        passwordLabel.setFont(new Font("Helvetica", Font.PLAIN, 14));
        passwordLabel.setPreferredSize(new Dimension(100, 30));



        passwordField = new JPasswordField();  
        passwordField.setBackground(new Color(180, 180, 180));
        passwordField.setPreferredSize(new Dimension(150, 30));

        login = new JButton("Log in!"); 
        login.addActionListener(this);



        message = new JLabel(); 


        JButton goBack = new JButton("↩");
        // quand on clique sur ce boutton, on veut retourner à la page précédente
        goBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                FirstPage f = new FirstPage(); 
                f.setVisible(true);
            }
        });


        JPanel contentPane = (JPanel) this.getContentPane(); 

        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        contentPane.setBackground(new Color(200,180,255));
        contentPane.setFont(new Font("Helvetica", Font.PLAIN, 14));

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

	@Override
	public void actionPerformed(ActionEvent arg0) {
        String username = usernameText.getText(); 
        String password = String.valueOf(passwordField.getPassword());

        user.setPassword(password);
        user.setUsername(username);

        boolean isConnected = data.getUserIdConnection(username, password); 

        if(isConnected ==  true) {
            message.setText("You are connected! \nWelcome " + user.getUsername() + "!");
            user = data.getUserData(username);
        } else {
            message.setText("Invalid username or password...");
        }

	}


}
