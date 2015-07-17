package flyweight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 2015/7/17.
 */
public class ConnectionPool implements IConnectionPool {
    DbBean dbbean = null;
    private int conActive = 0;
    private boolean isActive = false;

    private List<Connection> available = new ArrayList<>();
    private List<Connection> inuse = new ArrayList<>();
    private ThreadLocal<Connection> local = new ThreadLocal<>();

    public ConnectionPool(DbBean dbBean) {
        this.dbbean = dbBean;
        init();
    }

    public synchronized void init() {
        try {
            Class.forName(dbbean.getDriverName());
            for (int i = 0; i < dbbean.getInitCount(); i++) {
                Connection conn;
                conn = newConnetion();
                if (conn != null) {
                    available.add(conn);
                    conActive++;
                }
            }
            isActive = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void releaseConn(Connection conn) throws SQLException {
        if (isValid(conn)) {
            available.add(conn);
            inuse.remove(conn);
            conActive--;
            local.remove();
            notifyAll();
        }
    }

    @Override
    public void destroy() {
        for (Connection conn : available) {
            try {
                if (isValid(conn)) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (Connection conn : inuse) {
            try {
                if (isValid(conn)) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        isActive = false;
        conActive = 0;
    }

    @Override
    public synchronized void checkPool() {
        System.out.println("空闲池连接数： " + available.size());
        System.out.println("活动池连接数： " + inuse.size());
        System.out.println("总连接数： " + conActive);
    }


    @Override
    public synchronized boolean isValid(Connection conn) {
        try {
            if (conn == null || conn.isClosed()) {
                return false;
            }
        } catch (Exception e) {
        }
        return true;
    }

    @Override
    public synchronized Connection getCurrentConnection() {
        Connection conn = local.get();
        if (conn == null) {
            conn = getConnection();
        }
        return conn;
    }

    //获取新的jdbc连接
    private synchronized Connection newConnetion() {
        Connection conn = null;
        try {
            if (dbbean != null) {
                Class.forName(dbbean.getDriverName());
                conn = DriverManager.getConnection(dbbean.getUri(),
                        dbbean.getUser(), dbbean.getPassword());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }


    //从可用连接池中取得jdbc连接，如果可用连接池中没有连接，则新建
    @Override
    public synchronized Connection getConnection() {
        Connection conn = null;
        try {
            if (conActive < this.dbbean.getMaxConnections()) {
                if (available.size() > 0) {
                    conn = available.get(0);
                    if (conn != null) {
                        local.set(conn);
                    }
                    available.remove(0);
                    inuse.add(conn);
                } else {
                    conn = newConnetion();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    @Override
    public synchronized boolean isActive() {
        return isActive;
    }
}
