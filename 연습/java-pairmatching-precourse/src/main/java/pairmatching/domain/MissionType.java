package pairmatching.domain;

import java.util.Arrays;

import static pairmatching.global.GlobalExceptionMessage.MISSION_TYPE_FIND_EXCEPTION;

public enum MissionType {

    CAR("자동차경주"),
    LOTTO("로또"),
    BASEBALL("숫자야구게임"),
    BASKET("장바구니"),
    PURCHASE("결제"),
    SUBWAY("지하철노선도"),
    PERFORMANCE("성능개선"),
    DEPLOY("개선");

    private final String type;

    MissionType(String type) {
        this.type = type;
    }

    public static MissionType from(String type) {
        return Arrays.stream(MissionType.values())
                .filter(missionType -> missionType.type.equals(type))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(MISSION_TYPE_FIND_EXCEPTION.getMessage()));
    }
}
