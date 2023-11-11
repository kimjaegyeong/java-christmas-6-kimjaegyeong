package domain.date;

import java.util.Arrays;
import java.util.List;

public class SpecialStar {
    private final List<Integer> spacialDay = Arrays.asList(3, 10, 17, 24, 25, 31);
    private final boolean hasStar;

    public SpecialStar(int day) {
        if (isSpacialDay(day)) {
            hasStar = true;
            return;
        }
        hasStar = false;
    }

    public boolean getHasStar(){
        return  hasStar;
    }
    public boolean isSpacialDay(int day) {
        return spacialDay.contains(day);
    }
}
