package pairmatching.domain;

import java.util.Arrays;

import static pairmatching.global.GlobalExceptionMessage.RE_PAIR_MATCH_ANSWER_EXCEPTION;

public enum RePairMatchType {

    YES("네"),
    NO("아니요");

    private final String type;

    RePairMatchType(String type) {
        this.type = type;
    }

    public static RePairMatchType from(String type) {
        return Arrays.stream(RePairMatchType.values())
                .filter(rePairMatchType -> rePairMatchType.type.equals(type))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(RE_PAIR_MATCH_ANSWER_EXCEPTION.getMessage()));
    }

    public boolean isYes() {
        return this == YES;
    }
}
