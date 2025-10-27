package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("여러_라운드_테스트")
    void 여러_라운드_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    assertThat(output()).contains(
                            "실행 결과",
                            "pobi : ---",
                            "woni : --",
                            "jun : -",
                            "최종 우승자 : pobi"
                    );
                },
                // round 1: 모두 전진
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                // round 2: pobi, woni 전진
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                // round 3: pobi만 전진
                MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    @DisplayName("공동_우승자_테스트")
    void 공동_우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "2");
                    assertThat(output()).contains(
                            "최종 우승자 : pobi, woni"
                    );
                },
                // round 1: 모두 전진
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                // round 2: pobi, woni만 전진
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("전원_우승자_테스트")
    void 전원_우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "1");
                    assertThat(output()).contains(
                            "최종 우승자 : pobi, woni, jun"
                    );
                },
                STOP, STOP, STOP
        );
    }

    @Test
    @DisplayName("예외_테스트_중복_이름")
    void 예외_테스트_중복_이름() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외_테스트_시도_횟수")
    void 예외_테스트_시도_횟수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
