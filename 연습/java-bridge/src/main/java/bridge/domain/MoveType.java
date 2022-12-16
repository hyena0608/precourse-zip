package bridge.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static bridge.exception.MoveTypeExceptionMessage.WRONG_MOVE_TYPE_EXCEPTION;

public enum MoveType {
    MOVE_UP("U", 1),
    MOVE_DOWN("D", 0);

    private final String stringType;
    private final int numberType;

    MoveType(String stringType, int numberType) {
        this.stringType = stringType;
        this.numberType = numberType;
    }

    public static MoveType stringFrom(String type) {
        return Arrays.stream(MoveType.values())
                .filter(moveType -> moveType.stringType.equals(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(WRONG_MOVE_TYPE_EXCEPTION.getMessage()));
    }

    public static String toStringType(int type) {
        return Arrays.stream(MoveType.values())
                .filter(moveType -> moveType.numberType == type)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(WRONG_MOVE_TYPE_EXCEPTION.getMessage()))
                .stringType;
    }

    public boolean isUp() {
        return this == MOVE_UP;
    }

    public boolean isDown() {
        return this == MOVE_DOWN;
    }

    public boolean isSame(MoveType moveType) {
        return this == moveType;
    }

    @Override
    public String toString() {
        return "MoveType{" +
                "stringType='" + stringType + '\'' +
                ", numberType=" + numberType +
                '}';
    }
}
