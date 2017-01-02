package tdd.mongo;

import com.mongodb.MongoException;
import org.jongo.MongoCollection;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.net.UnknownHostException;
import static org.junit.Assert.*;

/**
 * @author Tomasz Smiechowicz
 */
public class TicTacToeCollectionTest {

    private TicTacToeCollection collection;
    private MongoCollection mongoCollection;
    private static final String dbName = "tic-tac-toe";
    private static final String collectionName = "game";
    private TicTacToeBean bean;

    @Before
    public void before() throws UnknownHostException {
        collection = Mockito.spy(new TicTacToeCollection());
        mongoCollection = Mockito.mock(MongoCollection.class);
        bean = new TicTacToeBean(3, 'X', 2, 1);
    }


    @Test
    public void whenInstantiatedThenMongoCollectionHasDbNameTicTacToe() {
        assertEquals(dbName, collection.getMongoCollection().getDBCollection().getDB().getName());
    }

    @Test
    public void whenInstantiatedThenMongoCollectionHasNameGame() {
        assertEquals(collectionName, collection.getMongoCollection().getName());
    }

    @Test
    public void whenSaveMoveThenInvokeMongoCollectionSave() {
        Mockito.doReturn(mongoCollection).when(collection).getMongoCollection();
        collection.saveMove(bean);
        Mockito.verify(mongoCollection).save(bean);
    }

    @Test
    public void whenSaveMoveThenReturnTrue() {
        Mockito.doReturn(mongoCollection).when(collection).getMongoCollection();
        assertTrue(collection.saveMove(bean));
    }

    @Test
    public void givenExceptionWhenSaveMoveThenReturnFalse() {
        Mockito.doThrow(new MongoException("Bla")).when(mongoCollection).save(Mockito.any(TicTacToeBean.class));
        Mockito.doReturn(mongoCollection).when(collection).getMongoCollection();
        assertFalse(collection.saveMove(bean));
    }

    @Test
    public void whenDropThenInvokeMongoCollectionDrop() {
        Mockito.doReturn(mongoCollection).when(collection).getMongoCollection();
        collection.drop();
        Mockito.verify(mongoCollection).drop();
    }

    @Test
    public void whenDropThenReturnTrue() {
        Mockito.doReturn(mongoCollection).when(collection).getMongoCollection();
        assertTrue(collection.drop());
    }

    @Test
    public void givenExceptionWhenDropThenReturnFalse() {
        Mockito.doThrow(new MongoException("Bla")).when(mongoCollection).drop();
        Mockito.doReturn(mongoCollection).when(collection).getMongoCollection();
        assertFalse(collection.drop());
    }
}
