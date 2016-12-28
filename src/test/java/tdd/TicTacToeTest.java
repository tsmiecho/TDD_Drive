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
}