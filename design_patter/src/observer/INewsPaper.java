package observer;

public interface INewsPaper {
    void registerSubscriber(ISubscriber ISubscriber);
    void removeSubscriber(ISubscriber ISubscriber);
    void send();
}
