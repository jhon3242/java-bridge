package bridge.domain;

import bridge.message.ExceptionMessage;
import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public void addDirection(Direction direction) {
        bridge.add(direction.getStringValue());
    }




    public int getSize() {
        return bridge.size();
    }

    public Direction getDirection(int i) {
        if (i >= bridge.size()) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE);
        }
        return Direction.findByString(bridge.get(i));
    }

}
