package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 2015/7/10.
 */
public class PeopleNewsPaper implements INewsPaper {
    private List<ISubscriber> subscriberList = new ArrayList<ISubscriber>();
    @Override
    public void registerSubscriber(ISubscriber subscriber) {
        subscriberList.add(subscriber);
    }

    @Override
    public void removeSubscriber(ISubscriber subscriber) {
        int index =  subscriberList.indexOf(subscriber);
        if(index>=0){
            subscriberList.remove(index);
        }

    }

    @Override
    public void send() {
        for (ISubscriber people:subscriberList){
          people.newspaper_arrived();
        }

    }
}
