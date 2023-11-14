package domain.date;

import messages.ErrorMessages;

public class Day {
    private final static int START = 1;
    private final static int END = 31;
    private int day;

    public Day(int day) {
        validationDay(day);
        this.day = day;

    }

    public int getDay() {
        return day;
    }

    public void validationDay(int day) {
        if (day > END) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_DAY_ERROR);
        }
        if (day < START) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_DAY_ERROR);
        }
    }
}
