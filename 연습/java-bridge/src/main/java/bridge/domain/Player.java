package bridge.domain;

import java.util.ArrayList;

public class Player {

    private final Bridge bridge = new Bridge();

    public Bridge showUpBridge() {
        return bridge;
    }

    public void move(MoveType moveType) {
        bridge.addMoveType(moveType);
    }

    public void reset() {
        bridge.reset();
    }
}
