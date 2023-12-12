package bridge.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeResultTest {

    @DisplayName("정답과 사용자의 다리를 비교하여 성공한 결과를 반환한다.")
    @Test
    void calculateSuccess() {
        Bridge answer = new Bridge(List.of("U", "U", "U"));
        Bridge user = new Bridge(List.of("U", "U", "U"));
        BridgeResult calculate = BridgeResult.calculate(answer, user);

        Assertions.assertThat(calculate.getUpSide()).isEqualTo(List.of("O", "O", "O"));
        Assertions.assertThat(calculate.getDownSide()).isEqualTo(List.of(" ", " ", " "));
    }

    @DisplayName("정답과 사용자의 다리를 비교하여 실패한 결과를 반환한다.")
    @Test
    void calculateFail() {
        Bridge answer = new Bridge(List.of("U", "U", "D"));
        Bridge user = new Bridge(List.of("U", "U", "U"));
        BridgeResult calculate = BridgeResult.calculate(answer, user);

        Assertions.assertThat(calculate.getUpSide()).isEqualTo(List.of("O", "O", "X"));
        Assertions.assertThat(calculate.getDownSide()).isEqualTo(List.of(" ", " ", " "));
    }
}