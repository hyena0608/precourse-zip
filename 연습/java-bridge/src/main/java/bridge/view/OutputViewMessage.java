package bridge.view;

import static bridge.config.GlobalUnitMessage.ENTER;

public enum OutputViewMessage {

    ANNOUNCE_FINAL_RESULT("최종 게임 결과" + ENTER.getMessage()),
    ANNOUNCE_GAME_WIN_RESULT("게임 성공 여부: "),
    ANNOUNCE_GAME_ROUND("총 시도한 횟수: ");

    private final String message;

    OutputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
