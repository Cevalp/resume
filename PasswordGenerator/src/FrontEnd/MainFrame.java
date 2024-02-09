package FrontEnd;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame(){
        this.setTitle("Password Generator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        //set welcome text
        JLabel welcomeText = new JLabel();
        welcomeText.setText("Welcome to the best password generator in the world.");
        welcomeText.setFont(new Font(Font.SERIF, Font.ITALIC, 30));
        welcomeText.setHorizontalAlignment(JLabel.CENTER);
        welcomeText.setPreferredSize(new Dimension(1000, 100));
        this.add(welcomeText, BorderLayout.PAGE_START);

        //Left panel
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(200, 800));
        this.add(leftPanel, BorderLayout.WEST);

        //Right panel
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(200, 800));
        this.add(rightPanel, BorderLayout.EAST);

        // Creating main three buttons
        JPanel buttonsPanel = new JPanel(new GridLayout(3, 1, 50, 50));
        //buttonsPanel.setSize(800, 600);
        JButton generatePassword = createButton("Generate a new password");
        JButton showPassword = createButton("Show passwords");
        JButton deletePassword = createButton("Delete password");
        buttonsPanel.add(generatePassword);
        buttonsPanel.add(showPassword);
        buttonsPanel.add(deletePassword);
        this.add(buttonsPanel, BorderLayout.CENTER);

        //Bottom part
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(1000, 100));
        this.add(bottomPanel, BorderLayout.PAGE_END);


        this.setVisible(true);
    }

    private JButton createButton(String text){
        JButton button = new JButton();
        button.setText(text);
        return button;
    }

}
