package racingcar.model;

import racingcar.view.OutputView;

import java.util.List;

public class RunGame {
    private final CarList carList;

    public RunGame(CarList carList) {
        this.carList = carList;
    }

    public void race(int attemptsNum, OutputView outputView) {
        for (int i = 0; i < attemptsNum; i++) {
            carList.moveAll();
            outputView.printRoundResult(carList.getCarList());
        }
    }

    public List<String> getWinners() {
        return carList.getWinnerNames();
    }
}
