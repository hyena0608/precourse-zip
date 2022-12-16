package bridge.config;

public enum BridgeUnitMessage {
    LEFT_SQUARE_BRACKET("["),
    RIGHT_SQUARE_BRACKET("]"),
    BRIDGE_SEPARATOR("|"),
    BRIDGE_AVAILABLE(" O "),
    BRIDGE_UNAVAILABLE(" X "),
    BRIDGE_EMPTY("   ");

    private final String message;

    BridgeUnitMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
