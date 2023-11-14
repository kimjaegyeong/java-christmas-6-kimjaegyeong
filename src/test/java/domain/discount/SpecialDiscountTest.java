package domain.discount;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpecialDiscountTest {

    @DisplayName("특별 할인 테스트")
    @Test
    public void discountBySpecialDiscount(){
        SpecialDiscount specialDiscount = new SpecialDiscount(3);
        assertThat(specialDiscount.getDiscountPrice()).isEqualTo(1000);
    }


}
