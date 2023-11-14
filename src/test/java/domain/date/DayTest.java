package domain.date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import messages.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class DayTest {

    @DisplayName("Day 객체 생성 테스트")
    @Test
    public void createDay(){
        Day day = new Day(3);
        assertThat(day.getDay()).isEqualTo(3);
    }
    @DisplayName("잘못된 방문 날짜 입력 테스트")
    @Test
    public void invalidVisitDay(){
        assertThatThrownBy(()->new Day(32)).isInstanceOf(IllegalArgumentException.class);
    }
}
