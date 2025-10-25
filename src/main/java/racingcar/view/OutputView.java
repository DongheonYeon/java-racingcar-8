package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    public void printOutputHeader() {
        System.out.println("실행 결과");
    }

    public void printRoundResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " +
                    "-".repeat(Math.max(0, car.getPosition())));
        }
        System.out.println();
        
    }

    private String getCarPosition(int position) {
        return "-".repeat(Math.max(0, position));
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));

    }

}
