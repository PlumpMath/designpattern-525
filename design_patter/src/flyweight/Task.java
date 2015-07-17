package flyweight;

import java.sql.Connection;

/**
 * Flyweight 享元模式:
 * 定义为：采用一个共享来避免大量拥有相同内容对象的开销。
 * 这种开销中最常见直观的就是内存的损耗。
 * 享元模式以共享的方式高效的支持大量的细粒度对象。
 * 享元模式尽量将事物的共性共享，而又保留它的个性。
 * 为了做到这点，享元模式中区分了内蕴状态和外蕴状态。内蕴状态就是共性，外蕴状态就是个性了。
 *
 *
 */
public class Task implements Runnable{
    private IConnectionPool pool =ConnectionPoolManager.getInstance().getPool("gbase");
    @Override
    public void run(){
        try{
            while(true){
                Connection connection = getConnection();
                System.out.println(Thread.currentThread().toString() + connection);
                pool.checkPool();
                Thread.sleep(10000);
                pool.releaseConn(connection);

            }
        }catch (Exception e){}

    }

    public Connection getConnection(){
        Connection conn = null;
        if (pool!=null && pool.isActive()){
            conn = pool.getConnection();
        }
        return conn;
    }

}
