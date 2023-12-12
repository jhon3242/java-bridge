package bridge.domain;

import bridge.message.ExceptionMessage;
import java.util.Arrays;

public enum RetryCommand {
    YES("R"),
    NO("Q");

    private final String stringValue;

    RetryCommand(String stringValue) {
        this.stringValue = stringValue;
    }

    public static RetryCommand findByString(String value) {
        return Arrays.stream(RetryCommand.values())
                    .filter(command -> command.stringValue.equals(value))
                    .findAny()
                    .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.RETRY_COMMAND));
    }
}
