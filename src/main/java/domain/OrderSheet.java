package domain;

import domain.date.Day;
import java.util.List;

public class OrderSheet {
    private final List<Menu> menus;
    private final Day day;

    // menu와 category를 한꺼번에 관리하는 클래스 1개 생성 , 그 클래스와 갯수를 hashmap 으로 관리
    public OrderSheet(List<Menu> menus, Day day) {
        this.menus = menus;
        this.day = day;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public int getDay() {
        return day.getDay();
    }

    public int countMenu(Category category) {
        return (int) menus.stream().filter(menu -> contains(category, menu)).count();
    }

    public boolean contains(Category category, Menu menu) {
        if (Category.of(menu).equals(category)) {
            return true;
        }
        return false;
    }
}
