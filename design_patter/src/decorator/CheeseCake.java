package decorator;

public class CheeseCake extends Cake {
    @Override
    public double getPrice() {
        return super.base_price + 10.0;
    }

    public CheeseCake() {
        super.remark = "ÆğË¾µ°¸â";
    }
}
