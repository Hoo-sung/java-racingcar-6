package racingcar.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    @Nested
    class SingleWinnerTests {
        @Test
        void 단독우승자인경우() {
            List<Car> cars = new ArrayList<>();
            cars.add(new Car("pobi", 4));
            cars.add(new Car("woni", 3));
            cars.add(new Car("jun", 2));

            List<String> answer = Referee.determineWinner(cars);
            List<String> expected = List.of("pobi");
            assertThat(answer).isEqualTo(expected);
        }
    }

    @Nested
    class MultipleWinnersTests {
        @Test
        void 공동우승자인경우() {
            List<Car> cars = new ArrayList<>();
            cars.add(new Car("pobi", 4));
            cars.add(new Car("woni", 4));
            cars.add(new Car("jun", 4));

            List<String> answer = Referee.determineWinner(cars);
            List<String> expected = List.of("pobi", "woni", "jun");
            assertThat(answer).isEqualTo(expected);
        }
    }

}