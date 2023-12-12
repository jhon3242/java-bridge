package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeResult;
import bridge.message.ViewMessage;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void printMap(BridgeResult bridgeResult) {
        printMapSide(bridgeResult.getUpSide());
        printMapSide(bridgeResult.getDownSide());
    }

    private static void printMapSide(List<String> side) {
        String movingResult = String.join(ViewMessage.BRIDGE_DELIMITER, side);
        System.out.printf(ViewMessage.BRIDGE_MAP_FORMAT, movingResult);
    }

    public static void printResult(BridgeGame bridgeGame) {
        System.out.println(ViewMessage.OUTPUT_FINAL_RESULT);
        printStatus(bridgeGame);
        printTrial(bridgeGame);
    }

    private static void printStatus(BridgeGame bridgeGame) {
        BridgeResult bridgeResult = BridgeResult.calculate(bridgeGame.getAnswer(), bridgeGame.getUser());
        printMap(bridgeResult);
        System.out.print(ViewMessage.OUTPUT_RESULT_STATUS);
        if (bridgeGame.isFail()) {
            System.out.println(ViewMessage.OUTPUT_STATUS_FAIL);
            return;
        }
        System.out.println(ViewMessage.OUTPUT_STATUS_SUCCESS);
    }

    private static void printTrial(BridgeGame bridgeGame) {
        System.out.printf(ViewMessage.OUTPUT_TRIAL_FORMAT, bridgeGame.getTrial());
    }

    public static void printException(IllegalArgumentException message) {
        System.out.println(ViewMessage.EXCEPTION_PREFIX + message.getMessage());
    }
}
