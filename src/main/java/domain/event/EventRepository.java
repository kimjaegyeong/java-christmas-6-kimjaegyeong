package domain.event;

import domain.OrderSheet;
import java.util.ArrayList;
import java.util.List;

public class EventRepository {
    private List<Event> events;

    public EventRepository(OrderSheet orderSheet) {
        events = new ArrayList<>();
        EventVendor eventVendor = new EventVendor(orderSheet);
        events = eventVendor.getEvents();
    }


    public List<Event> getEvents() {
        return events;
    }
}
