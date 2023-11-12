package domain.event;

import domain.Category;
import domain.OrderSheet;
import domain.date.DayOfWeek;
import domain.date.WeekType;
import domain.discount.Discount;
import domain.discount.WeekDiscount;
import java.util.List;

public class WeekendEvent implements Event {
    private Discount discount;
    private int count;
    private final static Category category = Category.MAIN;
    public WeekendEvent(OrderSheet orderSheet) {
        discount = new WeekDiscount(orderSheet.countMenu(category));
    }
    public static WeekendEvent create(OrderSheet orderSheet) {
        if (containsEvent(orderSheet)) {
            return new WeekendEvent(orderSheet);
        }
        return null;
    }

    public static boolean containsEvent(OrderSheet orderSheet){
        return WeekType.of(DayOfWeek.of(orderSheet.getDay())) == WeekType.WEEKEND;
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
