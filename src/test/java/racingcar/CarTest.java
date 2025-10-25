package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import racingcar.model.Car;

public class CarTest {
    @Test
    public void smaller_then_4() {
        Car car = new Car("pobi");
        car.moveTest(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void larger_then_4() {
        Car car = new Car("pobi");
        car.moveTest(5);
        car.moveTest(5);
        assertThat(car.getPosition()).isEqualTo(2);
    }
}
