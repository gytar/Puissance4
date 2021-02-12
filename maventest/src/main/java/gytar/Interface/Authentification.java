package gytar.Interface;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.awt.GridLayout; 

import gytar.DataBase.DataBase;
import gytar.Elements.User;



public class Authentification extends JFrame implements ActionListener {
    DataBase data = new DataBase(); 
    User user = new User(); 

    JLabel userLabel; 
    JLabel passwordLabel; 
    JLabel message; 

    JTextField usernameText; 
    JPasswordField passwordField; 

    JButton login; 

    public Authentification() {
        init(); 
    }   

    private void init() {
        setTitle("Authentification");
        setSize(1000, 700);
        setBackground(new Color(0, 0, 128));
        setLocationRelativeTo(null);
        setFocusable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        userLabel = new JLabel(); 
        userLabel.setText("Username: ");
        usernameText = new JTextField(); 

        userLabel.setPreferredSize(new Dimension(300, 40));
        userLabel.setFont(new Font("Helvetica", Font.PLAIN, 14));

        usernameText.setPreferredSize(new Dimension(300, 40));
        usernameText.setBackground(new Color(180, 180, 180));

        passwordLabel = new JLabel();
        passwordLabel.setText("Password");
        passwordField = new JPasswordField(); 

        passwordLabel.setPreferredSize(new Dimension(300, 10));
        passwordLabel.setFont(new Font("Helvetica", Font.PLAIN, 14));

        passwordField.setPreferredSize(new Dimension(300, 10));
        passwordField.setBackground(new Color(180, 180, 180));


        login = new JButton("Log in!"); 
        login.addActionListener(this);

        login.setPreferredSize(new Dimension(30, 50));

        message = new JLabel(); 


        JPanel panel = new JPanel(new GridLayout(3,1));
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 1000, 100));
        panel.add(userLabel);
        panel.add(usernameText);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(message);
        panel.add(login); 
        panel.setBackground(new Color(200,180,255));
        panel.setFont(new Font("Helvetica", Font.PLAIN, 14));

        add(panel, BorderLayout.NORTH); 
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
