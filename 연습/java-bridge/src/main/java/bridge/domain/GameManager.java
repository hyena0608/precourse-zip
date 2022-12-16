package bridge.domain;

import bridge.view.InputView;
import bridge.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

import static bridge.domain.GameEndType.END;
import static bridge.domain.GameResultType.*;

public class GameManager {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;


    public GameManager(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    public void playGame() {
        GameResultType gameResultType = CONTINUE;
        int bridgeSize = requestBridgeSize();
        bridgeGame.loadingComputer(bridgeSize);

        while (gameResultType.isContinue()) {
            bridgeGame.move(requestMoveType());
            gameResultType = bridgeGame.askRefereeGameResult();
            handleBridgeMapProcess();
            handleWinProcess(gameResultType);
            gameResultType = handleLoseProcess(gameResultType);
        }
    }

    private void handleBridgeMapProcess() {
        outputView.printMap(bridgeGame.askGameHistory());
    }

    private GameResultType handleLoseProcess(GameResultType gameResultType) {
        if (!gameResultType.isLose()) {
            return gameResultType;
        }
        GameEndType gameEndType = requestGameEndType();
        if (gameEndType.isRetry()) {
            System.out.println("gameEndType = " + gameEndType);
            bridgeGame.retry();
            return CONTINUE;
        }
        return LOSE;
    }

    private void handleWinProcess(GameResultType gameResultType) {
        if (gameResultType.isWin()) {
            outputView.printResult(bridgeGame.askGameHistory());
        }
    }

    private int requestBridgeSize() {
        outputView.printStartBridgeGame();
        while (true) {
            outputView.printRequestBridgeSize();
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private MoveType requestMoveType() {
        while (true) {
            outputView.printRequestMoveType();
            try {
                return inputView.readMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private GameEndType requestGameEndType() {
        while (true) {
            outputView.printRequestGameEndType();
            try {
                return inputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
