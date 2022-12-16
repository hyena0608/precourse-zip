package bridge.domain;

import static bridge.domain.GameResultType.*;

public class Referee {

    public Referee() {
    }

    public GameResultType judge(Player player, BridgeAnswer bridgeAnswer) {
        boolean isSameSize = bridgeAnswer.compareSize(player.showUpBridge());
        boolean isSameMoveTypes = bridgeAnswer.compareSame(player.showUpBridge());

        if (isSameMoveTypes) {
            if (isSameSize) {
                return WIN;
            }
            return CONTINUE;
        }
        return LOSE;
    }
}
