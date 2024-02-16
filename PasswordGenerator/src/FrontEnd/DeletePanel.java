package FrontEnd;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DeletePanel extends AbstractPanel {

    private int index;
    private ArrayList<JPanel> elements = new ArrayList<>();

    DeletePanel(String panelText, String buttonText, JPanel cardPanel) {
        super(panelText, buttonText, cardPanel);
        index = 0;


    }

    private void makeDeleteElement(String appName, String userName, String password){
        JPanel element = new JPanel(new GridLayout(1, 4));
        Font font = new Font(Font.MONOSPACED, Font.BOLD, 13);

        JLabel appNameE = new JLabel((appName.isEmpty()) ? "Unknown" : appName);
        appNameE.setFont(font);
        JLabel nameE = new JLabel((userName.isEmpty()) ? "Unknown" : userName);
        nameE.setFont(font);
        JLabel passwordE = new JLabel(password);
        passwordE.setFont(font);
        JLabel indexNumber = new JLabel(Integer.toString(index));
        indexNumber.setFont(font);
        JButton deleteButton = new JButton("Delete");


        index++; // increment of index, so I can display order of passwords, probably not the best solutions

        element.add(indexNumber);
        element.add(appNameE);
        element.add(nameE);
        element.add(passwordE);
        element.add(deleteButton);

        elements.add(element);
    }

    void clearPage() {

    }
}
