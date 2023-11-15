package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import domain.date.Day;
import domain.event.Event;
import domain.event.EventRepository;
import dto.OrderDTO;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BillTest {
    int day =26;
    OrderSheet orderSheet = createOrderSheet(day);
    EventRepository eventRepository = createEventRepository(orderSheet);
    Bill bill =createBill();
    @DisplayName("증정 메뉴 생성 테스트")
    @Test
    public void setBill(){
        assertThat(bill.getGiveaway().getMenu()).isEqualTo("샴페인");
    }

    @DisplayName("적용된 이벤트와 혜택 확인 테스트")
    @Test
    public void EventsAndDiscount(){
        HashMap<Event,Integer> events = bill.getEventAndBenefits();
        int[] expect = {4046,25000};
        int i=0;
        for(int price: events.values()){
            assertThat(price).isEqualTo(expect[i]);
            i++;
        }

    }

    @DisplayName("할인 전 가격을 확인하는 테스트")
    @Test
    public void BeforeDiscount(){
        assertThat(bill.getPriceBeforeDiscount()).isEqualTo(300000);
    }

    @DisplayName("할인 후 가격을 확인하는 테스트")
    @Test
    public void AfterDiscount(){
        assertThat(bill.getPriceAfterDiscount(eventRepository)
        ).isEqualTo(295954);
    }

    @DisplayName("총 할인율을 확인하는 테스트")
    @Test
    public void totalDiscount(){
        assertThat(bill.calculateTotalDiscount(eventRepository)).isEqualTo(4046);
    }

    @DisplayName("총 혜택률을 확인하는 테스트")
    @Test
    public void totalBenefits(){
        assertThat(bill.totalBenefits(eventRepository)).isEqualTo(29046);
    }

    public Bill createBill() {
        Bill bill = new Bill(orderSheet, eventRepository);
        return bill;
    }


    public OrderSheet createOrderSheet(int day) {
        List<OrderDTO> dto = List.of(new OrderDTO("해산물파스타", 6),
                new OrderDTO("초코케이크",2)
                ,new OrderDTO("레드와인",1));
        OrderSheet orderSheet = new OrderSheet(new Day(day), new OrderMenu(dto));
        return orderSheet;
    }

    public EventRepository createEventRepository(OrderSheet orderSheet) {
        return new EventRepository(orderSheet);
    }
}
