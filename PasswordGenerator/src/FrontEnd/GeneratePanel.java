package FrontEnd;

import javax.swing.*;
import java.awt.*;

public class GeneratePanel extends AbstractPanel {
    GeneratePanel(String panelText, String buttonText, JPanel cardPanel) {
        super(panelText, buttonText, cardPanel);
        JLabel s = new JLabel();
        s.setText("Ide to");
        this.add(s, BorderLayout.EAST);
    }
    //private final JPanel cardPanel;
//    GeneratePanel(JPanel cardPanel){
//        //this.cardPanel = cardPanel;
//        JLabel text = new JLabel("This page is for password generating.");
//        this.add(text);
//        this.setLayout(new BorderLayout());
//
//        JButton backButton = createButton("Back");
//        this.add(backButton, BorderLayout.EAST);
//
//    }

}
