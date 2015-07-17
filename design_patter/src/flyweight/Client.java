package flyweight;

/**
 * Created by hadoop on 2015/7/17.
 */
public class Client {
    public static void main(String[] args){
        Task task1 = new Task();
        Thread thread = new Thread(task1,"线程1");
        Thread thread2 = new Thread(task1,"线程2");
        Thread thread3 = new Thread(task1,"线程3");
        thread.start();
        thread2.start();
        thread3.start();
    }
}
