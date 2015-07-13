package decorator;

/**
 * Created by hadoop on 2015/7/8.
 */
public class CandleDecorator extends CakeDecorator{

    public CandleDecorator(Cake cake){
        super(cake);
    }

    @Override
    public double getPrice() {
        return cake.getPrice()+5;
    }

    @Override
    public String getRemark() {
        return cake.getRemark()+"≤Â…œ¿Ø÷Ú";
    }
}
