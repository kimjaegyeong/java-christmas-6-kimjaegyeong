package domain.discount;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChristmasDiscountTest {

    @DisplayName("크리스마스 할인 테스트")
    @Test
    public void discountByChristmasDiscount() {
        int day = 25;
        ChristmasDiscount christmasDiscount = new ChristmasDiscount(day);
        assertThat(christmasDiscount.getDiscountPrice()).isEqualTo(3400);
    }
}
