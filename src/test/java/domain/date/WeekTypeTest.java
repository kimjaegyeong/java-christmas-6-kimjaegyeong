package domain.date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WeekTypeTest {
    @DisplayName("WeekTypeTest 객체 생성 테스트")
    @Test
    public void createWeekType(){
        DayOfWeek dayOfWeek = DayOfWeek.SUNDAY;
        WeekType weekType = WeekType.of(dayOfWeek);
        assertThat(weekType.getType()).isEqualTo("WEEKDAY");
    }
}
