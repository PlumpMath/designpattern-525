package singleton;

//�̰߳�ȫ������ʽ����
public class SingletonV2 {
    private static SingletonV2 instance = null;

    private SingletonV2() {
    }

    public static SingletonV2 getInstance() {
        if (instance == null) {
            synchronized (instance) {
                instance = new SingletonV2();
            }
        }
        return instance;
    }
}
