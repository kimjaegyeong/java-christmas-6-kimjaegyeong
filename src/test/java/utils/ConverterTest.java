package utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConverterTest {
    @DisplayName("구분문자 - 을 이용해 문자열 분리하는 테스트")
    @Test
    public void splitByDelimiterTest() {
        String input = "해물파스타-3";
        String inputs[] = Converter.splitByDelimiter(input, "-");
        assertThat(inputs[0]).isEqualTo("해물파스타");
       assertThat(inputs[1]).isEqualTo("3");
    }
}
