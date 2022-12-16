package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeAnswer bridgeAnswer;
    private final Player player;
    private final Referee referee;
    private final GameHistory gameHistory;

    public BridgeGame(BridgeAnswer bridgeAnswer, Player player, Referee referee, GameHistory gameHistory) {
        this.bridgeAnswer = bridgeAnswer;
        this.player = player;
        this.referee = referee;
        this.gameHistory = gameHistory;
    }

    public void loadingComputer(int bridgeSize) {
        List<MoveType> computerMoveTypes = bridgeAnswer.initAnswer(bridgeSize);
        gameHistory.saveComputerAnswer(computerMoveTypes);
    }

    public void move(MoveType moveType) {
        player.move(moveType);
        gameHistory.savePlayerHistory(moveType);
    }

    public GameResultType askRefereeGameResult() {
        GameResultType gameResultType = referee.judge(player, bridgeAnswer);
        gameHistory.saveGameResult(gameResultType);
        return gameResultType;
    }

    public void retry() {
        player.reset();
        gameHistory.reset();
    }

    public GameHistory askGameHistory() {
        return gameHistory;
    }
}
