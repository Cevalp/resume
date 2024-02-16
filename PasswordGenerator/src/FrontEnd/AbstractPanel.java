package FrontEnd;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public abstract class AbstractPanel extends JPanel {
    private final JPanel cardPanel;
    private final String imagePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "Utils" +
                                    File.separator + "Images" + File.separator + "backArrow.png";

    private final String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "Utils" +
            File.separator + "Files" + File.separator + "passwords.txt";

    protected static Color bckColor = new Color(255, 255, 255);
    AbstractPanel(String panelText, String buttonText, JPanel cardPanel){
        this.cardPanel = cardPanel;
        this.setBackground(AbstractPanel.bckColor);
        this.setLayout(new BorderLayout());

        // Up part of the page
        JLabel pageText = new JLabel();
        pageText.setText(panelText);
        pageText.setFont(new Font(Font.SERIF, Font.ITALIC, 30));
        pageText.setHorizontalAlignment(JLabel.CENTER);
        pageText.setPreferredSize(new Dimension(1000, 100));
        this.add(pageText, BorderLayout.PAGE_START);

        // Left part the of page
        JPanel leftPart = new JPanel(new FlowLayout(FlowLayout.LEADING));
        leftPart.setBackground(AbstractPanel.bckColor);
        leftPart.add(createButton(buttonText));
        leftPart.setPreferredSize(new Dimension(150, 800));
        this.add(leftPart, BorderLayout.WEST);

        // Right part of the page
        JPanel rightPart = new JPanel();
        rightPart.setBackground(AbstractPanel.bckColor);
        rightPart.setPreferredSize(new Dimension(150, 800));
        this.add(rightPart, BorderLayout.EAST);

        // Bottom part of the page
        JPanel bottomPart = new JPanel();
        bottomPart.setBackground(AbstractPanel.bckColor);
        bottomPart.setPreferredSize(new Dimension(1000, 100));
        this.add(bottomPart, BorderLayout.PAGE_END);

    }

    private JButton createButton(String text){
        JButton button = new JButton();
        button.setFocusable(false);
        button.setIcon(new ImageIcon(imagePath));
        button.setBackground(AbstractPanel.bckColor);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearPage();
                ((CardLayout)cardPanel.getLayout()).show(cardPanel, "MainPanel");
            }
        });

        return button;
    }

    protected String getFilePath(){
        return filePath;
    }

    abstract void clearPage();
    //abstract void makePass

}
