package domain.event;

import domain.OrderSheet;
import domain.discount.ChristmasDiscount;
import domain.discount.Discount;

public class ChristmasEvent implements Event {
    private static final int START_DATE = 1;
    private static final int END_DATE = 25;
    private Discount discount;

    private ChristmasEvent(OrderSheet orderSheet) {

        discount = new ChristmasDiscount(orderSheet.getDay());
    }

    public static ChristmasEvent create(OrderSheet orderSheet){
        if(containsEvent(orderSheet.getDay())){
            return new ChristmasEvent(orderSheet);
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
