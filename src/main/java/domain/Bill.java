package domain;

import domain.event.Event;
import domain.event.EventRepository;
import domain.event.GiveawayEvent;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Bill {
    OrderSheet orderSheet;
    EventRepository eventRepository;

    public Bill(OrderSheet orderSheet, EventRepository eventRepository) {
        this.orderSheet = orderSheet;
        this.eventRepository = eventRepository;

    }

    public Giveaway getGiveaway(){
        if(hasGiveaway()){
            return new Giveaway();
        }
        return null;
    }
    public boolean hasGiveaway(){
        return eventRepository.getEvents().stream().anyMatch(event->event.getClass() == GiveawayEvent.class);
    }
    public HashMap<Event, Integer> getEventAndBenefits() {
        HashMap<Event, Integer> eventAndBenefits = new LinkedHashMap<>();
        for (Event event : eventRepository.getEvents()) {
            eventAndBenefits.put(event, calculateBenefits(event));
        }
        return eventAndBenefits;
    }

    public int getPriceBeforeDiscount() {
        return orderSheet.getTotalPrice();
    }

    public int getPriceAfterDiscount(EventRepository eventRepository) {
        return orderSheet.getTotalPrice() - calculateTotalDiscount(eventRepository);
    }

    public int calculateTotalDiscount(EventRepository eventRepository) {
        int totalDiscount = 0;
        for (Event event : eventRepository.getEvents()) {
            totalDiscount = totalDiscount + event.getTotalDiscount();
        }
        return totalDiscount;
    }

    public int totalBenefits(EventRepository eventRepository) {
        int totalBenefits = 0;
        for (Event event : eventRepository.getEvents()) {
            totalBenefits = totalBenefits + calculateBenefits(event);
        }
        return totalBenefits;
    }

    public int calculateBenefits(Event event) {
        return event.getTotalDiscount() + event.getTotalBenefits();
    }
}
