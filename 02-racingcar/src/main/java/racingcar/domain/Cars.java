package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final String ERROR_CARS_EMPTY = "[ERROR] 자동차가 한 대도 없습니다.";
    private final List<Car> cars;

    public Cars(List<String> names) {
        validate(names);
        this.cars = mapToCars(names);
    }

    private void validate(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException(ERROR_CARS_EMPTY);
        }
    }

    private static List<Car> mapToCars(List<String> names) {
        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(name));
        }
        return carList;
    }

    public void moveAll(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.generateNumber());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> findWinnerNames() {
        int maxPosition = getMaxPosition();

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int getMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        return max;
    }
}
