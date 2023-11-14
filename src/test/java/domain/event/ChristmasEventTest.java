package domain.event;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import domain.OrderMenu;
import domain.OrderSheet;
import domain.date.Day;
import dto.OrderDTO;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChristmasEventTest {
    @DisplayName("크리스마스 이벤트 객체 생성 성공 테스트")
    @Test
    public void createChristmasEvent() {
        OrderSheet orderSheet= createOrderSheetMock(25);
        ChristmasEvent event = ChristmasEvent.create(orderSheet);
        assertThat(event.getClass()).isEqualTo(ChristmasEvent.class);
    }

    @DisplayName("크리스마스 이벤트 객체 생성 실패 테스트")
    @Test
    public void failCreateChristmasEvent() {
       OrderSheet orderSheet= createOrderSheetMock(26);
        ChristmasEvent event = ChristmasEvent.create(orderSheet);
        assertThat(event).isEqualTo(null);
    }

    public OrderSheet createOrderSheetMock(int day){
        List<OrderDTO> dto= List.of(new OrderDTO("해산물파스타",3));
        OrderSheet orderSheet =new OrderSheet(new Day(day), new OrderMenu(dto));

        return orderSheet;
    }
}
