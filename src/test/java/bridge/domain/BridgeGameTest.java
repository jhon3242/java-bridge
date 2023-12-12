package bridge.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @DisplayName("아직 끝나지 않은 경우 isEnd 는 False 를 반환한다.")
    @Test
    void isEndFalse() {
        Bridge answer = new Bridge(List.of("U", "U", "U"));
        Bridge user = new Bridge(List.of("U", "U"));
        BridgeGame bridgeGame = new BridgeGame(answer, user);
        Assertions.assertThat(bridgeGame.isEnd()).isFalse();
    }

    @DisplayName("잘못된 방향으로 게임이 끝난 경우 isEnd 는 True 를 반환한다.")
    @Test
    void isEndTrueWithFail() {
        Bridge answer = new Bridge(List.of("U", "U", "U"));
        Bridge user = new Bridge(List.of("U", "D"));
        BridgeGame bridgeGame = new BridgeGame(answer, user);
        Assertions.assertThat(bridgeGame.isEnd()).isTrue();
    }

    @DisplayName("정답을 맞춘 경우 isEnd 는 True 를 반환한다.")
    @Test
    void isEndTrueWithEnd() {
        Bridge answer = new Bridge(List.of("U", "U", "U"));
        Bridge user = new Bridge(List.of("U", "U", "U"));
        BridgeGame bridgeGame = new BridgeGame(answer, user);
        Assertions.assertThat(bridgeGame.isEnd()).isTrue();
    }
}