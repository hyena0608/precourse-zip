package bridge.exception;

public enum BridgeMakerExceptionMessage {

    WRONG_BRIDGE_SIZE("[ERROR] 다리의 길이는 3이상 20이하이어야 합니다.");

    private final String message;

    BridgeMakerExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
