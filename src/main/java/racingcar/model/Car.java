package racingcar.model;
import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int THRESHOLD_VAL = 4;
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int randomValue = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
        if (randomValue >= THRESHOLD_VAL) {
            position++;
        }
    }

    public void moveTest(int value) {
        if  (value >= THRESHOLD_VAL) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
