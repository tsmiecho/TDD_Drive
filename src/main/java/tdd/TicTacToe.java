package tdd;

/**
 * @author Tomasz Smiechowicz
 */
public class TicTacToe {

    private char[][] board = new char[3][3];

    private char lastPlayer;

    void play(int x, int y) {
        validateAxis(x);
        validateAxis(y);
        validateBox(board[x][y]);
        board[x][y] = nextPlayer();
    }

    private void validateBox(char character) {
        if(character != '\0' ){
            throw new RuntimeException("Box is already occupied");
        }
    }

    private void validateAxis(int coordinate) {
        if(coordinate < 0 || coordinate > 2){
            throw new RuntimeException("Move out of board");
        }
    }

    char nextPlayer() {
        if(lastPlayer == 'X'){
            lastPlayer = 'Y';
            return lastPlayer;
        }
        lastPlayer = 'X';
        return lastPlayer;
    }
}
