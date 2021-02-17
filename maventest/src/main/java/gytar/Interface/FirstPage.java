package gytar.Interface;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gytar.Elements.User;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;


public class FirstPage extends JFrame implements ActionListener {


    public FirstPage(User user) {
        init(user); 
    }

    private void init(User user) {

        
        setTitle("Hello!");
        setSize(1000, 700);
        setBackground(new Color(0, 0, 128));
        setLocationRelativeTo(null);
        setFocusable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

 
        
        JPanel paneltitle = new JPanel(); 
        JLabel title = new JLabel("Welcome to the Connect 4!", JLabel.CENTER);
        title.setFont(new Font("Helvetica", Font.PLAIN, 32)); 
        paneltitle.add(title); 
        paneltitle.setBackground(new Color(0,0,200));
        paneltitle.setLocation(500, 0);
        


        JPanel panel1 = new JPanel();
        JButton createAccount = new JButton("Create Account");
        createAccount.setFont(new Font("Helvetica", Font.PLAIN, 14));
        createAccount.setPreferredSize(new Dimension(400, 40));
        createAccount.setBackground(new Color(200,200,0));
        
        createAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CreateAnAccount create = new CreateAnAccount(user); 
                create.setVisible(true); 
            }
        });
        panel1.add(createAccount); 
        panel1.setBackground(new Color(0,0,200));

        

        JPanel panel2 = new JPanel(); 
        JButton login = new JButton("Log In");
        login.setFont(new Font("Helvetica", Font.PLAIN, 14));
        
        login.setBackground(new Color(180,0,0));
        login.setPreferredSize(new Dimension(400, 40));
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Authentification auth = new Authentification(user); 
                auth.setVisible(true); 
            }
        });
        panel2.add(login); 
        panel2.setBackground(new Color(0,0,200));

        

        int top = 100; 
        int bottom = 600; 
        int left = 250; 
        int right = 250;
        
        JPanel containerPanel = new JPanel(new GridLayout(4,1));
        containerPanel.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));
        containerPanel.setBackground(new Color(0, 0, 128));
        containerPanel.add(paneltitle);
        containerPanel.add(panel1);
        containerPanel.add(panel2);
        

        add(containerPanel, BorderLayout.NORTH); 
       


        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    

}