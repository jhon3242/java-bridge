package bridge.view;

import bridge.message.ExceptionMessage;
import bridge.message.ViewMessage;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public static int readBridgeSize() {
        System.out.println(ViewMessage.INPUT_BRIDGE_SIZE);
        String value = Console.readLine().trim();
        validateNumber(value);
        return Integer.parseInt(value);
    }

    public static String readMoving() {
        System.out.println(ViewMessage.INPUT_DIRECTION);
        String value = Console.readLine().trim();
        validateBlank(value);
        return value;
    }

    public static String readGameCommand() {
        System.out.println(ViewMessage.INPUT_RETRY_COMMAND);
        String value = Console.readLine().trim();
        validateBlank(value);
        return value;
    }

    private static void validateBlank(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.BLANK);
        }
    }

    private static void validateInteger(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER);
        }
    }

    private static void validateNumber(String value) {
        validateBlank(value);
        validateInteger(value);
    }
}
