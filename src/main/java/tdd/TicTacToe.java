package tdd;

/**
 * @author Tomasz Smiechowicz
 */
public class TicTacToe {

    private Character[][] board = new Character[3][3];

    public void play(int x, int y) {
        if(x > 3 || y > 3){
            throw new RuntimeException("Move out of board");
        }
        if (x <0 || y < 0){
            throw new RuntimeException("Move out of board");
        }
        if(board[x][y] != null){
            throw new RuntimeException("Place is already occupied");
        }
        board[x][y] = 'X';
    }
}
