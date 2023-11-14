package domain.event;

import domain.OrderSheet;
import java.util.ArrayList;
import java.util.List;

public class EventVendor {
    List<Event> events;
    public EventVendor(OrderSheet orderSheet){
        events = new ArrayList<>();
        put(ChristmasEvent.create(orderSheet.getDay()));
        put(DayEvent.create(orderSheet));
        put(WeekendEvent.create(orderSheet));
        put(SpecialEvent.create(orderSheet.getDay()));
        put(GiveawayEvent.create(orderSheet.getTotalPrice()));
    }
    public List<Event> getEvents(){
        return events;
    }

    private void put(Event event){
        if(event==null){
            return;
        }
        events.add(event);
    }
}
