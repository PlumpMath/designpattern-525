package observer;

/**
 * Created by hadoop on 2015/7/10.
 */
public class Main {
    public static void main(String[] args){
        PeopleNewsPaper peopleNewsPaper = new PeopleNewsPaper();
        ISubscriber guchao = new Subscriber("¹Ë³¬");
        ISubscriber wanghao = new Subscriber("ÍõºÆ");
        ISubscriber minghao = new Subscriber("Ã÷ºÀ");

        peopleNewsPaper.registerSubscriber(guchao);
        peopleNewsPaper.registerSubscriber(wanghao);
        peopleNewsPaper.registerSubscriber(minghao);

        peopleNewsPaper.send();
        System.out.println();
        peopleNewsPaper.removeSubscriber(guchao);

        peopleNewsPaper.send();
    }
}
