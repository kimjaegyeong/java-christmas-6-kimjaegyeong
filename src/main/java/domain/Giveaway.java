package domain;

public class Giveaway {
    Menu menu;

    public Giveaway(Menu menu) {
        this.menu = menu;
    }

    public String getMenu() {
        return menu.getName();
    }

    public int getPrice() {
        return menu.getPrice();
    }
}
