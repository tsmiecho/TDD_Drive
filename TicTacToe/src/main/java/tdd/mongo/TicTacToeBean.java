package tdd.mongo;

/**
 * @author Tomasz Smiechowicz
 */
public class TicTacToeBean {
    private int turn;
    private char player;
    private int x;
    private int y;

    public TicTacToeBean(int turn, char player, int x, int y) {
        this.turn = turn;
        this.player = player;
        this.x = x;
        this.y = y;
    }

    public int getTurn() {
        return turn;
    }

    public char getPlayer() {
        return player;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
