package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;

public class MainController {
    public static void run() {
        Bridge answer = initBridge();
        Bridge user = new Bridge(new ArrayList<>());
        BridgeGame bridgeGame = new BridgeGame(answer, user);

        proceedBridge(bridgeGame);
//        OutputView.printResult(bridgeGame);
    }

    private static Bridge initBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int bridgeSize = InputView.readBridgeSize();
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    private static void proceedBridge(BridgeGame bridgeGame) {
//        while (true) {
//            bridgeGame.move(InputView.readMoving());
//            BridgeResult bridgeResult = bridgeGame.calculate();
//            OutputView.printMap(bridgeResult);
//
//            if (isEnd()) {
//                if (isRetry()) {
//                    bridgeGame.retry();
//                    continue;
//                }
//                break;
//            }
//        }
    }
}
