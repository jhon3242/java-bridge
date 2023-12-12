package bridge.domain;

import bridge.message.ExceptionMessage;
import java.util.Arrays;

public enum Direction {
    Up("U", 1),
    Down("D", 0);

    private String string;
    private int intValue;

    Direction(String string, int intValue) {
        this.string = string;
        this.intValue = intValue;
    }

    public static Direction findByInt(int intValue) {
        return Arrays.stream(Direction.values())
                .filter(dir -> dir.intValue == intValue)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.DIRECTION));
    }

    public String getString() {
        return string;
    }

    public int getIntValue() {
        return intValue;
    }
}
