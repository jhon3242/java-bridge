package bridge.domain;

import bridge.message.ExceptionMessage;
import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private int position;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        this.position = bridge.size();
    }



    @Override
    public String toString() {
        return "Bridge{" +
                "bridge=" + bridge +
                ", position=" + position +
                '}';
    }
}
