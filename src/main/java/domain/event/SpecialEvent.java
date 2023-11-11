package domain.event;

import java.util.Arrays;
import java.util.List;

public class SpecialEvent implements Event {

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
