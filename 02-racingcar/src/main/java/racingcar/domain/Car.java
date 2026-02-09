package racingcar.domain;

public class Car {

    private static final int MOVING_THRESHOLD = 4;

    private final String name;
    private int position;

    public Car(String name) {
        if (name == null || name.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = name;
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
