package domain;

public class Giveaway {
    private final static String GIVEAWAY = "샴페인";
    private final int COUNT  = 1;
    private final Menu menu ;



    public Giveaway() {
        this.menu = Menu.of(GIVEAWAY);
    }

    public String getMenu() {
        return menu.getName();
    }

    public int getPrice() {
        return menu.getPrice();
    }

    public int getCount(){
        return COUNT;
    }
}
