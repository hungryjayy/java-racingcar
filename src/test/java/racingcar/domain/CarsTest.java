package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    private final NumberStrategy overThresholdNumberStrategy = new OverThresholdNumberStrategy();
    private final NumberStrategy underThresholdNumberStrategy = new UnderThresholdNumberStrategy();

    @Test
    @DisplayName("같은 이름 리스트로 생성한 cars는 항상 같아야 한다.")
    void namesOf_ShouldEqualWithSameNames() {
        Cars actual = Cars.namesOf(List.of("a", "b", "c"));

        assertThat(actual).isEqualTo(Cars.namesOf(List.of("a", "b", "c")));
    }

    @Test
    @DisplayName("임계치를 넘는 경우, 레이스를 수행하면 모든 자동차의 position이 이동되어 있어야 한다.")
    void race_ShouldPlus1PositionValue() {
        Cars cars = Cars.namesOf(List.of("a", "b", "c"));

        cars.race(overThresholdNumberStrategy);

        assertThat(cars.getPositions()).isEqualTo(List.of(1, 1, 1));
    }

    @Test
    @DisplayName("임계치를 넘지 않는 경우, 레이스를 수행하면 모든 자동차의 position은 그대로여야 한다.")
    void race_ShouldNotPlusPositionValue() {
        Cars cars = Cars.namesOf(List.of("a", "b", "c"));

        cars.race(underThresholdNumberStrategy);

        assertThat(cars.getPositions()).isEqualTo(List.of(0, 0, 0));
    }

    @Test
    @DisplayName("a, b, c 위너 리스트를 반환해야한다.")
    void getWinners_ShouldReturnABCWinners() {
        Cars cars = Cars.namesOf(List.of("a", "b", "c"));
        cars.race(overThresholdNumberStrategy);

        List<String> actual = cars.getWinnerNames();

        assertThat(actual).isEqualTo(List.of("a", "b", "c"));
    }

    @Test
    @DisplayName("자동차리스트가 비어있는 경우 exception을 throw한다.")
    void getWinners_ShouldThrowExceptionWhenListEmpty() {
        Cars cars = Cars.namesOf(List.of());
        cars.race(overThresholdNumberStrategy);

        assertThatThrownBy(cars::getWinnerNames)
                .isInstanceOf(NoSuchElementException.class)
                .hasMessageContaining("자동차가 존재하지 않습니다.");
    }
}
