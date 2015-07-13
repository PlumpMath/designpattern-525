package decorator;

public abstract class CakeDecorator extends Cake{
    Cake cake;

    public CakeDecorator(Cake cake){
        this.cake = cake;
    }

    public abstract double getPrice();

    public abstract String getRemark();
}
