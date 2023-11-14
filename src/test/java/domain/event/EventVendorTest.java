package domain.event;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import domain.OrderMenu;
import domain.OrderSheet;
import domain.date.Day;
import dto.OrderDTO;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EventVendorTest {

    @DisplayName("이벤트 여러개 생성 테스트")
    @Test
    public void createEvent(){
        OrderSheet orderSheet= createOrderSheetMock(25);
        EventVendor eventVendor = new EventVendor(orderSheet);
        assertThat(eventVendor.getEvents().size()).isEqualTo(3);
        assertThat(eventVendor.getEvents().contains(ChristmasEvent.class));
        assertThat(eventVendor.getEvents().contains(SpecialEvent.class));
        assertThat(eventVendor.getEvents().contains(DayEvent.class));
    }

    @DisplayName("주문금액 미달로 적용 이벤트 생성 실패 테스트")
    @Test
    public void notEvent(){
        List<OrderDTO> dto= List.of(new OrderDTO("시저샐러드",1));
        OrderSheet orderSheet = new OrderSheet(new Day(3), new OrderMenu(dto));
        EventVendor eventVendor = new EventVendor(orderSheet);
        assertThat(eventVendor.getEvents().size()).isEqualTo(0);
    }
    
    public OrderSheet createOrderSheetMock(int day){
        List<OrderDTO> dto= List.of(new OrderDTO("해산물파스타",2));
        OrderSheet orderSheet =new OrderSheet(new Day(day), new OrderMenu(dto));
        return orderSheet;
    }
}
