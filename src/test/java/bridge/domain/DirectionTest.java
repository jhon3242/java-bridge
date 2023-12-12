package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DirectionTest {

    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void findByDirectionTrue(String value) {
        Assertions.assertThatNoException()
                .isThrownBy(() -> Direction.findByString(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "X", "UU", "DD"})
    void findByDirectionFail(String value) {
        Assertions.assertThatThrownBy(() -> Direction.findByString(value))
                .isInstanceOf(IllegalArgumentException.class);

    }
}