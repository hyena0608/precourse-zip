package bridge;

import bridge.domain.*;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame(
                new BridgeAnswer(),
                new Player(),
                new Referee(),
                new GameHistory());

        GameManager gameManager = new GameManager(
                new InputView(), new OutputView(), bridgeGame);

        gameManager.playGame();
    }
}
