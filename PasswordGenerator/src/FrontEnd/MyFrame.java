package FrontEnd;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    private MainPanel mainPanel;
    private GeneratePanel generatePanel;
    private ShowPanel showPanel;
    private DeletePanel deletePanel;
    private CardLayout layout = new CardLayout();

    public MyFrame(){
        this.setTitle("Password Generator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new GridLayout());

        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(layout);

        mainPanel = new MainPanel(cardPanel);
        generatePanel = new GeneratePanel("This page is for password generating", "Back", cardPanel);
        showPanel = new ShowPanel("This page is for showing password", "Back", cardPanel);
        deletePanel = new DeletePanel("This page is for deleting password", "Back", cardPanel);


        // adding all panels to card layout and set corresponding layout name
        cardPanel.add(mainPanel, "MainPanel");
        cardPanel.add(generatePanel, "GeneratePanel");
        cardPanel.add(showPanel, "ShowPanel");
        cardPanel.add(deletePanel, "DeletePanel");

        layout.show(cardPanel, "MainPanel");

        this.add(cardPanel);
        this.setVisible(true);
    }
}
