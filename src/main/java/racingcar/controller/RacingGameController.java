package racingcar.controller;

import racingcar.model.CarList;
import racingcar.model.RunGame;
import racingcar.utils.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator validator;

    public RacingGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.validator = new InputValidator();
    }

    public void runGame() {
        // 자동차 이름 입력
        List<String> carNames = inputView.readCarNames();
        validator.validateCarNames(carNames);

        // 시도 횟수 입력
        int attemptsNum = inputView.readAttemptsNum();
        validator.validateAttemptsNum(attemptsNum);

        // 게임 생성 및 실행
        CarList carList = new CarList(carNames);
        RunGame game = new RunGame(carList);
        game.race(attemptsNum, outputView);

        // 결과 출력
        outputView.printWinners(game.getWinners());
    }
}
