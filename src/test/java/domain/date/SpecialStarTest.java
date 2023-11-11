package domain.date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpecialStarTest {
    @DisplayName("SpacialStar 객체 생성 테스트")
    @Test
    public void createSpacialStar(){
        SpecialStar specialStar = new SpecialStar(7);
        assertThat(specialStar.getHasStar()).isTrue();
    }
}
