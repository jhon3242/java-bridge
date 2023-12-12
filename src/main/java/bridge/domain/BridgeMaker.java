package bridge.domain;

import bridge.message.ExceptionMessage;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final int MAX_SIZE = 20;
    private static final int MIN_SIZE = 3;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        validateBridgeSize(size);
        List<String> result = new ArrayList<>();
        while (result.size() != size) {
            Direction direction = Direction.findByInt(bridgeNumberGenerator.generate());
            result.add(direction.getStringValue());
        }
        return result;
    }

    private void validateBridgeSize(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.BRIDGE_SIZE);
        }
    }
}
