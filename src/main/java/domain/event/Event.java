package domain.event;

import java.util.List;

public interface Event {
    public int getTotalDiscount();

    public int getTotalBenefits();

    public List<Event> getEvents();
}
