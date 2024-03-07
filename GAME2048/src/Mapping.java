import java.util.Arrays;

public class Mapping {
    public static void render(int[][] board, Block[][] blocks){
        for(int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                blocks[i][j].setText(board[i][j]);
            }
        }
    }

    
    public static void makeMove(int keyCode, int[][] board, Block[][] blocks){
        // 37 ->left
        // 38 ->up
        // 39 ->right
        // 40 ->down
        switch (keyCode){
            case 37:
                left(board);
                render(board, blocks);
                break;
            case 38:
                up(board);
                render(board, blocks);
                break;
            case 39:
                right(board);
                render(board, blocks);
                break;
            case 40:
                down(board);
                render(board, blocks);
                break;
            default:
                break;
        }
    }

    private static void left(int[][] board){
        int[][] oldBoard = deepCopy(board);

        for(int[] row : board){
            move((row));
        }

        if(!Arrays.deepEquals(board, oldBoard)){
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
}
