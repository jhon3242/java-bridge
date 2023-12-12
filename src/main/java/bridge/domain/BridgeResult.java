package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeResult {
    private List<String> upSide;
    private List<String> downSide;

    public BridgeResult(List<String> upside, List<String> downSide) {
        this.upSide = upside;
        this.downSide = downSide;
    }

    public static BridgeResult calculate(Bridge answer, Bridge user) {
        BridgeResult bridgeResult = new BridgeResult(new ArrayList<>(), new ArrayList<>());
        for (int i = 0; i < user.getSize(); i++) {
            Direction answerDirection = answer.getDirection(i);
            Direction userDirection = user.getDirection(i);
            MovingResult movingResult = calculateMovingResult(answerDirection, userDirection);
            handleByDirection(bridgeResult, userDirection, movingResult);
        }
        return bridgeResult;
    }

    private static MovingResult calculateMovingResult(Direction answerDirection, Direction userDirection) {
        boolean isMatch = Direction.isMatch(answerDirection, userDirection);
        return MovingResult.findByBoolean(isMatch);
    }

    private static void handleByDirection(BridgeResult bridgeResult, Direction userDirection,
                                   MovingResult movingResult) {
        if (userDirection == Direction.Up) {
            bridgeResult.upSide.add(movingResult.getStringValue());
            bridgeResult.downSide.add(MovingResult.BLANK.getStringValue());
        }

        if (userDirection == Direction.Down) {
            bridgeResult.downSide.add(movingResult.getStringValue());
            bridgeResult.upSide.add(MovingResult.BLANK.getStringValue());
        }
    }

    public List<String> getUpSide() {
        return upSide;
    }

    public List<String> getDownSide() {
        return downSide;
    }

    @Override
    public String toString() {
        return "BridgeResult{" +
                "upside=" + upSide +
                ", downSide=" + downSide +
                '}';
    }
}
