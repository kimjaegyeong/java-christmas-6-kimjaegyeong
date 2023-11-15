package domain;

import java.util.Arrays;

public enum Badge {
    STAR("별", 5000, 10000),
    TREE("트리", 10000, 20000),
    SANTA("산타", 20000, Integer.MAX_VALUE),
    NOT("없음", 0, 0);

    private String name;
    private int minPrice;
    private int maxPrice;

    private Badge(String name, int minPrice, int maxPrice) {
        this.name = name;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public static Badge of(final int price) {
        return Arrays.stream(values())
                .filter(badge -> price >= badge.minPrice && price < badge.maxPrice)
                .findFirst()
                .orElse(NOT);
    }

    public String getName() {
        return name;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

}
