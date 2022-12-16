package bridge.view;

import bridge.domain.GameEndType;
import bridge.domain.MoveType;
import camp.nextstep.edu.missionutils.Console;

import static bridge.exception.BridgeMakerExceptionMessage.WRONG_BRIDGE_SIZE;
import static bridge.exception.InputViewException.WRONG_BRIDGE_SIZE_INPUT_TYPE;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String readBridgeSize = Console.readLine();
        validateInteger(readBridgeSize);
        int bridgeSize = Integer.parseInt(readBridgeSize);
        validateBridgeSizeRange(bridgeSize);
        return bridgeSize;
    }

    private void validateInteger(String readBridgeSize) {
        boolean isNumber = readBridgeSize.chars().allMatch(Character::isDigit);
        if (!isNumber) {
            throw new IllegalArgumentException(WRONG_BRIDGE_SIZE_INPUT_TYPE.getMessage());
        }
    }

    private void validateBridgeSizeRange(int bridgeSize) {
        if (3 > bridgeSize || bridgeSize > 20) {
            throw new IllegalArgumentException(WRONG_BRIDGE_SIZE.getMessage());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public MoveType readMoving() {
        String readMoveType = Console.readLine();
        return MoveType.stringFrom(readMoveType);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameEndType readGameCommand() {
        String readGameEndType = Console.readLine();
        return GameEndType.from(readGameEndType);
    }
}
