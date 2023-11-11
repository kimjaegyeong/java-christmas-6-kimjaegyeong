package domain.date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DayOfWeekTest {

    @DisplayName("DayOfWeek 객체 생성 테스트")
    @Test()
    public void createDayOfWeek(){
        int day = 31;
        DayOfWeek dayOfWeek = DayOfWeek.of(day);
        assertThat(dayOfWeek.getWeek()).isEqualTo("일요일");
    }
}
