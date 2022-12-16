package bridge.domain;

import java.util.Arrays;

import static bridge.exception.GameEndTypeExceptionMessage.WRONG_GAME_END_TYPE_EXCEPTION;

public enum GameEndType {
    END("Q"),
    RETRY("R");

    private final String type;

    GameEndType(String type) {
        this.type = type;
    }

    public static GameEndType from(String type) {
        return Arrays.stream(GameEndType.values())
                .filter(endType -> endType.type.equals(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(WRONG_GAME_END_TYPE_EXCEPTION.getMessage()));
    }

    public boolean isEnd() {
        return this == END;
    }

    public boolean isRetry() {
        return this == RETRY;
    }
}
