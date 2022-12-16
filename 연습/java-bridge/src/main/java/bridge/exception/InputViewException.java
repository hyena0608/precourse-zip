package bridge.exception;

public enum InputViewException {

    WRONG_BRIDGE_SIZE_INPUT_TYPE("[ERROR] 다리 길이를 입력할 때는 숫자로만 입력할 수 있습니다."),
    WRONG_BRIDGE_SIZE("[ERROR] 다리의 길이는 3이상 20이하이어야 합니다.");

    private final String message;

    InputViewException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
