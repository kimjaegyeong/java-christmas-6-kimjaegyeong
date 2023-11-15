package domain;

import domain.event.EventRepository;

public class Customer {

    OrderSheet orderSheet;
    Badge badge;
    public Customer(OrderSheet orderSheet){
     this.orderSheet = orderSheet;
    }

    public void getBadge(EventRepository eventRepository){
        Bill bill= new Bill(orderSheet, eventRepository);
        badge = Badge.of(bill.totalBenefits(eventRepository));
    }
}
