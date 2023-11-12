package domain.discount;

public class SpecialDiscount implements Discount {
    private final static int DISCOUNT = 1000;
    private int discount;
    public SpecialDiscount(int day) {
        discount = calculateDiscount(day);
    }

    @Override
    public int getDiscountPrice() {
        return discount;
    }

    @Override
    public int calculateDiscount(int day) {
        return DISCOUNT;
    }

}
