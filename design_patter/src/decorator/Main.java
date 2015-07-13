package decorator;

/**
 * Created by hadoop on 2015/7/8.
 */
public class Main {
    public static void main(String[] args) {
        Cake cake = new NutDecorator(new FlowDecorator(new CheeseCake()));
        Cake fruitCake = new CandleDecorator(new FlowDecorator(new FruitCake()));
        System.out.println(cake);
        System.out.println(fruitCake);
    }
}
