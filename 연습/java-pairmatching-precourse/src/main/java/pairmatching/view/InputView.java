package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.MenuType;
import pairmatching.domain.Mission;
import pairmatching.domain.RePairMatchType;
import pairmatching.util.MissionParser;

import static pairmatching.global.GlobalMessage.*;

public class InputView {

    public MenuType requestMenuType() {
        while (true) {
            try {
                System.out.print(EXPLAIN_PAIR_MENU.getMessage());
                return MenuType.from(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Mission requestPairMatchInformation() {
        while (true) {
            try {
                System.out.println(EXPLAIN_PAIR_MISSION_MENU.getMessage());
                return MissionParser.from(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public RePairMatchType requestRePairMatch() {
        while (true) {
            try {
                System.out.println(EXPLAIN_REMATCH.getMessage());
                return RePairMatchType.from(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
