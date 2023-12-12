package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridge answer;
    private Bridge user;
    private int trial;

    public BridgeGame(Bridge answer, Bridge user) {
        this.answer = answer;
        this.user = user;
        this.trial = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Direction direction) {
        user.addDirection(direction);
    }

    public boolean isEnd() {
        return (answer.getSize() == user.getSize() && isSuccess()) ||
                !isSuccess();
    }

    private boolean isSuccess() {
        for (int i = 0; i < user.getSize(); i++) {
            if (answer.getDirection(i) != user.getDirection(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isFail() {
        return !isSuccess();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        user.removeLastMove();
        this.trial++;
    }

    public BridgeResult calculate() {
        List<String> upSide = new ArrayList<>();
        List<String> downSide = new ArrayList<>();

        for (int i = 0; i < user.getSize(); i++) {
            Direction answerDirection = answer.getDirection(i);
            Direction userDirection = user.getDirection(i);
            boolean isMatch = Direction.isMatch(answerDirection, userDirection);
            MovingResult movingResult = MovingResult.findByBoolean(isMatch);

            if (userDirection == Direction.Up) {
                upSide.add(movingResult.getStringValue());
                downSide.add(MovingResult.BLANK.getStringValue());
            }

            if (userDirection == Direction.Down) {
                downSide.add(movingResult.getStringValue());
                upSide.add(MovingResult.BLANK.getStringValue());
            }
        }
        return new BridgeResult(upSide, downSide);
    }

    public int getTrial() {
        return trial;
    }
}
