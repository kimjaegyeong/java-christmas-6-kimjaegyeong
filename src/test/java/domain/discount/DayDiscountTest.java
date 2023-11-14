package domain.discount;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DayDiscountTest {
    @Test
    @DisplayName("평일,주말 할인 테스트")
    public void discountByDayDiscount(){
        WeekDiscount weekDiscount = new WeekDiscount(3);
        assertThat(weekDiscount.getDiscountPrice()).isEqualTo(6069);
    }
}
