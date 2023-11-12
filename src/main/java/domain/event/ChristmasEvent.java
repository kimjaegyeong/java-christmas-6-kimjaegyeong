package domain.event;

import domain.discount.SpecialDiscount;
import domain.discount.Discount;
import java.util.List;

public class ChristmasEvent implements Event {
    private static final int START_DATE = 1;
    private static final int END_DATE = 25;
    private Discount discount;

    private ChristmasEvent(int day) {
        discount = new SpecialDiscount(day);
    }

    public static ChristmasEvent create(int day){
        if(containsEvent(day)){
            return new ChristmasEvent(day);
        }
        return null;
    }

    public static boolean containsEvent(int day){
        return day >= START_DATE && day<=END_DATE;
    }
    @Override
    public int getTotalDiscount() {
        return discount.getDiscountPrice();
    }

    @Override
    public int getTotalBenefits() {
        return 0;
    }

}
