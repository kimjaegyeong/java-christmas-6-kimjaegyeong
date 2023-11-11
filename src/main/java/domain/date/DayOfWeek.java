package domain.date;

import java.util.Arrays;

public enum DayOfWeek {
    MONDAY("월요일", 4),
    TUESDAY("화요일", 5),
    WEDNESDAY("수요일", 6),
    THURSDAY("목요일", 7),
    FRIDAY("금요일", 1),
    SATURDAY("토요일", 2),
    SUNDAY("일요일", 3),
    NOT("INVALID", 0);
    private final int dayCount;
    private final String week;

    DayOfWeek(String week, int dayCount) {
        this.dayCount = dayCount;
        this.week = week;
    }


    public static DayOfWeek of(final int dayCount) {
        return Arrays.stream(DayOfWeek.values())
                .filter(dayOfWeek -> (dayOfWeek.dayCount) % dayCount == 0)
                .findFirst()
                .orElse(DayOfWeek.NOT);
    }
}
