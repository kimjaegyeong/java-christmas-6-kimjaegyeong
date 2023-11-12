package domain.event;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChristmasEventTest {
    @DisplayName("크리스마스 이벤트 객체 생성 성공 테스트")
    @Test
    public void createChristmasEvent(){
        int date= 25;
        ChristmasEvent event = ChristmasEvent.create(date);
        assertThat(event.getClass()).isEqualTo(ChristmasEvent.class);
    }
    @DisplayName("크리스마스 이벤트 객체 생성 실패 테스트")
    @Test
    public void failCreateChristmasEvent(){
        int date=26;
        ChristmasEvent event = ChristmasEvent.create(date);
        assertThat(event).isEqualTo(null);
    }
}
