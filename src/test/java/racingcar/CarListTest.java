package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.*;

import racingcar.model.Car;
import racingcar.model.CarList;

import java.util.List;


public class CarListTest {

    @Test
    @DisplayName("모든 자동차가 4 이상 값을 입력받으면 모두 전진해야 한다.")
    void case1() {
        assertRandomNumberInRangeTest(
            () -> {
                // given
                CarList carList = new CarList(List.of("pobi", "woni", "jun"));

                // when
                carList.moveAll();

                // then
                for (Car car : carList.getCarList()) {
                    assertThat(car.getPosition()).isEqualTo(1);
                }
            },
            4, 4, 4 // pobi, woni, jun 모두 4
        );
    }

    @Test
    @DisplayName("모든 자동차가 3 이하 값을 입력받으면 모두 정지해야 한다.")
    void case2() {
        assertRandomNumberInRangeTest(
            () -> {
                // given
                List<String> carNames = List.of("pobi", "woni", "jun");
                CarList carList = new CarList(carNames);

                // when
                carList.moveAll();

                // then
                for (Car car : carList.getCarList()) {
                    assertThat(car.getPosition()).isEqualTo(0);
                }
            },
            3, 3, 3 // pobi, woni, jun 모두 3
        );
    }

    @Test
    @DisplayName("getFirstPosition(): 1등 자동차의 위치를 반환해야 한다.")
    void case3() {
        assertRandomNumberInRangeTest(
                () -> {
                    // given
                    List<String> carNames = List.of("pobi", "woni", "jun");
                    CarList carList = new CarList(carNames);

                    // when
                    carList.moveAll();  // round 1
                    carList.moveAll();  // round 2

                    int firstPos = carList.getFirstPosition();

                    // then
                    assertThat(firstPos).isEqualTo(2);
                },
                4, 4, 4,  // round 1: 모두 전진
                4, 3, 3   // round 2: pobi만 전진
        );
    }

    @Test
    @DisplayName("getWinnerNames(): 1등 자동차의 이름을 반환해야 한다.")
    void case4() {
        assertRandomNumberInRangeTest(
            () -> {
                // given
                CarList carList = new CarList(List.of("pobi", "woni", "jun"));

                // when
                carList.moveAll();  // round 1
                carList.moveAll();  // round 2

                List<String> winners = carList.getWinnerNames();

                // then
                assertThat(winners).containsExactlyInAnyOrder("pobi");
            },
            4, 4, 4,  // round 1
            4, 3, 3   // round 2
        );
    }

    @Test
    @DisplayName("getWinnerNames(): 1등 자동차의 이름을 중복을 허용하여 반환해야 한다.")
    void case5() {
        assertRandomNumberInRangeTest(
            () -> {
                // given
                CarList carList = new CarList(List.of("pobi", "woni", "jun"));

                // when
                carList.moveAll();  // round 1
                carList.moveAll();  // round 2

                List<String> winners = carList.getWinnerNames();

                // then
                assertThat(winners).containsExactlyInAnyOrder("pobi", "woni");
            },
            4, 4, 4,  // round 1
            4, 4, 3   // round 2
        );
    }
}