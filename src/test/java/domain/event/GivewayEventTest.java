package domain.event;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import domain.OrderMenu;
import domain.OrderSheet;
import domain.date.Day;
import dto.OrderDTO;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GivewayEventTest {
    @DisplayName("증정 이벤트 객체 생성 성공 테스트")
    @Test
    public void createGiveawayEvent() {
        List<OrderDTO> dto= List.of(new OrderDTO("티본스테이크",2)
                , new OrderDTO("아이스크림",2));
        OrderSheet orderSheet= createOrderSheetMock(29, dto);
        GiveawayEvent event = GiveawayEvent.create(orderSheet);
        assertThat(event.getClass()).isEqualTo(GiveawayEvent.class);
    }

    @DisplayName("증정 이벤트 객체 생성 실패 테스트")
    @Test
    public void failCreateGiveawayEvent() {
        List<OrderDTO> dto= List.of(new OrderDTO("티본스테이크",2)
                , new OrderDTO("아이스크림",1));
        OrderSheet orderSheet= createOrderSheetMock(29, dto);
        GiveawayEvent event = GiveawayEvent.create(orderSheet);
        assertThat(event).isEqualTo(null);
    }

    public OrderSheet createOrderSheetMock(int day, List<OrderDTO> dto){
        OrderSheet orderSheet =new OrderSheet(new Day(day), new OrderMenu(dto));

        return orderSheet;
    }
}
