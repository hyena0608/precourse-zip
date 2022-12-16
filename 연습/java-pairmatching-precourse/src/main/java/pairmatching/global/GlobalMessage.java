package pairmatching.global;

import static pairmatching.global.GlobalUnitMessage.ENTER;

public enum GlobalMessage {

    EXPLAIN_PAIR_MENU(
            "기능을 선택하세요." + ENTER.getMessage() +
                    "1. 페어 매칭" + ENTER.getMessage() +
                    "2. 페어 조회" + ENTER.getMessage() +
                    "3. 페어 초기화" + ENTER.getMessage() +
                    "Q. 종료" + ENTER.getMessage()),
    EXPLAIN_PAIR_MISSION_MENU(
            "#############################################" + ENTER.getMessage() +
                    "과정: 백엔드 | 프론트엔드" + ENTER.getMessage() +
                    "미션:" + ENTER.getMessage() +
                    "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임" + ENTER.getMessage() +
                    "  - 레벨2: 장바구니 | 결제 | 지하철노선도" + ENTER.getMessage() +
                    "  - 레벨3: " + ENTER.getMessage() +
                    "  - 레벨4: 성능개선 | 배포" + ENTER.getMessage() +
                    "  - 레벨5: " + ENTER.getMessage() +
                    "############################################" + ENTER.getMessage() +
                    "과정, 레벨, 미션을 선택하세요." + ENTER.getMessage() +
                    "ex) 백엔드, 레벨1, 자동차경주" + ENTER.getMessage()),
    EXPLAIN_REMATCH("매칭 정보가 있습니다. 다시 매칭하시겠습니까?" + ENTER.getMessage() +
            "네 | 아니오" + ENTER.getMessage()),
    EXPLAIN_PAIR_INIT_SUCCESS("초기화 되었습니다." + ENTER.getMessage());

    private final String message;

    GlobalMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
