package flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 2015/7/17.
 */
public class DbInfo {
    public static List<DbBean> beans = null;
    static {
        beans = new ArrayList<>();
        DbBean gbase = new DbBean();
        gbase.setDriverName("com.gbase.jdbc.Driver");
        gbase.setUri("jdbc:gbase://192.168.91.156:5258/hzbbfx");
        gbase.setUser("root");
        gbase.setPassword("123456");
        gbase.setPoolName("gbase");
        beans.add(gbase);
    }
}
