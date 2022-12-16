package pairmatching.global;

public enum GlobalExceptionMessage {
    CREW_RILE_READER_EXCEPTION("[ERROR] 크루원 파일을 읽는중 오류가 발생하였습니다."),
    PAIR_WRONG_MENU_TYPE_EXCEPTION("[ERROR] 존재하지 않는 메뉴 타입입니다."),
    MISSION_PARSER_EXCEPTION("[ERROR] 입력 받은 미션 정보 파싱 도중에 오류가 발생하였습니다."),
    MISSION_TYPE_FIND_EXCEPTION("[ERROR] 미션을 찾던 도중에 오류가 발생하였습니다."),
    LEVEL_TYPE_FIND_EXCEPTION("[ERROR] 레벨을 찾던 도중에 오류가 발생하였습니다."),
    COURSE_TYPE_FIND_EXCEPTION("[ERROR] 코스를 찾던 도중에 오류가 발생하였습니다."),
    MISSION_FIND_EXCEPTION("[ERROR] 존재하지 않는 미션입니다."),
    CREW_MATCH_DUPLICATED_EXCEPTION("[ERROR] 페어 매칭 중 3회 이상 중복되어 오류가 발생하였습니다."),
    MISSION_DUPLICATED_EXCEPTION("[ERROR] 중복된 페어 매칭입니다."),
    RE_PAIR_MATCH_ANSWER_EXCEPTION("[ERROR] 리매칭 대답 명령에 오류가 발생하였습니다."),
    PAIR_SEARCH_EMPTY_EXCEPTION("[ERROR] 매칭 이력이 없습니다.");

    private final String message;

    GlobalExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
