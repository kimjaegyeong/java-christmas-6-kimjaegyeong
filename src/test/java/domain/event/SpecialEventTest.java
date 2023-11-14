package domain.event;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import domain.OrderMenu;
import domain.OrderSheet;
import domain.date.Day;
import dto.OrderDTO;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpecialEventTest {
    @DisplayName("특별 이벤트 객체 생성 성공 테스트")
    @Test
    public void createWeekendEvent() {
        OrderSheet orderSheet= createOrderSheetMock(25);
        SpecialEvent event = SpecialEvent.create(orderSheet);
        assertThat(event.getClass()).isEqualTo(SpecialEvent.class);
    }

    @DisplayName("특별 이벤트 객체 생성 실패 테스트")
    @Test
    public void failCreateSpecialEvent() {
        OrderSheet orderSheet= createOrderSheetMock(28);
        SpecialEvent event = SpecialEvent.create(orderSheet);
        assertThat(event).isEqualTo(null);
    }

    public OrderSheet createOrderSheetMock(int day){
        List<OrderDTO> dto= List.of(new OrderDTO("해산물파스타",3)
                , new OrderDTO("초코케이크",2)
                , new OrderDTO("아이스크림",1));
        OrderSheet orderSheet =new OrderSheet(new Day(day), new OrderMenu(dto));

        return orderSheet;
    }
}
