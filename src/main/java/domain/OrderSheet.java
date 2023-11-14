package domain;

import domain.date.Day;
import java.util.HashMap;
import java.util.Map;

public class OrderSheet {
    private OrderMenu orderMenu;
    private final Day day;

    public OrderSheet(Day day, OrderMenu orderMenu) {
        this.orderMenu = orderMenu;
        this.day = day;
    }

    public HashMap<Menu, Integer> getOrderMenu() {
        return orderMenu.getOrderMenu();
    }

    public int getDay() {
        return day.getDay();
    }

    public int countMenuIn(Category category) {
        HashMap<Menu, Integer> menus = orderMenu.getOrderMenu();
        int sum = 0;
        return menus.entrySet()
                .stream()
                .filter(entry -> containsIn(category, entry.getKey()))
                .mapToInt(Map.Entry::getValue)
                .sum();
    }


    public boolean containsIn(Category category, Menu menu) {
        if (Category.of(menu).equals(category)) {
            return true;
        }
        return false;
    }

    public int getTotalPrice() {
        return orderMenu.calculateTotalPrice();
    }

}
