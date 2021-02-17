package gytar.Interface;

import javax.swing.JFrame;


public class GameGUI extends JFrame {
    private static final long serialVersionUID = 1L;

    public GameGUI() {
        initUI(); 
    }

    private void initUI() {
        add(new Board());

        setTitle("falling down");
        setSize(1000, 700); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
    }
}
