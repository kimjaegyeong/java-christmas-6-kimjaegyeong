package domain.event;

import domain.Menu;

public class GiveawayEvent implements Event {
    private final static int LIMIT_PRICE = 120000;
    private final static String GIVEAWAY = "샴페인";
    private final static Menu GIVEAWAY_MENU = Menu.of(GIVEAWAY);

    private GiveawayEvent() {
    }

    public GiveawayEvent create(int totalOrderPrice) {
        if (containsEvent(totalOrderPrice)) {
            return new GiveawayEvent();
        }
        return null;
    }

    public boolean containsEvent(int totalOrderPrice) {
        return totalOrderPrice >= LIMIT_PRICE;
    }

    @Override
    public int getTotalDiscount() {
        return 0;
    }

    @Override
    public int getTotalBenefits() {
        return GIVEAWAY_MENU.getPrice();
    }

}
