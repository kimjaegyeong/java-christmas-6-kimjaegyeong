package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import dto.OrderDTO;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderMenuTest {

    @DisplayName("OrderMenu 생성 성공 테스트")
    @Test
    public void createOrderMenu(){
        List<OrderDTO> dtos = List.of(new OrderDTO("해산물파스타",2), new OrderDTO("레드와인",1));
        assertThat( new OrderMenu(dtos).getClass()).isEqualTo(OrderMenu.class);

    }

    @DisplayName("음료만 주문하여 OrderMenu 생성 실패 테스트")
    @Test
    public void failCreateByOnlyDrink(){
        List<OrderDTO> dtos = List.of(new OrderDTO("레드와인",2)
                ,new OrderDTO("제로콜라",1));
        assertThatThrownBy(()->new OrderMenu(dtos)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 개수를 초과하여 OrderMenu 생성 실패 테스트")
    @Test
    public void failCreateByOverCount(){
        List<OrderDTO> dtos = List.of(new OrderDTO("레드와인",18)
                ,new OrderDTO("해산물파스타",3));
        assertThatThrownBy(()->new OrderMenu(dtos)).isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("없는 메뉴를 주문하여 OrderMenu 생성 실패 테스트")
    @Test
    public void failCreateByNotExsitMenu(){
        List<OrderDTO> dtos = List.of(new OrderDTO("레드와인",3)
                ,new OrderDTO("생크림케이크",3));
        assertThatThrownBy(()->new OrderMenu(dtos)).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("중복 메뉴를 주문하여 OrderMenu 생성 실패 테스트")
    @Test
    public void failCreateByDuplicationMenu(){
        List<OrderDTO> dtos = List.of(new OrderDTO("해산물파스타",3)
                ,new OrderDTO("초코케이크",3),new OrderDTO("초코케이크",3));
        assertThatThrownBy(()->new OrderMenu(dtos)).isInstanceOf(IllegalArgumentException.class);
    }
}
