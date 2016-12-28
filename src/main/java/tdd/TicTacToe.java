package tdd;

/**
 * @author Tomasz Smiechowicz
 */
public class TicTacToe {

    private Character[][] board = new Character[3][3];

    public void play(int x, int y) {
        validateAxis(x);
        validateAxis(y);
        validateBox(board[x][y]);
        board[x][y] = 'X';
    }

    private void validateBox(Character character) {
        if(character != null){
            throw new RuntimeException("Box is already occupied");
        }
    }

    private void validateAxis(int coordinate) {
        if(coordinate < 0 || coordinate > 2){
            throw new RuntimeException("Move out of board");
        }
    }
}
