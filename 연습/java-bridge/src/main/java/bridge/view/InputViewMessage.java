package bridge.view;

import static bridge.config.GlobalUnitMessage.ENTER;

public enum InputViewMessage {

    ANNOUNCE_START_BRIDGE_GAME("다리 건너기 게임을 시작합니다." + ENTER.getMessage()),
    REQUEST_BRIDGE_SIZE("다리의 길이를 입력해주세요." + ENTER.getMessage()),
    REQUEST_MOVE_TYPE("이동할 칸을 선택해주세요. (위: U, 아래: D)" + ENTER.getMessage()),
    REQUEST_GAME_END_TYPE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)" + ENTER.getMessage());

    private final String message;

    InputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
