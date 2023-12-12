package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private int position;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        this.position = 0;
    }


}
