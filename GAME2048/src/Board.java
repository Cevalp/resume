import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Board extends JPanel implements KeyListener {

    private JLabel textLabel;
    private JPanel center;

    private Block[][] blocks;
    private int[][] board;
    private final int boardSize;
    public Board(int boardSize){
        this.boardSize = boardSize;
        blocks = new Block[boardSize][boardSize];
        board = new int[boardSize][boardSize];

        this.setLayout(new BorderLayout(10,0));

        JTextField t = new JTextField();
        t.addKeyListener(this);
        this.add(t);

        center = makeCenter();
        this.add(createUselessPanels("Score:", false), BorderLayout.NORTH);
        this.add(createUselessPanels("", false), BorderLayout.SOUTH);
        this.add(createUselessPanels("", true), BorderLayout.WEST);
        this.add(createUselessPanels("", true), BorderLayout.EAST);
        this.add(center, BorderLayout.CENTER);
    }

    private JPanel createUselessPanels(String text, Boolean side){
        // this function creates panels around center in BorderLayout
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        if (side) {
            panel.setPreferredSize(new Dimension(100, 600));
        }else {
            panel.setPreferredSize(new Dimension(1000, 100));
        }

        if(text.isEmpty()) return panel;

        textLabel = new JLabel(text);
        panel.add(textLabel);
        return panel;
    }

    private JPanel makeCenter(){
        // initialize board with numbers
        board = initializeBoard();

        // create GUI of board
        JPanel panel = new JPanel(new GridLayout(4,4,10,10));
        panel.setBackground(Color.darkGray);

        for (int i=0; i<boardSize; i++){
            for (int j=0; j<boardSize; j++){
                Block b = new Block();
                b.setText(board[i][j]);
                panel.add(b);
                blocks[i][j] = b;
            }
        }



        return panel;
    }

    private int[][] initializeBoard(){
        int[][] board = new int[boardSize][boardSize];
        String[] initialNumbers = {"2", "4"};
        Random random = new Random();
        byte numbersCount = 0;

        for (int i=0; i<boardSize; i++){
            for (int j=0; j<boardSize; j++){
                if(Math.random() > 0.6 && numbersCount<2) {
                    board[i][j] = Integer.parseInt(initialNumbers[random.nextInt(initialNumbers.length)]);
                    numbersCount++;
                }
            }
        }
        return board;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        //System.out.println(keyCode);
        Mapping.makeMove(keyCode, board, blocks);
    }
}
