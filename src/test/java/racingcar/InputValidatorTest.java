package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.InputValidator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

class InputValidatorTest {

    private final InputValidator validator = new InputValidator();

    @Test
    @DisplayName("정상 이름일 경우 예외 발생하지 않는다.")
    void case1() {
        // given
        List<String> carNames = Arrays.asList("pobii", "woni", "jun");

        // when & then
        assertThatCode(() -> validator.validateCarNames(carNames))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("이름이 빈 문자열일 경우 예외 발생")
    void case2() {
        // given
        List<String> carNames = Arrays.asList("pobi", "", "jun");

        // when & then
        assertThatThrownBy(() -> validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 빈 값입니다.");
    }

    @Test
    @DisplayName("이름이 5자를 초과하는 경우 예외 발생")
    void case3() {
        // given
        List<String> carNames = Arrays.asList("pobi", "javaji", "jun");

        // when & then
        assertThatThrownBy(() -> validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    @DisplayName("이름이 중복되었을 경우 예외 발생")
    void case4() {
        // given
        List<String> carNames = Arrays.asList("pobi", "woni", "pobi");

        // when & then
        assertThatThrownBy(() -> validator.validateCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 중복되었습니다.");
    }

    @Test
    @DisplayName("시도 횟수가 1 이상이면 예외가 발생하지 않는다.")
    void case5() {
        // when & then
        assertThatCode(() -> validator.validateAttemptsNum(1))
                .doesNotThrowAnyException();
        assertThatCode(() -> validator.validateAttemptsNum(5))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("시도 횟수가 1 미만이면 예외가 발생한다")
    void invalidTryCount_zero() {
        assertThatThrownBy(() -> validator.validateAttemptsNum(0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validator.validateAttemptsNum(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}