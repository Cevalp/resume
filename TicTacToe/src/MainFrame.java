import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    MainFrame(){
        this.setTitle("TicTacToe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);


        JPanel mainPanel = new JPanel(new CardLayout());


        JPanel menu = new StartMenu(mainPanel);
        JPanel board = new Board(3);
        JPanel options = new Options();



        mainPanel.add(menu, "Menu");
        mainPanel.add(board, "Play");
        mainPanel.add(options, "Options");


        this.add(mainPanel);
        this.setVisible(true);
    }
}
