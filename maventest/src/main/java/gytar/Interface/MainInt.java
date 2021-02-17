package gytar.Interface;

import java.awt.EventQueue;
import gytar.Elements.*;
import javax.swing.JFrame;

public class MainInt extends JFrame {

    private static final long serialVersionUID = 1087048417894547021L;

    public static User user = new User();

    public MainInt(User user) {
        initMain(user);
        setVisible(true);
    }

    private void initMain(User user) {
        add(new FirstPage(user));

    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            JFrame f = new MainInt(user);
            
        });
    }    
}
