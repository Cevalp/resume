import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel {

    private int boardSize;
    private final Font font = new Font(Font.MONOSPACED, Font.BOLD, 30);
    private boolean printX = true;
    Board(int boardSize){
        this.boardSize = boardSize;
        this.setLayout(new GridLayout(boardSize, boardSize));
        initialBoard();
    }


    private void initialBoard(){
        for (int i=0; i<boardSize*boardSize; i++){
            JButton positionButton = new JButton();
            positionButton.setFocusable(false);
            positionButton.setFont(font);
            positionButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (positionButton.getText().isEmpty()){
                        if (printX) {
                            positionButton.setText("X");
                            printX = !printX;
                        }
                        else {
                            positionButton.setText("O");
                            printX = !printX;
                        }
                        check();
                    }
                }
            });
            this.add(positionButton);
        }
    }


    private void check(){

    }
}
