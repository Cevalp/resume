package FrontEnd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ShowPanel extends AbstractPanel implements ActionListener {
    private JButton showButton;
    private JPanel mainPanel;
    private JScrollPane scrollPane;
    private ArrayList<JPanel> elements = new ArrayList<>();
    private int index;


    ShowPanel(String panelText, String buttonText, JPanel cardPanel) {
        super(panelText, buttonText, cardPanel);
        JPanel center = new JPanel(new GridLayout(2, 1));

        JPanel infoPanel = new JPanel(new GridLayout(2, 1));
        showButton = new JButton("Show passwords");
        showButton.addActionListener(this);

        JLabel description = new JLabel();
        String descriptionText = "%s %15s %15s %15s".formatted("Index", "Application name", "User name", "Password");
        description.setText(descriptionText);
        description.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));

        infoPanel.add(showButton);
        infoPanel.add(description);



        mainPanel = new JPanel(new GridLayout());
        scrollPane = new JScrollPane(mainPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        center.add(infoPanel);
        center.add(scrollPane);

        this.add(center, BorderLayout.CENTER);

    }

    private void makePasswordElement(String appName, String userName, String password){
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

        index++; // increment of index, so I can display order of passwords, probably not the best solutions

        element.add(indexNumber);
        element.add(appNameE);
        element.add(nameE);
        element.add(passwordE);

        elements.add(element);
    }

    private void showPasswords(){
        String filePath = getFilePath();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while(line != null){
                String[] elements = line.split(",", 3);
                makePasswordElement(elements[0], elements[1], elements[2]);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e){
            System.out.println("Problem with reading file from ShowPanel");
        }
        index = 0;
        mainPanel.revalidate();
    }

    private void addElementsToPanel(){
        mainPanel.setLayout(new GridLayout(elements.size(),1));
        for (JPanel element : elements){
            mainPanel.add(element);
        }
    }

    void clearPage() {
        mainPanel.removeAll();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == showButton){
            mainPanel.removeAll();
            elements.clear();
            showPasswords();
            addElementsToPanel();
        }
    }
}
