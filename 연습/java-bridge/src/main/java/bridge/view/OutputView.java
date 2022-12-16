package bridge.view;

import bridge.domain.GameHistory;
import bridge.domain.MoveType;

import java.util.List;

import static bridge.config.BridgeUnitMessage.*;
import static bridge.view.InputViewMessage.*;
import static bridge.view.OutputViewMessage.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStartBridgeGame() {
        System.out.print(ANNOUNCE_START_BRIDGE_GAME.getMessage());
    }

    public void printRequestBridgeSize() {
        System.out.print(REQUEST_BRIDGE_SIZE.getMessage());
    }

    public void printRequestMoveType() {
        System.out.print(REQUEST_MOVE_TYPE.getMessage());
    }

    public void printRequestGameEndType() {
        System.out.print(REQUEST_GAME_END_TYPE.getMessage());
    }

    public void printMap(GameHistory gameHistory) {
        List<MoveType> computerMoveTypes = gameHistory.loadComputerMoveTypes();
        List<MoveType> playerMoveTypes = gameHistory.loadPlayerMoveTypes();

        System.out.println("computerMoveTypes = " + computerMoveTypes);
        System.out.println("playerMoveTypes = " + playerMoveTypes);

        StringBuilder upBridgeBuilder = new StringBuilder();
        StringBuilder downBridgeBuilder = new StringBuilder();
        upBridgeBuilder.append(LEFT_SQUARE_BRACKET.getMessage());
        downBridgeBuilder.append(LEFT_SQUARE_BRACKET.getMessage());
        int playerBridgeSize = playerMoveTypes.size();
        for (int index = 0; index < playerBridgeSize; index++) {
            MoveType currentPlayerMoveType = playerMoveTypes.get(index);
            MoveType currentComputerMoveType = computerMoveTypes.get(index);
            if (currentPlayerMoveType.isUp()) {
                if (currentPlayerMoveType.isSame(currentComputerMoveType)) {
                    upBridgeBuilder.append(BRIDGE_AVAILABLE.getMessage())
                            .append(BRIDGE_SEPARATOR.getMessage());
                }
                if (!currentPlayerMoveType.isSame(currentComputerMoveType)) {
                    upBridgeBuilder.append(BRIDGE_UNAVAILABLE.getMessage())
                            .append(BRIDGE_SEPARATOR.getMessage());
                }
                downBridgeBuilder.append(BRIDGE_EMPTY.getMessage())
                        .append(BRIDGE_SEPARATOR.getMessage());
            }

            extracted(upBridgeBuilder, downBridgeBuilder, currentPlayerMoveType, currentComputerMoveType);
        }

        upBridgeBuilder.deleteCharAt(upBridgeBuilder.length() - 1);
        downBridgeBuilder.deleteCharAt(downBridgeBuilder.length() - 1);
        upBridgeBuilder.append(RIGHT_SQUARE_BRACKET.getMessage());
        downBridgeBuilder.append(RIGHT_SQUARE_BRACKET.getMessage());
        System.out.println(upBridgeBuilder);
        System.out.println(downBridgeBuilder);
    }

    private static void extracted(StringBuilder upBridgeBuilder, StringBuilder downBridgeBuilder, MoveType currentPlayerMoveType, MoveType currentComputerMoveType) {
        if (currentPlayerMoveType.isDown()) {
            if (currentPlayerMoveType.isSame(currentComputerMoveType)) {
                downBridgeBuilder.append(BRIDGE_AVAILABLE.getMessage())
                        .append(BRIDGE_SEPARATOR.getMessage());
            }
            if (!currentPlayerMoveType.isSame(currentComputerMoveType)) {
                downBridgeBuilder.append(BRIDGE_UNAVAILABLE.getMessage())
                        .append(BRIDGE_SEPARATOR.getMessage());
            }
            upBridgeBuilder.append(BRIDGE_EMPTY.getMessage())
                    .append(BRIDGE_SEPARATOR.getMessage());
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameHistory gameHistory) {
        System.out.print(ANNOUNCE_FINAL_RESULT.getMessage());
        printMap(gameHistory);
        System.out.print(ANNOUNCE_GAME_WIN_RESULT.getMessage());
        System.out.println(gameHistory.loadGameResult().getMessage());
        System.out.print(ANNOUNCE_GAME_ROUND.getMessage());
        System.out.println(gameHistory.loadRound());
    }

}
