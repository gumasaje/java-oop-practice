package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {


    private static final int NUMBER_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private static final String RESTART_COMMAND = "1";
    private static final String EXIT_COMMAND = "2";

    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_OVER_MESSAGE = NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 " + RESTART_COMMAND + ", 종료하려면 " + EXIT_COMMAND + "를 입력하세요.";

    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";

    public static void main(String[] args) throws IllegalArgumentException {

        System.out.println(GAME_START_MESSAGE);

        boolean isGameRunning = true;
        while (isGameRunning) {

            List<Integer> computer = generateComputerNumbers();

            while (true) {

                System.out.print(INPUT_MESSAGE);
                String input = Console.readLine();
                validateInput(input);

                List<Integer> user = parseUserNumbers(input);

                int strike = calculateScore(computer, user);

                if (strike == NUMBER_LENGTH) {
                    System.out.println(GAME_OVER_MESSAGE);
                    System.out.println(GAME_RESTART_MESSAGE);

                    String command = Console.readLine();
                    if (command.equals(RESTART_COMMAND)) {
                        break;
                    } else if (command.equals(EXIT_COMMAND)) {
                        isGameRunning = false;
                        break;
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
            }
        }
    }

    private static void validateInput(String input) {

        if (input.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);

            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }

            if (c == '0') {
                throw new IllegalArgumentException();
            }

        }

        if (input.charAt(0) == input.charAt(1) ||
                input.charAt(1) == input.charAt(2) ||
                input.charAt(0) == input.charAt(2)) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> generateComputerNumbers() {

        List<Integer> computer = new ArrayList<>();

        while (computer.size() < NUMBER_LENGTH) {

            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    private static List<Integer> parseUserNumbers(String input) {

        List<Integer> user = new ArrayList<>();

        for (String s : input.split("")) {
            user.add(Integer.parseInt(s));
        }

        return user;
    }

    private static int calculateScore(List<Integer> computer, List<Integer> user) {

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < user.size(); i++) {

            if (user.get(i).equals(computer.get(i))) {
                strike++;
            } else if (computer.contains(user.get(i))) {
                ball++;
            }
        }

        if (ball != 0 && strike != 0) {
            System.out.println(ball + BALL_MESSAGE + " " + strike + STRIKE_MESSAGE);
        } else if (ball != 0) {
            System.out.println(ball + BALL_MESSAGE);
        } else if (strike != 0) {
            System.out.println(strike + STRIKE_MESSAGE);
        } else {
            System.out.println(NOTHING_MESSAGE);
        }

        return strike;
    }
}
