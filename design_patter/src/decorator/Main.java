package decorator;

/**
 *
 *��1�� װ�ζ������ʵ��������ͬ�Ľӿڡ������ͻ��˶�������Ժ���ʵ������ͬ�ķ�ʽ��װ�ζ��󽻻���
 *��2�� װ�ζ������һ����ʵ��������ã�reference��
 *��3�� װ�ζ�������������Կͻ��˵�����������Щ����ת������ʵ�Ķ���
 *��4�� װ�ζ��������ת����Щ������ǰ���Ժ�����һЩ���ӹ��ܡ�
 *     ������ȷ����������ʱ�������޸ĸ�������Ľṹ�Ϳ������ⲿ���Ӹ��ӵĹ��ܡ�
 *     ��������������У�ͨ����ͨ���̳���ʵ�ֶԸ�����Ĺ�����չ��
 * ȱ�㣺
 * 1. ���ֱȼ̳и��������������ԣ�Ҳͬʱ��ζ�Ÿ��Ӷ�ĸ����ԡ�
 * 2. װ��ģʽ�ᵼ������г������С�࣬�������ʹ�ã���ʹ�����úܸ��ӡ�
 */
public class Main {
    public static void main(String[] args) throws  Exception{
        Cake cake = new NutDecorator(new FlowDecorator(new CheeseCake()));
        Cake fruitCake = new CandleDecorator(new FlowDecorator(new FruitCake()));
        System.out.println(cake);
        System.out.println(fruitCake);
    }
}
