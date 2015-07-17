package flyweight;

import java.sql.Connection;

/**
 * Flyweight ��Ԫģʽ:
 * ����Ϊ������һ���������������ӵ����ͬ���ݶ���Ŀ�����
 * ���ֿ��������ֱ�۵ľ����ڴ����ġ�
 * ��Ԫģʽ�Թ���ķ�ʽ��Ч��֧�ִ�����ϸ���ȶ���
 * ��Ԫģʽ����������Ĺ��Թ������ֱ������ĸ��ԡ�
 * Ϊ��������㣬��Ԫģʽ������������״̬������״̬������״̬���ǹ��ԣ�����״̬���Ǹ����ˡ�
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
