package domain;

import domain.event.Event;
import domain.event.EventRepository;

public class Bill {
    OrderSheet orderSheet;
    EventRepository eventRepository;

    public Bill(OrderSheet orderSheet, EventRepository eventRepository) {
        this.orderSheet = orderSheet;
        this.eventRepository = eventRepository;

    }
    public int getPriceBeforeDiscount(){
        return orderSheet.getTotalPrice() ;
    }

    public int getPriceAfterDiscount(EventRepository eventRepository){
        return orderSheet.getTotalPrice() -  calculateTotalDiscount(eventRepository);
    }
    public int calculateTotalDiscount(EventRepository eventRepository){
        int totalDiscount = 0;
        for (Event event : eventRepository.getEvents()) {
            totalDiscount = event.getTotalDiscount() ;
        }
        return totalDiscount;
    }
    public int calculateTotalBenefits(EventRepository eventRepository) {
        int totalBenefits = 0;
        for (Event event : eventRepository.getEvents()) {
            totalBenefits = event.getTotalDiscount() + event.getTotalBenefits();
        }
        return totalBenefits;
    }
}
