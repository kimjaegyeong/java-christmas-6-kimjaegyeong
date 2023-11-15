package domain;

import domain.event.EventRepository;

public class Customer {

    OrderSheet orderSheet;
    Badge badge;
    public Customer(OrderSheet orderSheet, EventRepository eventRepository){
     this.orderSheet = orderSheet;
     createBadge(eventRepository);
    }

    public void createBadge(EventRepository eventRepository){
        Bill bill= new Bill(orderSheet, eventRepository);
        badge = Badge.of(bill.totalBenefits(eventRepository));
    }

    public String getBadge(){
        return badge.getName();
    }
}
