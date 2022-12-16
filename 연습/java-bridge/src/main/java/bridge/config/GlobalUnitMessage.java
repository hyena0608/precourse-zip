package bridge.config;

public enum GlobalUnitMessage {

    ENTER(System.lineSeparator());

    private final String message;

    GlobalUnitMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
