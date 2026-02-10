package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        List<String> carNames = inputView.readCarNames();
        Cars cars = new Cars(carNames);

        int tryCount = inputView.readTryCount();

        outputView.printGameStart();
        for (int i = 0; i < tryCount; i++) {
            cars.moveAll(numberGenerator);
            outputView.printRoundResult(cars.getCars());
        }

        outputView.printWinners(cars.findWinnerNames());
    }
}