package observer;

/**
 * Created by hadoop on 2015/7/10.
 */
public class Subscriber implements ISubscriber {
    private String name;
    public Subscriber(String name){
        this.name = name;
    }

    @Override
    public void newspaper_arrived() {
        System.out.println(name+" : "+" 有新的报纸，请查收！");
    }
}
