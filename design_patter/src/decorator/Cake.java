package decorator;

public abstract class Cake {
    String remark;
    double base_price = 30.0;

    public abstract double getPrice();

    public  String getRemark(){
        return remark;
    }
    @Override
    public String toString(){
        return this.getRemark()+" º€∏Ò « "+this.getPrice();
    }
}
