package flyweight;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class ConnectionPoolManager {
    public Map<String, IConnectionPool> pools =
            new HashMap<>();

    private ConnectionPoolManager(){
        init();
    }

    public static ConnectionPoolManager getInstance(){
        return new ConnectionPoolManager();
    }
    private void init(){
        for(int i=0;i<DbInfo.beans.size();i++){
            DbBean bean = DbInfo.beans.get(i);
            ConnectionPool pool = new ConnectionPool(bean);
            if(pool!=null){
                pools.put(bean.getPoolName(),pool);
            }
        }

    }

    public Connection getConnetcion(String poolName){
        Connection conn = null;
        try{
                IConnectionPool pool = getPool(poolName);
                conn = pool.getConnection();
            } catch (Exception e){}
        return  conn;
    }

    public void destory(String poolName){
        IConnectionPool pool = getPool(poolName);
        if(pool!=null){
            pool.destroy();
        }
    }

    public IConnectionPool getPool(String poolName){
        IConnectionPool pool = null;
        if(pools.size()>0 && pools.containsKey(poolName)){
            pool  = pools.get(poolName);
        }
        return pool;
    }
}
