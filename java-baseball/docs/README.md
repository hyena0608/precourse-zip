# 숫자 야구 기능 요구사항 정리

| 확인  | 제목      | 내용              | 설명                                               |
|-----|---------|-----------------|--------------------------------------------------|
|  ✅  | 공       | 컴퓨터, 플레이어가 갖는 공 | 1 <= 공 <= 9                                      |
|  ✅  | 공       | 컴퓨터, 플레이어가 갖는 공 | 숫자는 중복되지 않는다.                                    |
|  ✅  | 컴퓨터     | 게임 내 상대방 역할     | 임의의 공 3개를 갖는다.                                   |
|  ✅  | 게임 플레이어 | 게임 플레이어         | 콘솔에 숫자 3개를 입력하여 갖는다.                             |
|  ✅  | 스트라이크   | 힌트 1            | 같은 수가 같은 자리에 있을 때 '스트라이크'라고 한다.                  |
|  ✅  | 볼       | 힌트 2            | 같은 수가 다른 자리에 있을 때 '볼'이라고 한다.                     |
|  ✅  | 낫싱      | 힌트 3            | 같은 수가 전혀 없으면 '낫싱'이라고 한다.                         |
|  ✅  | 게임 재시작  | 콘솔 입력 명령어       | 게임이 끝난 후 숫자 '1' 입력시 게임을 재시작한다.                   |
|  ✅  | 게임 종료   | 콘솔 입력 명령어       | 게임이 끝난 후 쑷자 '2' 입력시 게임을 종료한다.                    |
|  ✅  | 승리      | 승리 조건           | 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임 종료                    |
|  ✅  | 패배      | 패배 조건           | 컴퓨터가 선택한 3개의 숫자를 모두 못맞힌 경우                       |
|  ✅  | 게임 시작   | 콘솔 출력           | 게임 시작시 게임 시작 문구를 출력한다.                           |
|  ✅  | 게임 플레이어 숫자 | 콘솔 출력           | 게임 시작시 플레이어 숫자 입력 요구 문구를 출력한다.                   |
|  ✅  | 힌트      | 콘솔 출력           | 컴퓨터의 수와 플레이어의 수를 비교해서 힌트를 출력한다.                  |
|  ✅  | 게임 승리   | 콘솔 출력           | 게임 승리시 승리 문구를 출력한다.                              |
|  ✅  | 게임 종료   | 콘솔 출력           | 게임 종료시 재시작, 종료 명령 입력 요구 문구를 출력한다.                |
|  ✅  | 게임 플레이어 | 예외처리            | 잘못된 값 입력시 IllegalArgumentException 발생, 애플리케이션 종료 |