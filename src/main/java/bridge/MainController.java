package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.BridgeResult;
import bridge.domain.Direction;
import bridge.domain.RetryCommand;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;

public class MainController {
    public static void run() {
        BridgeGame bridgeGame = initBridgeGame();
        proceedBridge(bridgeGame);
        endGame(bridgeGame);
    }

    private static BridgeGame initBridgeGame() {
        OutputView.printStart();
        Bridge answer = initAnswerBridge();
        Bridge user = new Bridge(new ArrayList<>());
        return new BridgeGame(answer, user);
    }

    private static Bridge initAnswerBridge() {
        try {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            int bridgeSize = InputView.readBridgeSize();
            return new Bridge(bridgeMaker.makeBridge(bridgeSize));
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return initAnswerBridge();
        }
    }

    private static void proceedBridge(BridgeGame bridgeGame) {
        do {
            bridgeGame.move(readDirection());
            BridgeResult bridgeResult = BridgeResult.calculate(bridgeGame.getAnswer(), bridgeGame.getUser());
            OutputView.printMap(bridgeResult);
        } while (handleEnd(bridgeGame));
    }

    private static boolean handleEnd(BridgeGame bridgeGame) {
        if (bridgeGame.isEnd()) {
            if (bridgeGame.isFail() && isRetry()) {
                bridgeGame.retry();
                return true;
            }
            return false;
        }
        return true;
    }

    private static boolean isRetry() {
        try {
            RetryCommand command = RetryCommand.findByString(InputView.readGameCommand());
            return command == RetryCommand.YES;
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return isRetry();
        }
    }


    private static Direction readDirection() {
        try {
            return Direction.findByString(InputView.readMoving());
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return readDirection();
        }
    }

    private static void endGame(BridgeGame bridgeGame) {
        OutputView.printResult(bridgeGame);
    }
}
