package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 조건이_4이상이면_전진() {
        Car car = new Car("pobi");
        car.move(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }
}