package domain.event;

import domain.OrderSheet;
import java.util.ArrayList;
import java.util.List;

public class EventVendor {
    public final static int MIN_TOTAL_PRICE = 10000;
    List<Event> events;
    public EventVendor(OrderSheet orderSheet){
        events = new ArrayList<>();
        if(checkTotalPrice(orderSheet)){
            putAll(orderSheet);
        }


    }
    public List<Event> getEvents(){
        return events;
    }

    private void putAll(OrderSheet orderSheet){
        put(ChristmasEvent.create(orderSheet));
        put(DayEvent.create(orderSheet));
        put(WeekendEvent.create(orderSheet));
        put(SpecialEvent.create(orderSheet));
        put(GiveawayEvent.create(orderSheet));
    }
    private void put(Event event){
        if(event==null){
            return;
        }
        events.add(event);
    }

    public boolean checkTotalPrice(OrderSheet orderSheet){
        if(orderSheet.getTotalPrice()<MIN_TOTAL_PRICE){
            return false;
        }
        return true;
    }
}
