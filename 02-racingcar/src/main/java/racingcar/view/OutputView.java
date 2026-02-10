package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String POSITION_MARKER = "-";
    private static final String NAME_SEPARATOR = " : ";
    private static final String WINNER_SEPARATOR = ", ";

    public void printGameStart() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + NAME_SEPARATOR + POSITION_MARKER.repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println(WINNER_MESSAGE + String.join(WINNER_SEPARATOR, winners));
    }
}
