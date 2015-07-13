package observer;

/**
 * Created by hadoop on 2015/7/10.
 */
public class Main {
    public static void main(String[] args){
        PeopleNewsPaper peopleNewsPaper = new PeopleNewsPaper();
        ISubscriber guchao = new Subscriber("�˳�");
        ISubscriber wanghao = new Subscriber("����");
        ISubscriber minghao = new Subscriber("����");

        peopleNewsPaper.registerSubscriber(guchao);
        peopleNewsPaper.registerSubscriber(wanghao);
        peopleNewsPaper.registerSubscriber(minghao);

        peopleNewsPaper.send();
        System.out.println();
        peopleNewsPaper.removeSubscriber(guchao);

        peopleNewsPaper.send();
    }
}
