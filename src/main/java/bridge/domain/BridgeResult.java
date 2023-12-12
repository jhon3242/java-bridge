package bridge.domain;

import java.util.List;

public class BridgeResult {
    private List<String> upside;
    private List<String> downSide;

    public BridgeResult(List<String> upside, List<String> downSide) {
        this.upside = upside;
        this.downSide = downSide;
    }

    public List<String> getUpside() {
        return upside;
    }

    public List<String> getDownSide() {
        return downSide;
    }

    @Override
    public String toString() {
        return "BridgeResult{" +
                "upside=" + upside +
                ", downSide=" + downSide +
                '}';
    }
}
