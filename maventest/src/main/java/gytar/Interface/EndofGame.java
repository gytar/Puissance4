package gytar.Interface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

public class EndofGame extends JFrame {

    private static final long serialVersionUID = 597581671447405007L;

    JLabel winMessage; 

    public EndofGame() {
        
        

        String yellowWinner =  "Ow no, you lost :("; 
        String redWinner = MainInt.user.getUsername() + " has won";
        String wins = "You won " + MainInt.user.getWinnings() + " times";
        String lost = "You lost " + MainInt.user.getLosings() + " times";
        int ratio = (int) (MainInt.user.getRatio() * 100); 
        String ratios = "Your victory ratio: " + ratio + "%"; 
        String draw = "It's a draw"; 
        String tryAgain = "Try again?"; 
        String quit = "I rage quit"; 
        Font myFont = new Font("Confortaa", Font.PLAIN, 14); 

        setPreferredSize(new Dimension(1000, 700));
        
        
        JLabel winStat = new JLabel(wins);
        winStat.setFont(new Font("Confortaa", Font.PLAIN, 14));
        winStat.setPreferredSize(new Dimension(300, 50));

        JLabel looseStat = new JLabel(lost);
        looseStat.setFont(new Font("Confortaa", Font.PLAIN, 14));
        looseStat.setPreferredSize(new Dimension(300, 50));

        JLabel ratioStat = new JLabel(ratios);
        ratioStat.setFont(new Font("Confortaa", Font.PLAIN, 14));
        ratioStat.setPreferredSize(new Dimension(300, 50));


        
        winMessage = new JLabel(); 
        winMessage.setFont(new Font("Confortaa", Font.PLAIN, 35));
        winMessage.setPreferredSize(new Dimension(400, 100));

        JButton quitting = new JButton(quit);
        //quitting.setForeground(new Color(190, 190, 190));
        quitting.setBackground(new Color(190, 190, 190));
        quitting.setFont(myFont);
        //quitting.setBorderPainted(false);
        quitting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); 
            }
        }); 

        JButton tryA = new JButton(tryAgain); 
        //tryA.setForeground(new Color(190, 190, 190));
        tryA.setBackground(new Color(190, 190, 190));
        tryA.setFont(myFont);
        //tryA.setBorderPainted(false);
        tryA.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Menu b = new Menu(MainInt.user); 
                b.setVisible(true);
            }
        });

        if(Board.winner == MainInt.user.getUsername()) {
            setTitle("You won");
            getContentPane().setBackground(new Color(0, 200, 0));
            winMessage.setText(redWinner);
        } else if(Board.winner == "AI") {
            setTitle("You lost");
            getContentPane().setBackground(new Color(200, 0, 0));
            winMessage.setText(yellowWinner);
        } else {
            setTitle("Draw");
            getContentPane().setBackground(new Color(180, 180, 180));
            winMessage.setText(draw);
        }

        JPanel contentPane = (JPanel) this.getContentPane(); 

        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints(); 

        gbc.gridx = 0; 
        gbc.gridy = 0; 
        contentPane.add(winMessage, gbc); 
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        contentPane.add(tryA, gbc); 

        gbc.gridx = 0; 
        gbc.gridy = 2; 
        contentPane.add(quitting, gbc); 

        gbc.gridx = 0; 
        gbc.gridy = 3; 
        contentPane.add(winStat, gbc);

        gbc.gridx = 0; 
        gbc.gridy = 4; 
        contentPane.add(looseStat, gbc);

        gbc.gridx = 0; 
        gbc.gridy = 5; 
        contentPane.add(ratioStat, gbc);

        setFocusable(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);



        

        

    }   
}