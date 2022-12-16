package bridge.domain;

public enum GameResultType {
    WIN("성공"),
    LOSE("실패"),
    CONTINUE("");

    private final String message;

    GameResultType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public boolean isContinue() {
        return this == CONTINUE;
    }

    public boolean isWin() {
        return this == WIN;
    }

    public boolean isLose() {
        return this == LOSE;
    }
}
