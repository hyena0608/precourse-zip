package pairmatching.domain;

import java.util.Arrays;

import static pairmatching.global.GlobalExceptionMessage.PAIR_WRONG_MENU_TYPE_EXCEPTION;

public enum MenuType {

    PAIR_MATCH_MENU_NUMBER("1"),
    PAIR_SEARCH_MENU_NUMBER("2"),
    PAIR_INIT_MENU_NUMBER("3"),
    PAIR_EXIT_MENU_NUMBER("Q");

    private final String type;

    MenuType(String type) {
        this.type = type;
    }

    public static MenuType from(String type) {
        return Arrays.stream(MenuType.values())
                .filter(menuType -> menuType.type.equals(type))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(PAIR_WRONG_MENU_TYPE_EXCEPTION.getMessage()));
    }

    public boolean isPairMatch() {
        return this == PAIR_MATCH_MENU_NUMBER;
    }

    public boolean isPairSearch() {
        return this == PAIR_SEARCH_MENU_NUMBER;
    }

    public boolean isPairInit() {
        return this == PAIR_INIT_MENU_NUMBER;
    }

    public boolean isPairExit() {
        return this == PAIR_EXIT_MENU_NUMBER;
    }
}
