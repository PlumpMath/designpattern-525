package decorator;

/**
 * Created by hadoop on 2015/7/8.
 */
public class FruitCake extends Cake {

    public FruitCake(){
        super.remark="ˮ������";
    }

    @Override
    public double getPrice() {
        return super.base_price +20.0;
    }
}
