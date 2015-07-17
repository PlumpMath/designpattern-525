package bridge;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        IConnection mysql = new MysqlConnection();
        dataSource.setConnection(mysql);
        dataSource.connect();

        IConnection oracle = new OracleConnection();
        dataSource.setConnection(oracle);
        dataSource.connect();
    }

}
