package bridge.exception;

public enum GameEndTypeExceptionMessage {

    WRONG_GAME_END_TYPE_EXCEPTION("[ERROR] 잘못된 게임 종료(Q)/재시작(R) 타입 입력입니다.");

    private final String message;

    GameEndTypeExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
