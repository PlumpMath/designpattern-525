package bridge;

/**
 * Created by hadoop on 2015/7/17.
 */
public class DataSource {
    private IConnection source;

    public void connect(){
        source.connect();
    }

    public IConnection getConnection(){
        return source;
    }

    public  void setConnection(IConnection source){
        this.source = source;
    }
}
