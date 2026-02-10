package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

class CarsTest {

    @Test
    void 모든_자동차가_전진() {
        List<String> inputNames = List.of("pobi", "woni");
        Cars cars = new Cars(inputNames);

        cars.moveAll(() -> 9);

        List<Car> carList = cars.getCars();

        assertThat(carList.get(0).getPosition()).isEqualTo(1);
        assertThat(carList.get(1).getPosition()).isEqualTo(1);
    }
}