package domain.date;

import java.util.Arrays;
import java.util.List;

public enum WeekType {
    WEEKDAY("WEEKDAY",Arrays.asList(DayOfWeek.SUNDAY, DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY,
            DayOfWeek.THURSDAY)),
    WEEKEND("WEEKEND",Arrays.asList(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY)),
    NOT("NOT",Arrays.asList(DayOfWeek.NOT));

    private final String type;
    private final List<DayOfWeek> days ;
    private WeekType(String type, List<DayOfWeek> days) {
        this.type = type;
        this.days = days;
    }

    public String getType(){
        return type;
    }

    public static WeekType contains(DayOfWeek type){
        if(WEEKDAY.days.contains(type)){
            return WEEKDAY;
        }
        if(WEEKEND.days.contains(type)){
            return WEEKEND;
        }
    return NOT;
    }
    public static WeekType of(final DayOfWeek day){
        return Arrays.stream(WeekType.values())
                .map(weekType -> contains(day))
                .findFirst().orElse(NOT);


    }


}
