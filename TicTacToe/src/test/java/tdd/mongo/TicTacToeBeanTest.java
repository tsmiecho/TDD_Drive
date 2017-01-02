package tdd.mongo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Tomasz Smiechowicz
 */
public class TicTacToeBeanTest {

    private final int turn = 4;
    private final int x = 1;
    private final int y = 1;
    private final char player = 'X';
    private TicTacToeBean ticTacToeBean;

    @Before
    public void setUp() throws Exception {
        ticTacToeBean = new TicTacToeBean(turn, player, x, y);
    }

    @Test
    public void whenInitializationThenTurnIsSet() throws Exception {
        Assert.assertEquals(turn, ticTacToeBean.getTurn());
    }

    @Test
    public void whenInitializationThenPlayerIsSet() throws Exception {
        Assert.assertEquals(player, ticTacToeBean.getPlayer());
    }

    @Test
    public void whenInitializationThenXIsSet() throws Exception {
        Assert.assertEquals(x, ticTacToeBean.getX());
    }

    @Test
    public void whenInitializationThenYIsSet() throws Exception {
        Assert.assertEquals(y, ticTacToeBean.getY());
    }
}