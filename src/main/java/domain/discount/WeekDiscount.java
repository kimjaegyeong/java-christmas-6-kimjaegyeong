package domain.discount;

public class WeekDiscount implements Discount {
    private final static int DISCOUNT = 2023;
    private int discount ;
    public WeekDiscount(int count) {
        discount = calculateDiscount(count);
    }

    @Override
    public int getDiscountPrice() {
        return discount;
    }

    @Override
    public int calculateDiscount(int count) {
        return DISCOUNT * count;
    }
}
