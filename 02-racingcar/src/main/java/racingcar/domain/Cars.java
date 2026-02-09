package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = List.copyOf(cars);
    }

    private void validate(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException();
        }
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
        int maxPosition = 0;

        for(Car car : cars) {
            if(car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if(car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
