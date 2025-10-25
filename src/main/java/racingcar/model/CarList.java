package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private final List<Car> carList;

    public CarList(List<String> carNames) {
        this.carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name));
        }
    }

    public void moveAll() {
        for (Car car : carList) {
            car.move();
        }
    }

    public int getFirstPosition() {
        int first = 0;
        for (Car car : carList) {
            if (car.getPosition() > first) {
                first = car.getPosition();
            }
        }
        return first;
    }

    public List<String> getWinnerNames() {
        int maxPosition = getFirstPosition();
        List<String> winners = new ArrayList<>();

        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}