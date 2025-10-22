package racingcar.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    public void validateAttemptsNum(int tryCount) {
        if (tryCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    public void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            validateNotEmpty(name);
            validateNameLength(name);
        }
        validateDuplicateNames(carNames);
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    private void validateNotEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 빈 값입니다.");
        }
    }

    private void validateDuplicateNames(List<String> carNames) {
        Set<String> nameSet = new HashSet<>(carNames);
        if (nameSet.size() != carNames.size()) {
            throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
        }
    }
}
