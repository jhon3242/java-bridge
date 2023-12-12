package bridge.domain;

import bridge.message.ExceptionMessage;
import java.util.Arrays;

public enum Direction {
    Up("U", 1),
    Down("D", 0);

    private String stringValue;
    private int intValue;

    Direction(String string, int intValue) {
        this.stringValue = string;
        this.intValue = intValue;
    }

    public static Direction findByInt(int value) {
        return Arrays.stream(Direction.values())
                .filter(dir -> dir.intValue == value)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.DIRECTION));
    }

    public static Direction findByString(String value) {
        return Arrays.stream(Direction.values())
                .filter(dir -> dir.stringValue.equals(value))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.DIRECTION));
    }

    public static boolean isMatch(Direction answerDirection, Direction userDirection) {
        return answerDirection.stringValue.equals(userDirection.stringValue) &&
                answerDirection.intValue == userDirection.intValue;
    }



    public String getStringValue() {
        return stringValue;
    }

    public int getIntValue() {
        return intValue;
    }
}
