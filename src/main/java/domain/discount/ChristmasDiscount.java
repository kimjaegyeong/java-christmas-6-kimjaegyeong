package domain.discount;

public class ChristmasDiscount implements Discount {
    private final static int START_DISCOUNT_PRICE = 1000;
    private final static int SUM_PRICE_PER_ONE_DAY = 100;
    private final static int START_DAY = 1;

    private int discountPrice;

    public ChristmasDiscount(int day) {
        this.discountPrice = day ;
    }

    @Override
    public int getDiscountPrice() {
        return discountPrice;
    }

    @Override
    public int calculateDiscount(int day) {
        return ((day -START_DAY) * SUM_PRICE_PER_ONE_DAY) + START_DISCOUNT_PRICE;
    }
}
