package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.*;

import racingcar.model.Car;

public class CarTest {
    @Test
    @DisplayName("숫자 입력이 4보다 작을 경우 이동하지 않아야 한다.")
    public void smaller_then_4() {
        assertRandomNumberInRangeTest(
            () -> {
                Car car = new Car("pobi");
                car.move();
                assertThat(car.getPosition()).isEqualTo(0);
            },
            3  // round 1: pobi(3)
        );
    }

    @Test
    @DisplayName("숫자 입력이 4보다 클 경우 1만큼 이동해야 한다.")
    public void larger_then_4() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("pobi");
                    car.move();
                    car.move();
                    assertThat(car.getPosition()).isEqualTo(2);
                },
                5,  // round 1: pobi(5),
                5   // round 2: pobi(5)
        );
    }
}
