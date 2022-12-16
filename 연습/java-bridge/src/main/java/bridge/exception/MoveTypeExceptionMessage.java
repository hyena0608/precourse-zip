package bridge.exception;

public enum MoveTypeExceptionMessage {

    WRONG_MOVE_TYPE_EXCEPTION("[ERROR] 잘못된 이동 타입 입력입니다.");

    private final String message;

    MoveTypeExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
