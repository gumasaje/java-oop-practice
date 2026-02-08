package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {

    private static final String RESTART_COMMAND = "1";
    private static final String EXIT_COMMAND = "2";

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_OVER_MESSAGE = Computer.NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 " + RESTART_COMMAND + ", 종료하려면 " + EXIT_COMMAND + "를 입력하세요.";

    public static void main(String[] args) {
        System.out.println(GAME_START_MESSAGE);

        boolean isGameRunning = true;
        while (isGameRunning) {
            List<Integer> computer = Computer.generateNumbers();
            playRound(computer);
            isGameRunning = askReplay();
        }
    }

    private static void playRound(List<Integer> computer) {
        while (true) {
            System.out.print(INPUT_MESSAGE);
            String input = Console.readLine();

            InputValidator.validate(input);
            List<Integer> user = Converter.toList(input);

            int strike = Referee.judge(computer, user);

            if (strike == Computer.NUMBER_LENGTH) {
                System.out.println(GAME_OVER_MESSAGE);
                break;
            }
        }
    }

    private static boolean askReplay() {
        System.out.println(GAME_RESTART_MESSAGE);
        String command = Console.readLine();

        if (command.equals(RESTART_COMMAND)) {
            return true;
        }
        if (command.equals(EXIT_COMMAND)) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}