package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeResult {
    private List<String> upside;
    private List<String> downSide;

    public BridgeResult(List<String> upside, List<String> downSide) {
        this.upside = upside;
        this.downSide = downSide;
    }

    public static BridgeResult calculate(Bridge answer, Bridge user) {
        List<String> upSide = new ArrayList<>();
        List<String> downSide = new ArrayList<>();
        for (int i = 0; i < user.getSize(); i++) {
            Direction answerDirection = answer.getDirection(i);
            Direction userDirection = user.getDirection(i);
            MovingResult movingResult = calculateMovingResult(answerDirection, userDirection);
            handleByDirection(upSide, downSide, userDirection, movingResult);
        }
        return new BridgeResult(upSide, downSide);
    }

    private static MovingResult calculateMovingResult(Direction answerDirection, Direction userDirection) {
        boolean isMatch = Direction.isMatch(answerDirection, userDirection);
        return MovingResult.findByBoolean(isMatch);
    }

    private static void handleByDirection(List<String> upSide, List<String> downSide, Direction userDirection,
                                   MovingResult movingResult) {
        if (userDirection == Direction.Up) {
            upSide.add(movingResult.getStringValue());
            downSide.add(MovingResult.BLANK.getStringValue());
        }

        if (userDirection == Direction.Down) {
            downSide.add(movingResult.getStringValue());
            upSide.add(MovingResult.BLANK.getStringValue());
        }
    }

    public List<String> getUpside() {
        return upside;
    }

    public List<String> getDownSide() {
        return downSide;
    }

    @Override
    public String toString() {
        return "BridgeResult{" +
                "upside=" + upside +
                ", downSide=" + downSide +
                '}';
    }
}
