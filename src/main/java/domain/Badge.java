package domain;

import java.util.Arrays;

public enum Badge {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000),
    NOT("NOT", 0);

    private final String name;
    private final int price;

    private Badge(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static Badge of(final int price) {
        return Arrays.stream(Badge.values())
                .filter(badge -> price >= badge.price)
                .findFirst()
                .orElse(NOT);

    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}
