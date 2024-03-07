import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();

//        int[][] board = initializeBoard(4);
//        Scanner scanner = new Scanner(System.in);
//        show(board);
//        System.out.println();
//        String input = scanner.nextLine();
//        while (!input.isEmpty()){
//            switch (input){
//                case "up" :
//                    up(board);
//                    show(board);
//                    break;
//                case "down" :
//                    down(board);
//                    show(board);
//                    break;
//                case "left" :
//                    left(board);
//                    show(board);
//                    break;
//                case "right" :
//                    right(board);
//                    show(board);
//                    break;
//                default :
//                    System.out.println("Bad input");
//                    break;
//            }
//            input = scanner.nextLine();
//        }


    }

    private static void left(int[][] board){
        int[][] oldBoard = deepCopy(board);

        for(int[] row : board){
            move((row));
        }

        if(!Arrays.deepEquals(board, oldBoard)){
            System.out.println('a');
            generate(board);
        }
    }
    private static void right(int[][] board){
        int[][] oldBoard = deepCopy(board);

        for (int[] row : board){
            int[] reversedRow = new int[board.length];
            int j=0;
            for(int i=reversedRow.length-1; i>=0; i--){
                reversedRow[i] = row[j];
                j++;
            }
            move(reversedRow);
            j=0;
            for(int i=reversedRow.length-1; i>=0; i--){
                row[j] = reversedRow[i];
                j++;
            }
        }

        if(!Arrays.deepEquals(board, oldBoard)){
            System.out.println('a');
            generate(board);
        }
    }
    private static void down(int[][] board){
        int[][] oldBoard = deepCopy(board);

        for (int i=0; i<board.length; i++){
            int[] column = new int[board[i].length];

            int k=0;
            for (int j=column.length-1; j>=0; j--){
                column[k] = board[j][i];
                k++;
            }
            move(column);
            k = 0;
            for (int j=column.length-1; j>=0; j--){
                board[j][i] = column[k];
                k++;
            }
        }

        if(!Arrays.deepEquals(board, oldBoard)){
            System.out.println('a');
            generate(board);
        }
    }

    private static void up(int[][] board){
        int[][] oldBoard = deepCopy(board);

        for (int i=0; i<board.length; i++){
            int[] column = new int[board[i].length];
            for(int j=0; j<column.length; j++){
                column[j] = board[j][i];
            }
            move(column);
            for(int j=0; j<column.length; j++){
                board[j][i] = column[j];
            }
        }

        if(!Arrays.deepEquals(board, oldBoard)){
            System.out.println('a');
            generate(board);
        }
    }

    private static void generate(int[][] board){
        for (int i=0; i< board.length; i++){
            for (int j=0; j<board[i].length; j++){
                if(board[i][j] == 0){
                    if (Math.random() < 0.2){
                        if(Math.random() < 0.7){
                            board[i][j] = 2;
                        } else {
                            board[i][j] = 4;
                        }
                        return;
                    }

                }
            }
        }
    }
    private static int[][] deepCopy(int[][] array){
        int[][] newArray = new int[4][4];
        for(int i=0; i<array.length; i++){
            for (int j=0; j<array[i].length; j++){
                newArray[i][j] = array[i][j];
            }
        }
        return  newArray;
    }

    private static void move(int[] elements){
        // check if array is full of numbers or 0
        boolean isFull = true;
        for (Integer e : elements){
            if (e == 0) {
                isFull = false;
                break;
            }
        }

        // if it is not full of numbers -> SHIFT-MERGE-SHIFT
        // if it is full if numbers -> MERGE-SHIFT

        // shift
        if(!isFull){
            // shift
            for (int i=1; i<elements.length; i++){
                if(elements[i] != 0) {
                    int shift = 1;
                    while ((i - shift >= 0)) {
                        if(elements[i - shift] == 0) {
                            elements[i - shift] = elements[i - shift + 1];
                            elements[i - shift + 1] = 0;
                        }
                        shift++;
                    }
                }
            }
        }

        // merge
        for (int i=1; i<elements.length; i++){
            if (elements[i] == elements[i-1]) {
                elements[i-1] *= 2;
                elements[i] = 0;
            }
        }

        // shift
        for (int i=1; i<elements.length; i++){
            if(elements[i] != 0) {
                int shift = 1;
                while ((i - shift >= 0)) {
                    if(elements[i - shift] == 0) {
                        elements[i - shift] = elements[i - shift + 1];
                        elements[i - shift + 1] = 0;
                    }
                    shift++;
                }
            }
        }

    }

    private static int[][] initializeBoard(int boardSize){
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
    private static void show(int[][] board){
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(board[i][j] == 0) {
                    System.out.print("| |");
                } else {
                    System.out.print("|" + board[i][j] + "|");
                }
            }
            System.out.println();
        }
    }
}
