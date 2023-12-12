package bridge.domain;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge answer;
    private final Bridge user;
    private int trial;

    public BridgeGame(Bridge answer, Bridge user) {
        this.answer = answer;
        this.user = user;
        this.trial = 1;
    }

    public void move(Direction direction) {
        user.addDirection(direction);
    }

    public void retry() {
        user.removeLastMove();
        this.trial++;
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

    public Bridge getAnswer() {
        return answer;
    }

    public Bridge getUser() {
        return user;
    }

    public int getTrial() {
        return trial;
    }
}
