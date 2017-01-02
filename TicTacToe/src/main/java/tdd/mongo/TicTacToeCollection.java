package tdd.mongo;


import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import java.net.UnknownHostException;

/**
 * @author Tomasz Smiechowicz
 */
public class TicTacToeCollection {

    private static final String dbName = "tic-tac-toe";

    private static final String collectionName = "game";

    private MongoCollection mongoCollection;

    public TicTacToeCollection() throws UnknownHostException {
        DB db = new MongoClient().getDB(dbName);
        mongoCollection = new Jongo(db).getCollection(collectionName);
    }

    public boolean saveMove(TicTacToeBean bean) {
        try {
            getMongoCollection().save(bean);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean drop() {
        try {
            getMongoCollection().drop();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected MongoCollection getMongoCollection() {
        return mongoCollection;
    }

}
