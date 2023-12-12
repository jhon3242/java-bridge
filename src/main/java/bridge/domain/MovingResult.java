package bridge.domain;

public enum MovingResult {
    BLANK(" "),
    SUCCESS("O"),
    FAIL("X");

    private final String stringValue;

    MovingResult(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public static MovingResult findByBoolean(boolean isTrue) {
        if (isTrue) {
            return SUCCESS;
        }
        return FAIL;
    }
}
