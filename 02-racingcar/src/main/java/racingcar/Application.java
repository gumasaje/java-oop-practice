package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.Outputview;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Outputview outputView = new Outputview();

        List<String> carNames = inputView.readCarNames();

        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name));
        }
        Cars cars = new Cars(carList);

        int tryCount = inputView.readTryCount();

        outputView.printGameStart();

        for (int i = 0; i < tryCount; i++) {
            cars.moveAll(() -> Randoms.pickNumberInRange(0, 9));
            outputView.printRoundResult(cars.getCars());
        }

        List<String> winners = cars.findWinnerNames();

        outputView.printWinners(winners);
    }
}