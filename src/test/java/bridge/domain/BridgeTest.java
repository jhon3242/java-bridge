package bridge.domain;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeTest {

    @DisplayName("비정상 리스트일 경우 생성자 단계에세 예외를 발생시킨다.")
    @ParameterizedTest
    @MethodSource("initFailProvider")
    void initFail(List<String> value) {
        Assertions.assertThatThrownBy(() -> new Bridge(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> initFailProvider() {
        return Stream.of(
                Arguments.of(List.of("U", "U", "NO")),
                Arguments.of(List.of("U", "U", "UU")),
                Arguments.of(List.of("U", "U", " "))
        );
    }

    @DisplayName("다리에 방향 추가시 정상적으로 추가된다.")
    @Test
    void addDirection() {
        Bridge bridge = new Bridge(List.of("U", "U", "U"));
        bridge.addDirection(Direction.Up);
        Assertions.assertThat(bridge.getSize()).isEqualTo(4);
    }

    @DisplayName("다리에 방향을 구할 때 정상적으로 구한다.")
    @Test
    void getDirection() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        Assertions.assertThat(bridge.getDirection(0)).isEqualTo(Direction.Up);
        Assertions.assertThat(bridge.getDirection(1)).isEqualTo(Direction.Down);
    }

    @DisplayName("다리에 마지막 방향을 제거한다.")
    @Test
    void removeLastMove() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        bridge.removeLastMove();
        Assertions.assertThat(bridge.getSize()).isEqualTo(2);
    }

    @DisplayName("다리의 길이를 구한다.")
    @Test
    void getSize() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        Assertions.assertThat(bridge.getSize()).isEqualTo(3);
    }
}