package bridge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Bridge {

    private final List<MoveType> moveTypes = new ArrayList<>();

    public void addMoveType(MoveType moveType) {
        moveTypes.add(moveType);
    }

    public boolean compareMoveTypes(Bridge anotherBridge) {
        List<MoveType> anotherMoveTypes = anotherBridge.moveTypes;
        int compareSize = Math.min(moveTypes.size(), anotherMoveTypes.size());
        return checkAllSame(anotherMoveTypes, compareSize);
    }

    private boolean checkAllSame(List<MoveType> anotherMoveTypes, int minBridgeSize) {
        return IntStream.range(0, minBridgeSize)
                .allMatch(currentBridgeIndex -> {
                    MoveType moveType = moveTypes.get(currentBridgeIndex);
                    MoveType anotherMoveType = anotherMoveTypes.get(currentBridgeIndex);
                    return moveType.isSame(anotherMoveType);
                });
    }

    public boolean compareSize(Bridge bridge) {
        return this.moveTypes.size() == bridge.moveTypes.size();
    }

    public void reset() {
        moveTypes.clear();
    }
}
