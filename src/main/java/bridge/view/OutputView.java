package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeResult;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * @param bridgeResult
     */
    public static void printMap(BridgeResult bridgeResult) {
        printMapSide(bridgeResult.getUpside());
        printMapSide(bridgeResult.getDownSide());
    }

    private static void printMapSide(List<String> side) {
        String movingResult = String.join(" | ", side);
        System.out.printf("[ %s ]\n", movingResult);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * @param bridgeGame
     */
    public static void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printStatus(bridgeGame);
        printTrial(bridgeGame);
    }

    private static void printStatus(BridgeGame bridgeGame) {
        BridgeResult bridgeResult = BridgeResult.calculate(bridgeGame.getAnswer(), bridgeGame.getUser());
        printMap(bridgeResult);
        System.out.print("게임 성공 여부: ");
        if (bridgeGame.isFail()) {
            System.out.println("실패");
            return;
        }
        System.out.println("성공");
    }

    private static void printTrial(BridgeGame bridgeGame) {
        System.out.printf("총 시도한 횟수: %d", bridgeGame.getTrial());
    }

    public static void printException(IllegalArgumentException message) {
        System.out.println("[ERROR] : " + message.getMessage());
    }
}
