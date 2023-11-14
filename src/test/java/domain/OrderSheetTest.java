package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import domain.Category;
import domain.OrderMenu;
import domain.OrderSheet;
import domain.date.Day;
import dto.OrderDTO;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderSheetTest {
    int day = 3;

    @DisplayName("메인 카테고리의 메뉴의 개수를 세는 테스트")
    @Test
    public void getMainCategoryByOrderSheetTest() {
        OrderSheet orderSheet  = createOrderSheet();
        int count = orderSheet.countMenuIn(Category.MAIN);
        assertThat(count).isEqualTo(3);
    }

    @DisplayName("디저트 카테고리의 메뉴 개수를 세는 테스트")
    @Test
    public void getDessertCategoryByOrderSheetTest() {
        OrderSheet orderSheet  = createOrderSheet();
        int count = orderSheet.countMenuIn(Category.DESSERT);
        assertThat(count).isEqualTo(4);
    }

    @DisplayName("모든 메뉴의 비용을 계산하는 테스트")
    @Test
    public void calculateAllMenuTest(){
        OrderSheet orderSheet  = createOrderSheet();
        int count = orderSheet.getTotalPrice();
        assertThat(count).isEqualTo(165000);
    }

    public OrderSheet createOrderSheet(){
        List<OrderDTO> dto = List.of(new OrderDTO("해산물파스타", 2)
                ,new OrderDTO("티본스테이크",1)
                ,new OrderDTO("아이스크림",2), new OrderDTO("초코케이크",2));
        return new OrderSheet(new Day(day), new OrderMenu(dto));
        }

}
