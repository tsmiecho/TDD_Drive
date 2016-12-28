package tdd;

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
}