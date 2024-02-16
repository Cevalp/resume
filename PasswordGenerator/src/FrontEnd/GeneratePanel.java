package FrontEnd;

import BackEnd.Generatable;
import BackEnd.IntermediateGenerator;
import BackEnd.StrongGenerator;
import BackEnd.WeakGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class GeneratePanel extends AbstractPanel implements ActionListener {
    // this is code for panel where user can generate password

    private JRadioButton weakPassword;
    private JRadioButton intermediatePassword;
    private JRadioButton strongPassword;
    private JRadioButton ownPasswordRadioButton;
    private JRadioButton generatePasswordRadioButton;
    private JLabel explainText;
    private final ButtonGroup choiceGroup;
    private JButton createPasswordButton;
    private JButton saveButton;
    private JLabel passwordText;
    private JTextField appTextField;
    private JTextField nameTextField;
    private JTextField passwordField;
    private final Font font;

    private final Generatable weakGenerator = new WeakGenerator();
    private final Generatable intermGenerator = new IntermediateGenerator();
    private final Generatable strongGenerator = new StrongGenerator();

    GeneratePanel(String panelText, String buttonText, JPanel cardPanel) {
        super(panelText, buttonText, cardPanel);
         font = new Font(Font.MONOSPACED, Font.BOLD, 17);

        // Center part of page when user can create password
        JPanel mainPart = new JPanel(new GridLayout(3, 1));

        // Get info about app user use and also get his/her user info
        JPanel appTextPanel = getInfoFromUser();


        // In this block is code for creating password
        choiceGroup = new ButtonGroup();
        JPanel createPasswordPanel = new JPanel(new GridLayout(2, 1));
            // here is tool for user to set own password if he/she likes
        JPanel ownPasswordPanel = createOwnPassword();
        // In this block is code for generating password
        JPanel generatePasswordPanel = generatePassword();
            // adding all to pane for creating password
        createPasswordPanel.add(ownPasswordPanel);
        createPasswordPanel.add(generatePasswordPanel);

        // In this block is code for panel in which password is displayed and user can save it with button
        JPanel showPanel = showPassword();


        mainPart.add(appTextPanel);
        mainPart.add(createPasswordPanel);
        mainPart.add(showPanel);

        this.add(mainPart, BorderLayout.CENTER);
    }

    @Override
    void clearPage() {
        // set page to default look
        passwordText.setText("");
        explainText.setText("Only low letters and length is 5 characters.");
        weakPassword.setSelected(true);
        intermediatePassword.setSelected(false);
        strongPassword.setSelected(false);
        ownPasswordRadioButton.setSelected(true);
        generatePasswordRadioButton.setSelected(false);
        appTextField.setText("");
        nameTextField.setText("");
        passwordField.setText("");
    }

    private JPanel getInfoFromUser(){
        JPanel appTextPanel = new JPanel(new GridLayout(2, 1));
        // get app name from user
        JPanel appInfo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel appText = new JLabel();
        String appTextString = "Name of application (optional)";
        appText.setText("%s %5s".formatted(appTextString, ""));
        //appText.setText(appTextString);
        appText.setFont(font);


        appTextField = new JTextField();
        appTextField.setColumns(25);
        appInfo.add(appText);
        appInfo.add(appTextField);
        // get username from user
        JPanel userNameInfo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel nameText = new JLabel();
        String nameTextString = "Your user name (email)";
        nameText.setText("%s %7s".formatted(nameTextString, " "));
        //nameText.setText(nameTextString);
        nameText.setFont(font);


        nameTextField = new JTextField();
        nameTextField.setColumns(25);
        userNameInfo.add(nameText);
        userNameInfo.add(nameTextField);

        appTextPanel.add(appInfo);
        appTextPanel.add(userNameInfo);

        return appTextPanel;
    }
    private JPanel createOwnPassword(){
        // here is tool for user to set own password if he/she likes
        JPanel ownPasswordPanel = new JPanel(new GridLayout(2, 1));

        ownPasswordRadioButton = new JRadioButton("Create own password");
        ownPasswordRadioButton.addActionListener(this);
        ownPasswordRadioButton.setSelected(true);
        choiceGroup.add(ownPasswordRadioButton);

        // Panel for reading password from user
        JPanel userPassword = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel ownPasswordText = new JLabel();
        String text = "Write your own password";
        ownPasswordText.setText(text);
        ownPasswordText.setFont(font);
        passwordField = new JTextField();
        passwordField.setColumns(25);
        userPassword.add(ownPasswordText);
        userPassword.add(passwordField);

        ownPasswordPanel.add(ownPasswordRadioButton);
        ownPasswordPanel.add(userPassword);

        return ownPasswordPanel;
    }
    private JPanel generatePassword(){
        // In this block is code for generating password
        JPanel generatePasswordPanel = new JPanel(new GridLayout(3, 1));
        generatePasswordRadioButton = new JRadioButton("Generate password");
        choiceGroup.add(generatePasswordRadioButton);

        // panel only for buttons
        JPanel generatePasswordButtonsPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));

        // create password button
        createPasswordButton = new JButton();
        createPasswordButton.addActionListener(this);
        createPasswordButton.setText("Create");

        // radio buttons for selecting which types of password user want
        weakPassword = new JRadioButton("Weak password");
        weakPassword.addActionListener(this);
        intermediatePassword = new JRadioButton("Intermediate password");
        intermediatePassword.addActionListener(this);
        strongPassword = new JRadioButton("Strong password");
        strongPassword.addActionListener(this);
        ButtonGroup generateGroup = new ButtonGroup();
        generateGroup.add(weakPassword);
        generateGroup.add(intermediatePassword);
        generateGroup.add(strongPassword);

        generatePasswordButtonsPanel.add(weakPassword);
        generatePasswordButtonsPanel.add(intermediatePassword);
        generatePasswordButtonsPanel.add(strongPassword);
        generatePasswordButtonsPanel.add(createPasswordButton);

        // Text for explain what each type of password means
        explainText = new JLabel();
        explainText.setHorizontalAlignment(JLabel.CENTER);
        explainText.setVerticalAlignment(JLabel.CENTER);


        // adding radioButtons and create button
        generatePasswordPanel.add(generatePasswordRadioButton);
        generatePasswordPanel.add(generatePasswordButtonsPanel);
        generatePasswordPanel.add(explainText);

        return generatePasswordPanel;
    }
    private JPanel showPassword(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        passwordText = new JLabel();
        passwordText.setFont(new Font(Font.DIALOG, Font.ITALIC, 15));
        saveButton = new JButton("Save password");
        saveButton.addActionListener(this);

        panel.add(passwordText);
        panel.add(saveButton);

        return panel;
    }
    private void save(String appName, String userName, String password){
        try{
            String filePath = getFilePath();
            FileWriter myFile = new FileWriter(filePath, true);
            myFile.write(appName + "," + userName + "," + password + System.lineSeparator());
            myFile.close();
        } catch (IOException e){
            System.out.println("Error occurred when saving password to file.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == weakPassword){
            explainText.setText("Only low letters and length is 5 characters.");
        } else if (e.getSource() == intermediatePassword) {
            explainText.setText("Lowercase and Uppercase characters with numbers. Length is 10 elements.");
        } else if (e.getSource() == strongPassword) {
            explainText.setText("Lowercase, Uppercase characters with numbers and special symbols. Length is 15 elements.");
        } else if (e.getSource() == createPasswordButton && generatePasswordRadioButton.isSelected()) {
            if (weakPassword.isSelected()) {
                String password = weakGenerator.passwordGenerate();
                passwordText.setText("Your generated password is: " + password);
            } else if (intermediatePassword.isSelected()) {
                String password = intermGenerator.passwordGenerate();
                passwordText.setText("Your generated password is: " + password);
            } else if (strongPassword.isSelected()) {
                String password = strongGenerator.passwordGenerate();
                passwordText.setText("Your generated password is: " + password);
            } else {
                System.out.println("Somewhere is mistake.");
            }

        } else if (e.getSource() == ownPasswordRadioButton) {
            passwordText.setText("");
        } else if (e.getSource() == saveButton) {
            String appName = appTextField.getText();
            String userName = nameTextField.getText();
            String password;
            if (ownPasswordRadioButton.isSelected()){
                password = passwordField.getText();
            } else{
                password = passwordText.getText();
            }
            if(password.isEmpty()){
                passwordText.setText("Password can not be empty");
            } else{
                passwordText.setText("");
                passwordField.setText("");
                save(appName, userName, password.replace("Your generated password is: ", ""));
            }
        }
    }
}
