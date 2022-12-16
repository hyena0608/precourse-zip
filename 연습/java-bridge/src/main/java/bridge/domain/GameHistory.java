package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class GameHistory {

    private final Round round = new Round();
    private final List<MoveType> computerMoveTypes = new ArrayList<>();
    private final List<MoveType> playerMoveTypes = new ArrayList<>();
    private GameResultType gameResultType;

    public void saveComputerAnswer(List<MoveType> moveTypes) {
        computerMoveTypes.addAll(moveTypes);
    }

    public void savePlayerHistory(MoveType moveType) {
        playerMoveTypes.add(moveType);
    }

    public void reset() {
        playerMoveTypes.clear();
        round.next();
    }

    public void saveGameResult(GameResultType gameResultType) {
        this.gameResultType = gameResultType;
    }

    public int loadRound() {
        return round.getRound();
    }

    public GameResultType loadGameResult() {
        return this.gameResultType;
    }

    public List<MoveType> loadComputerMoveTypes() {
        return this.computerMoveTypes;
    }

    public List<MoveType> loadPlayerMoveTypes() {
        return this.playerMoveTypes;
    }
}
