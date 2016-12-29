package tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author Tomasz Smiechowicz
 */
public class TicTacToeTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private TicTacToe ticTacToe;

    @Before
    public void setUp() throws Exception {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void whenXOutOfBoardThenRuntimeException() throws Exception {
        expectedException.expect(RuntimeException.class);
        ticTacToe.play(5, 2);
    }

    @Test
    public void whenYOutOfBoardThenRuntimeException() throws Exception {
        expectedException.expect(RuntimeException.class);
        ticTacToe.play(2, 5);
    }

    @Test
    public void whenMoveToOccupiedBoxThenRuntimeException() throws Exception {
        ticTacToe.play(2, 2);
        expectedException.expect(RuntimeException.class);
        ticTacToe.play(2, 2);
    }

    @Test
    public void givenFirstTurnWhenNextPlayerThenX() throws Exception {
        Assert.assertEquals('X', ticTacToe.nextPlayer());
    }

    @Test
    public void givenLastXWhenNextTurnThenY() throws Exception {
        ticTacToe.play(0, 1);
        Assert.assertEquals('Y', ticTacToe.nextPlayer());
    }

    @Test
    public void givenLastYWhenNextTurnThenX() throws Exception {
        ticTacToe.play(0, 1);
        ticTacToe.play(1, 0);
        Assert.assertEquals('X', ticTacToe.nextPlayer());
    }

    @Test
    public void whenPlayThanNoWinner() throws Exception {
        Assert.assertEquals(TicTacToe.BoardState.IN_PROGRESS, ticTacToe.play(0, 0));
    }

    @Test
    public void whenPlayAndHaveWholeLineThenWin() throws Exception {
        ticTacToe.play(0, 0); //X
        ticTacToe.play(0, 1); //Y
        ticTacToe.play(1, 0); //X
        ticTacToe.play(0, 2); //Y
        Assert.assertEquals(TicTacToe.BoardState.X_WIN, ticTacToe.play(2, 0));
    }

    @Test
    public void whenPlayAndHaveWholeColumnThenWin() throws Exception {
        ticTacToe.play(2, 2); //X
        ticTacToe.play(0, 1); //Y
        ticTacToe.play(1, 1); //X
        ticTacToe.play(0, 0); //Y
        ticTacToe.play(1, 0); //X
        Assert.assertEquals(TicTacToe.BoardState.Y_WIN, ticTacToe.play(0, 2));
    }

    @Test
    public void whenPlayAndDiagonalLineThenWin() throws Exception {
        ticTacToe.play(0, 0); //X
        ticTacToe.play(1, 0); //Y
        ticTacToe.play(1, 1); //X
        ticTacToe.play(0, 1); //Y
        Assert.assertEquals(TicTacToe.BoardState.X_WIN, ticTacToe.play(2, 2));
    }

    @Test
    public void whenPlayAndAllBoxesAreFilledThenDraw() throws Exception {
        ticTacToe.play(0, 0); //X
        ticTacToe.play(0, 1); //Y
        ticTacToe.play(0, 2); //X
        ticTacToe.play(1, 0); //Y
        ticTacToe.play(1, 1); //X
        ticTacToe.play(2, 2); //Y
        ticTacToe.play(2, 1); //X
        ticTacToe.play(2, 0); //Y
        Assert.assertEquals(TicTacToe.BoardState.DRAW, ticTacToe.play(1, 2));


    }
}