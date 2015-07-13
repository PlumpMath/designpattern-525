package decorator;

/**
 * Created by hadoop on 2015/7/8.
 */
public class FlowDecorator extends CakeDecorator {

    public FlowDecorator(Cake cake){
        super(cake);
    }

    @Override
    public double getPrice() {
        return cake.getPrice()+5.0;
    }

    @Override
    public String getRemark() {
        return cake.getRemark()+"º”“ª∂‰œ ª®";
    }
}
