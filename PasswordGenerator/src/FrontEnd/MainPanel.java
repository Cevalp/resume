package FrontEnd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {

    private JPanel cardPanel;
    private final Color bckColor = new Color(255, 255, 255);
    MainPanel(JPanel cardPanel){
        this.cardPanel = cardPanel;
        this.setBackground(bckColor);
        this.setLayout(new BorderLayout());

        //set welcome text
        JLabel welcomeText = new JLabel();
        welcomeText.setBackground(bckColor);
        welcomeText.setText("Welcome to the best password generator in the world.");
        welcomeText.setFont(new Font(Font.SERIF, Font.ITALIC, 30));
        welcomeText.setHorizontalAlignment(JLabel.CENTER);
        welcomeText.setPreferredSize(new Dimension(1000, 100));
        this.add(welcomeText, BorderLayout.PAGE_START);

        //Left panel
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(bckColor);
        leftPanel.setPreferredSize(new Dimension(200, 800));
        this.add(leftPanel, BorderLayout.WEST);

        //Right panel
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(bckColor);
        rightPanel.setPreferredSize(new Dimension(200, 800));
        this.add(rightPanel, BorderLayout.EAST);

        // Creating main three buttons, Center panel
        JPanel buttonsPanel = new JPanel(new GridLayout(3, 1, 50, 50));
        buttonsPanel.setBackground(bckColor);
        JButton generatePassword = createButton("Generate a new password", "GeneratePanel");
        JButton showPassword = createButton("Show passwords", "ShowPanel");
        JButton deletePassword = createButton("Delete password", "DeletePanel");
        buttonsPanel.add(generatePassword);
        buttonsPanel.add(showPassword);
        buttonsPanel.add(deletePassword);
        this.add(buttonsPanel, BorderLayout.CENTER);

        //Bottom part
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(bckColor);
        bottomPanel.setPreferredSize(new Dimension(1000, 100));
        this.add(bottomPanel, BorderLayout.PAGE_END);

    }

    private JButton createButton(String text, String panel){
        JButton button = new JButton();
        button.setText(text);
        button.setFocusable(false);
        button.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        //button.setToolTipText(toolTipText);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ((CardLayout)cardPanel.getLayout()).show(cardPanel, panel);
            }
        });

        return button;
    }

}
