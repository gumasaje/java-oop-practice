package baseball;

import java.util.List;

public class Referee {

    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";

    private Referee() {
    }

    public static int judge(List<Integer> computer, List<Integer> user) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).equals(computer.get(i))) {
                strike++;
            } else if (computer.contains(user.get(i))) {
                ball++;
            }
        }

        printResult(ball, strike);
        return strike;
    }

    private static void printResult(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println(NOTHING_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder();
        if (ball > 0) {
            sb.append(ball).append(BALL_MESSAGE);
        }
        if (ball > 0 && strike > 0) {
            sb.append(" ");
        }
        if (strike > 0) {
            sb.append(strike).append(STRIKE_MESSAGE);
        }
        System.out.println(sb.toString());
    }
}
