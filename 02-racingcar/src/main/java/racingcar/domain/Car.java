package racingcar.domain;

public class Car {

    private static final int MOVING_THRESHOLD = 4;
    private static final int MAX_NAME_LENGTH = 5;

    private static final String ERROR_NAME_LENGTH = "[ERROR] 자동차 이름은 5자 이하만 가능합니다.";
    private static final String ERROR_NAME_EMPTY = "[ERROR] 자동차 이름은 비어있을 수 없습니다";

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name.trim();
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_NAME_EMPTY);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH);
        }
    }

    public void move(int number) {
        if (number >= MOVING_THRESHOLD) {
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
