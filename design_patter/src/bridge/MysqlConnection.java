package bridge;

/**
 * Created by hadoop on 2015/7/17.
 */
public class MysqlConnection implements IConnection {
    @Override
    public void connect() {
        System.out.println("Mysql Connection!");
    }
}
