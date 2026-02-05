package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {

        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean isGameRunning = true;
        while (isGameRunning) {

            List<Integer> computer = generateComputerNumbers();

            while (true) {

                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();
                validateInput(input);

                List<Integer> user = parseUserNumbers(input);

                int strike = calculateScore(computer, user);

                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                    String command = Console.readLine();
                    if (command.equals("1")) {
                        break;
                    } else if (command.equals("2")) {
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

        if (input.length() != 3) {
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

        while (computer.size() < 3) {

            int randomNumber = Randoms.pickNumberInRange(1, 9);

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
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (ball != 0) {
            System.out.println(ball + "볼");
        } else if (strike != 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println("낫싱");
        }

        return strike;
    }
}
