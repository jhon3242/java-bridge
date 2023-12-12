package bridge.domain;

import bridge.message.ExceptionMessage;
import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        validateList(bridge);
        this.bridge = new ArrayList<>(bridge);
    }

    private void validateList(List<String> bridge) {
        if (bridge.isEmpty()) {
            return;
        }
        bridge.forEach(Direction::findByString);
    }

    public void addDirection(Direction direction) {
        bridge.add(direction.getStringValue());
    }

    public Direction getDirection(int i) {
        if (i >= bridge.size()) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE);
        }
        return Direction.findByString(bridge.get(i));
    }

    public void removeLastMove() {
        bridge.remove(bridge.size() - 1);
    }

    public int getSize() {
        return bridge.size();
    }
}
