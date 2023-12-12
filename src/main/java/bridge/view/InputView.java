package bridge.view;

import bridge.message.ExceptionMessage;
import bridge.message.ViewMessage;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        try {
            System.out.println(ViewMessage.INPUT_BRIDGE_SIZE);
            String value = Console.readLine().trim();
            validateNumber(value);
            int intValue = Integer.parseInt(value);
            validateBridgeSize(intValue);
            return intValue;
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     * 검증 필요
     */
    public static String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        return null;
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

    private static void validateBridgeSize(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(ExceptionMessage.BRIDGE_SIZE);
        }
    }

    private static void validateNumber(String value) {
        validateBlank(value);
        validateInteger(value);
    }
}
