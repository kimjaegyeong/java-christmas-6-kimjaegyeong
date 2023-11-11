package domain.date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class DayTest {

    @DisplayName("Day 객체 생성 테스트")
    @Test
    public void createDay(){
        Day day = new Day(3);
        assertThat(day.getDay()).isEqualTo(3);
    }
}
