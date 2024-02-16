import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu extends JPanel {

    private final Font font = new Font(Font.MONOSPACED, Font.BOLD, 30);
    private JPanel cards;
    StartMenu(JPanel cards){
        this.cards = cards;
        this.setLayout(new BorderLayout());

        // Title panel
        JPanel titlePanel = createTitle();
        titlePanel.setPreferredSize(new Dimension(1000, 100));

        // Left panel, Right panel, Bottom panel
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(150, 600));
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(150, 600));
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(1000, 100));


        JPanel buttonsPanel = new JPanel(new GridLayout(2, 1));
        buttonsPanel.setPreferredSize(new Dimension(800, 600));
        buttonsPanel.add(createButton("Play"));
        buttonsPanel.add(createButton("Options"));

        this.add(titlePanel, BorderLayout.PAGE_START);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(buttonsPanel, BorderLayout.CENTER);
        this.add(rightPanel, BorderLayout.EAST);
        this.add(bottomPanel, BorderLayout.PAGE_END);
    }

    private JPanel createTitle(){
        JPanel panel = new JPanel();

        JLabel text = new JLabel();
        text.setFont(font);
        text.setText("Title");

        return panel;
    }

    private JButton createButton(String text){
        JButton button = new JButton();
        button.setFont(font);
        button.setText(text);
        button.setFocusable(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((CardLayout)cards.getLayout()).show(cards, text);
            }
        });
        return button;
    }
}
