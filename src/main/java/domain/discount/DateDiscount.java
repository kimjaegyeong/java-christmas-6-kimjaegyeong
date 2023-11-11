package domain.discount;

import domain.date.Day;
import domain.OrderSheet;

public class DateDiscount implements Discount {

    @Override
    public int getDiscountPrice(OrderSheet order, Day day) {
        return 0;
    }

    @Override
    public void calculateDiscount(OrderSheet order, Day day) {

    }
}
