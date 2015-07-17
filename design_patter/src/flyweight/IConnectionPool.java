package flyweight;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by hadoop on 2015/7/17.
 */
public interface IConnectionPool {
    Connection getConnection();
    boolean isActive();
    Connection getCurrentConnection();
    boolean isValid(Connection conn);
    void releaseConn(Connection conn) throws SQLException;
    void destroy();
    void checkPool();
}
