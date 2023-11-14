package domain.event;

import domain.Giveaway;
import domain.Menu;
import domain.OrderSheet;

public class GiveawayEvent implements Event {
    private final static int LIMIT_PRICE = 120000;
    private final static Giveaway giveaway = new Giveaway();

    private GiveawayEvent(OrderSheet orderSheet) {
    }

    public static GiveawayEvent create(OrderSheet orderSheet) {
        if (containsEvent(orderSheet.getTotalPrice())) {
            return new GiveawayEvent(orderSheet);
        }
        return null;
    }

    public static boolean containsEvent(int totalOrderPrice) {
        return totalOrderPrice >= LIMIT_PRICE;
    }

    @Override
    public int getTotalDiscount() {
        return 0;
    }

    @Override
    public int getTotalBenefits() {
        return giveaway.getPrice();
    }

}
