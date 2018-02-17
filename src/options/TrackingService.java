package options;

import java.util.Date;
import java.util.LinkedList;

public class TrackingService {

    private LinkedList<Transaction> events = new LinkedList<>();

    public void registerEvent(Transaction transaction) {
        if(transaction.getType() != null){
            events.add(transaction);
        }
    }

    public LinkedList<Transaction> getEvents() {
        return events;
    }
}
