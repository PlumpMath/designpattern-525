package bridge;

/**
 *
 */
public class MysqlConnection implements IConnection {
    @Override
    public void connect() {
        System.out.println("Mysql Connection!");
    }
}
