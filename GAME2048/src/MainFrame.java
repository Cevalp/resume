import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame(){
        this.setTitle("2048");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.add(new Board(4));

        this.setVisible(true);
    }
}
