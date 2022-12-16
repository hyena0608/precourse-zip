package bridge.domain;

import bridge.BridgeRandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class BridgeAnswer {

    private final Bridge bridgeAnswer = new Bridge();

    public List<MoveType> initAnswer(int bridgeSize) {
        List<MoveType> moveTypeAnswer = createBridgeAnswer(bridgeSize);
        moveTypeAnswer.forEach(bridgeAnswer::addMoveType);
        return moveTypeAnswer;
    }

    public boolean compareSame(Bridge bridge) {
        return this.bridgeAnswer.compareMoveTypes(bridge);
    }

    public boolean compareSize(Bridge bridge) {
        return this.bridgeAnswer.compareSize(bridge);
    }

    private List<MoveType> createBridgeAnswer(int size) {
        return new BridgeMaker(new BridgeRandomNumberGenerator())
                .makeBridge(size)
                .stream()
                .map(MoveType::stringFrom)
                .collect(Collectors.toList());
    }
}
