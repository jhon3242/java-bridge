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
        System.out.println(ViewMessage.INPUT_BRIDGE_SIZE);
        String value = Console.readLine().trim();
        validateNumber(value);
        return Integer.parseInt(value);
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

    private static void validateNumber(String value) {
        validateBlank(value);
        validateInteger(value);
    }
}
