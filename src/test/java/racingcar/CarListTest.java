package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

import racingcar.model.Car;
import racingcar.model.CarList;

import java.util.List;


public class CarListTest {

    @Test
    @DisplayName("모든 자동차가 4 이상 값을 입력받으면 모두 전진해야 한다.")
    void case1() {
        // given
        List<String> carNames = List.of("pobi", "woni", "jun");
        CarList carList = new CarList(carNames);

        // when
        carList.getCarList().get(0).moveTest(4);
        carList.getCarList().get(1).moveTest(4);
        carList.getCarList().get(2).moveTest(4);

        // then
        for (Car car : carList.getCarList()) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("모든 자동차가 3 이하 값을 입력받으면 모두 정지해야 한다.")
    void case2() {
        // given
        List<String> carNames = List.of("pobi", "woni", "jun");
        CarList carList = new CarList(carNames);

        // when
        carList.getCarList().get(0).moveTest(3);
        carList.getCarList().get(1).moveTest(3);
        carList.getCarList().get(2).moveTest(3);

        // then
        for (Car car : carList.getCarList()) {
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("getFirstPosition(): 1등 자동차의 위치를 반환해야 한다.")
    void case3() {
        // given
        List<String> carNames = List.of("pobi", "woni", "jun");
        CarList carList = new CarList(carNames);

        // round 1 - 모두 한 칸 전진
        carList.getCarList().get(0).moveTest(4);
        carList.getCarList().get(1).moveTest(4);
        carList.getCarList().get(2).moveTest(4);

        // round 2 - pobi만 한 칸 전진
        carList.getCarList().get(0).moveTest(4);
        carList.getCarList().get(1).moveTest(3);
        carList.getCarList().get(2).moveTest(3);

        // when
        int firstPos = carList.getFirstPosition();

        // then
        assertThat(firstPos).isEqualTo(2);
    }

    @Test
    @DisplayName("getWinnerNames(): 1등 자동차의 이름을 반환해야 한다.")
    void case4() {
        // given
        List<String> carNames = List.of("pobi", "woni", "jun");
        CarList carList = new CarList(carNames);

        // round 1 - 모두 한 칸 전진
        carList.getCarList().get(0).moveTest(4);
        carList.getCarList().get(1).moveTest(4);
        carList.getCarList().get(2).moveTest(4);

        // round 2 - pobi만 한 칸 전진
        carList.getCarList().get(0).moveTest(4);
        carList.getCarList().get(1).moveTest(3);
        carList.getCarList().get(2).moveTest(3);

        // when
        List<String> winners = carList.getWinnerNames();

        // then
        assertThat(winners).containsExactlyInAnyOrder("pobi");
    }

    @Test
    @DisplayName("getWinnerNames(): 1등 자동차의 이름을 중복을 허용하여 반환해야 한다.")
    void case5() {
        // given
        List<String> carNames = List.of("pobi", "woni", "jun");
        CarList carList = new CarList(carNames);

        // round 1 - 모두 한 칸 전진
        carList.getCarList().get(0).moveTest(4);
        carList.getCarList().get(1).moveTest(4);
        carList.getCarList().get(2).moveTest(4);

        // round 2 - pobi, woni 한 칸 전진
        carList.getCarList().get(0).moveTest(4);
        carList.getCarList().get(1).moveTest(4);
        carList.getCarList().get(2).moveTest(3);

        // when
        List<String> winners = carList.getWinnerNames();

        // then
        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni");
    }
}