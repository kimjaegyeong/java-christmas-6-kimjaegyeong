package domain.event;

import domain.OrderSheet;
import domain.date.SpecialStar;
import domain.discount.Discount;
import domain.discount.SpecialDiscount;

public class SpecialEvent implements Event {
    private final static int DISCOUNT = 1000;
    private Discount discount;
    private static SpecialStar specialStar;
    private SpecialEvent(int day){
        discount = new SpecialDiscount(day);
    }

    public static SpecialEvent create(OrderSheet orderSheet){
        if(containsEvent(orderSheet.getDay())){
            return new SpecialEvent(orderSheet.getDay());
        }
        return null;
    }

    private static boolean containsEvent(int day) {
        return new SpecialStar(day).getHasStar();
    }

    @Override
    public int getTotalDiscount() {
        return DISCOUNT;
    }

    @Override
    public int getTotalBenefits() {
        return 0;
    }

}
