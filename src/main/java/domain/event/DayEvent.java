package domain.event;

import domain.Category;
import domain.OrderSheet;
import domain.date.DayOfWeek;
import domain.date.WeekType;
import domain.discount.Discount;
import domain.discount.WeekDiscount;
import java.util.List;

public class DayEvent implements Event {
    private Discount discount;
    private int count;

    private final static Category category = Category.DESSERT;
    private DayEvent(OrderSheet orderSheet) {
        discount = new WeekDiscount(orderSheet.countMenu(category));
    }

    public static DayEvent create(OrderSheet orderSheet) {
        if (containsEvent(orderSheet)) {
            return new DayEvent(orderSheet);
        }
        return null;
    }

    public static boolean containsEvent(OrderSheet orderSheet){
        return WeekType.of(DayOfWeek.of(orderSheet.getDay())) == WeekType.WEEKDAY;
    }

    @Override
    public int getTotalDiscount() {
        return discount.getDiscountPrice();
    }

    @Override
    public int getTotalBenefits() {
        return 0;
    }

    @Override
    public List<Event> getEvents() {
        return null;
    }

}
