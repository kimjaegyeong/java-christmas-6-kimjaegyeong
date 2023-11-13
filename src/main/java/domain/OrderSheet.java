package domain;

import domain.date.Day;
import java.util.HashMap;
import java.util.Map;

public class OrderSheet {
    private OrderMenu orderMenu;
    private final Day day;

    // menu와 category를 한꺼번에 관리하는 클래스 1개 생성 , 그 클래스와 갯수를 hashmap 으로 관리
    public OrderSheet(Day day, OrderMenu orderMenu) {
        this.orderMenu = orderMenu;
        this.day = day;
    }

    public int getDay() {
        return day.getDay();
    }

    public int countMenu(Category category) {
        HashMap<Menu, Integer> menus = orderMenu.getOrderMenu();
        int sum = 0;
        return menus.entrySet()
                .stream()
                .filter(entry -> contains(category, entry.getKey()))
                .mapToInt(Map.Entry::getValue)
                .sum();
    }


    public boolean contains(Category category, Menu menu) {
        if (Category.of(menu).equals(category)) {
            return true;
        }
        return false;
    }

    public int getTotalPrice() {
        HashMap<Menu, Integer> menus = orderMenu.getOrderMenu();
        int totalPrice = 0;

        for (Map.Entry<Menu, Integer> entry : menus.entrySet()) {
            Menu menu = entry.getKey();
            Integer value = entry.getValue();
            totalPrice = totalPrice + menu.getPrice() * value;
        }
        return totalPrice;
    }
}
