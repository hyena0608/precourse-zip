package pairmatching.view;

import pairmatching.domain.CrewMatchResult;

import java.util.List;
import java.util.stream.Collectors;

import static pairmatching.global.GlobalMessage.EXPLAIN_PAIR_INIT_SUCCESS;
import static pairmatching.global.GlobalUnitMessage.ENTER;

public class OutputView {

    public void printMatchResult(List<CrewMatchResult> crewMatchResults) {
        String matchResult = crewMatchResults
                .stream()
                .map(CrewMatchResult::toString)
                .collect(Collectors.joining(ENTER.getMessage()));
        System.out.println(matchResult);
    }

    public void printPairInit() {
        System.out.println(EXPLAIN_PAIR_INIT_SUCCESS.getMessage());
    }
}
