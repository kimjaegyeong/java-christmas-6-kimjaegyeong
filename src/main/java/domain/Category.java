package domain;

import java.util.Arrays;
import java.util.List;

public enum Category {

    APPETIZER("애피타이저", Arrays.asList(Menu.BUTTON_MUSHROOM_SOUP, Menu.TAPAS, Menu.CAESAR_SALAD)),
    MAIN("메인", Arrays.asList(Menu.TBONE_STEAK, Menu.BBQ_RIBS, Menu.SEAFOOD_PASTA, Menu.CHRISTMAS_PASTA)),
    DESSERT("디저트", Arrays.asList(Menu.CHOCOLATE_CAKE, Menu.ICE_CREAM)),
    DRINK("음료", Arrays.asList(Menu.ZERO_COLA, Menu.RED_WINE, Menu.CHAMPAGNE)),
    NOT("NOT",Arrays.asList(Menu.NOT));

    private final String name;
    private final List<Menu> menus;
    private Category(String name, List<Menu> menus) {
        this.name = name;
        this.menus = menus;
    }
    public static Category of(Menu menu) {
        return Arrays.stream(values())
                .filter(category -> category.menus.contains(menu))
                .findFirst().orElse(NOT);
    }

}
