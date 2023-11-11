package domain.discount;

import domain.date.Day;
import domain.OrderSheet;
public interface Discount {
    public int getDiscountPrice(OrderSheet order, Day day);
    public void calculateDiscount(OrderSheet order, Day day);

}
