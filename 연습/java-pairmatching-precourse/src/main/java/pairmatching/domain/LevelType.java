package pairmatching.domain;

import java.util.Arrays;

import static pairmatching.global.GlobalExceptionMessage.LEVEL_TYPE_FIND_EXCEPTION;

public enum LevelType {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;

    LevelType(String name) {
        this.name = name;
    }

    public static LevelType from(String name) {
        return Arrays.stream(LevelType.values())
                .filter(level -> level.name.equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(LEVEL_TYPE_FIND_EXCEPTION.getMessage()));
    }
}
