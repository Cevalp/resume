import javax.swing.*;
import java.awt.*;

public class Block extends JPanel{

    private JLabel element;

    public Block(){
        this.setLayout(new GridLayout(1,1));
        element = new JLabel("", SwingConstants.CENTER);
        element.setFont(new Font(Font.MONOSPACED, Font.BOLD, 45));
        this.add(element);
    }

    public void setText(int number){

        if(number == 0){
            element.setText("");
            this.setBackground(new Color(255, 255, 255));
        }else {
            element.setText(Integer.toString(number));
            this.setBackground(getColor(number));
        }
        // 2048
    }

    private Color getColor(int number){

        int index=0;
        while(number!=1){
            number /= 2;
            index++;
        }
        index--;
        return Colors.values()[index].getColor();
    }
}
