package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MIN_NUMER = 0;
    private static final int MAX_NUMER = 9;

    @Override
    public int generateNumber() {
        return Randoms.pickNumberInRange(MIN_NUMER, MAX_NUMER);
    }
}
