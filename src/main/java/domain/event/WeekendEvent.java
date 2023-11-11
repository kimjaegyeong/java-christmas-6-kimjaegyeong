package domain.event;

import java.util.List;

public class WeekendEvent implements Event{
    @Override
    public int getTotalDiscount() {
        return 0;
    }

    @Override
    public int getTotalBenefits() {
        return 0;
    }

    @Override
    public List<Event> getEvents() {
        return null;
    }
}
