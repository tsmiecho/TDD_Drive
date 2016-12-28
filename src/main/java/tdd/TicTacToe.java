package tdd;

/**
 * @author Tomasz Smiechowicz
 */
public class TicTacToe {

    private char[][] board = new char[3][3];

    private char lastPlayer;

    enum BoardState{
        X_WIN, Y_WIN, DRAW, IN_PROGRESS
    }

    BoardState play(int x, int y) {
        validateAxis(x);
        validateAxis(y);
        validateBox(board[x][y]);
        board[x][y] = nextPlayer();
        if (isWin()) {
            return getBoardState();
        }
        if (isDraw()){
            return BoardState.DRAW;
        }
        return BoardState.IN_PROGRESS;
    }

    private boolean isDraw() {
        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if(board[i][j] == '\0'){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isWin() {
        return checkHorizontalLine() || checkColumn() || checkDiagonalLine();
    }

    private boolean checkDiagonalLine() {
        return  board[0][0] == lastPlayer && board[1][1] == lastPlayer && board[2][2] == lastPlayer ||
                board[2][0] == lastPlayer && board[1][1] == lastPlayer && board[0][2] == lastPlayer;
    }

    private boolean checkColumn() {
        for(int i=0; i < 3; i++) {
            if (board[i][0] == lastPlayer && board[i][1] == lastPlayer && board[i][2] == lastPlayer) {
                return true;
            }
        }
        return false;
    }

    private boolean checkHorizontalLine() {
        for(int i=0; i < 3; i++) {
            if (board[0][i] == lastPlayer && board[1][i] == lastPlayer && board[2][i] == lastPlayer) {
                return true;
            }
        }
        return false;
    }

    private BoardState getBoardState() {
        return lastPlayer == 'X' ? BoardState.X_WIN : BoardState.Y_WIN;
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
