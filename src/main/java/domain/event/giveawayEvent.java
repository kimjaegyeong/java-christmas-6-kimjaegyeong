package domain.event;

import java.util.List;

public class giveawayEvent implements Event{
    @Override
    public int getTotalDiscount() {
        return 0;
    }

    @Override
    public int getTotalBenefits() {
        return 0;
    }

}
