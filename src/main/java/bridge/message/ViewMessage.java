package bridge.message;

public class ViewMessage {
    public static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    public static final String INPUT_DIRECTION = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String INPUT_RETRY_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public static final String OUTPUT_START = "다리 건너기 게임을 시작합니다.";
    public static final String OUTPUT_FINAL_RESULT = "최종 게임 결과";
    public static final String OUTPUT_RESULT_STATUS = "게임 성공 여부: ";
    public static final String OUTPUT_STATUS_SUCCESS = "성공";
    public static final String OUTPUT_STATUS_FAIL = "실패";
    public static final String OUTPUT_TRIAL_FORMAT = "총 시도한 횟수: %d";

    public static final String EXCEPTION_PREFIX = "[ERROR] : ";
    public static final String BRIDGE_MAP_FORMAT = "[ %s ]\n";
    public static final String BRIDGE_DELIMITER = " | ";
}
