package bridge.domain;

import bridge.BridgeNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static bridge.exception.BridgeMakerExceptionMessage.*;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validateSize(size);
        List<String> bridge = new ArrayList<>();
        for (int count = 0; count < size; count++) {
            bridge.add(MoveType.toStringType(bridgeNumberGenerator.generate()));
        }
        return bridge;
    }

    private void validateSize(int size) {
        if (3 > size || size > 20) {
            throw new IllegalArgumentException(WRONG_BRIDGE_SIZE.getMessage());
        }
    }
}
