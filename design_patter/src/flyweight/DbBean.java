package flyweight;

/**
 * Created by hadoop on 2015/7/17.
 */
public class DbBean {
    private String driverName;
    private String uri;
    private String user;
    private String password;
    private int initCount = 20;
    private int maxConnections = 100;
    private int minConnections = 1;

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    private String poolName;


    public DbBean(String driverName, String uri, String user, String password) {
        this.driverName = driverName;
        this.uri = uri;
        this.user = user;
        this.password = password;
    }

    public DbBean(){}

    public int getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public int getMinConnections() {
        return minConnections;
    }

    public void setMinConnections(int minConnections) {
        this.minConnections = minConnections;
    }

    public int getInitCount() {
        return initCount;
    }

    public void setInitCount(int initCount) {
        this.initCount = initCount;
    }


    public String getDriverName() {
        return driverName;
    }

    public String getUri() {
        return uri;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
