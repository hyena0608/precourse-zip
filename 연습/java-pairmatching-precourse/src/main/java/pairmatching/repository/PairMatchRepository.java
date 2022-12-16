package pairmatching.repository;

import pairmatching.config.DataConfig;
import pairmatching.domain.CrewMatchResult;
import pairmatching.domain.Mission;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static pairmatching.global.GlobalExceptionMessage.PAIR_SEARCH_EMPTY_EXCEPTION;

public class PairMatchRepository {

    private static final Map<Mission, List<CrewMatchResult>> pairMatchHistory = new HashMap<>();

    static {
        setUpMissionData();
    }

    private static void setUpMissionData() {
        DataConfig.missionDummy()
                .forEach(mission -> pairMatchHistory.put(mission, Collections.emptyList()));
    }

    private static boolean isDuplicated(List<CrewMatchResult> newCrewMatchResults, CrewMatchResult crewMatchResult) {
        return newCrewMatchResults.stream()
                .anyMatch(newCrewMatchResult -> newCrewMatchResult.equals(crewMatchResult));
    }

    public void savePairMatch(Mission mission, List<CrewMatchResult> newCrewMatchResults) {
        pairMatchHistory.put(mission, newCrewMatchResults);
    }

    public List<CrewMatchResult> loadPairMatchResult(Mission mission) {
        List<CrewMatchResult> findMatchResult = pairMatchHistory.get(mission);
        if (findMatchResult.isEmpty()) {
            throw new IllegalArgumentException(PAIR_SEARCH_EMPTY_EXCEPTION.getMessage());
        }
        return findMatchResult;
    }

    public boolean isDuplicatedPairMatchResult(Mission mission, List<CrewMatchResult> newCrewMatchResults) {
        if (pairMatchHistory.containsKey(mission)) {
            List<CrewMatchResult> crewMatchResults = pairMatchHistory.get(mission);
            return crewMatchResults.stream()
                    .anyMatch(crewMatchResult -> isDuplicated(newCrewMatchResults, crewMatchResult));
        }
        return false;
    }

    public boolean isDuplicatedMission(Mission mission) {
        return !pairMatchHistory.get(mission).isEmpty();
    }

    public void clearData() {
        setUpMissionData();
    }

    public boolean isMissionExists(Mission mission) {
        return pairMatchHistory.containsKey(mission);
    }
}
