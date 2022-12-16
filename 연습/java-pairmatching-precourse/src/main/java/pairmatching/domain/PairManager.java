package pairmatching.domain;

import pairmatching.repository.CrewRepository;
import pairmatching.repository.PairMatchRepository;

import java.util.Collections;
import java.util.List;

import static pairmatching.global.GlobalExceptionMessage.CREW_MATCH_DUPLICATED_EXCEPTION;
import static pairmatching.global.GlobalExceptionMessage.MISSION_FIND_EXCEPTION;

public class PairManager {

    private final PairMenu pairMenu;
    public final CrewRepository crewRepository;
    private final PairMatchRepository pairMatchRepository;

    public PairManager(PairMenu pairMenu, CrewRepository crewRepository, PairMatchRepository pairMatchRepository) {
        this.pairMenu = pairMenu;
        this.crewRepository = crewRepository;
        this.pairMatchRepository = pairMatchRepository;
    }

    public List<CrewMatchResult> executePairMatch(Mission mission) {
        validateMissionExists(mission);
        if (isMissionDuplicated(mission)) {
            if (!checkReMatch()) {
                return Collections.emptyList();
            }
        }

        List<CrewMatchResult> newCrewMatchResults;
        int opportunity = 0;
        boolean isDuplicated;
        do {
            opportunity++;
            newCrewMatchResults = crewRepository.loadMatchedCrew(mission.loadCourse());
            isDuplicated = pairMatchRepository.isDuplicatedPairMatchResult(mission, newCrewMatchResults);
        } while (isDuplicated && opportunity < 3);
        validateDuplicatedPairMatchResult(isDuplicated);
        pairMatchRepository.savePairMatch(mission, newCrewMatchResults);
        return newCrewMatchResults;
    }

    private void validateMissionExists(Mission mission) {
        if (!pairMatchRepository.isMissionExists(mission)) {
            throw new IllegalArgumentException(MISSION_FIND_EXCEPTION.getMessage());
        }
    }

    public List<CrewMatchResult> executePairSearch(Mission mission) {
        return pairMatchRepository.loadPairMatchResult(mission);
    }

    public void executePairInit() {
        pairMatchRepository.clearData();
    }

    private boolean isMissionDuplicated(Mission mission) {
        return pairMatchRepository.isDuplicatedMission(mission);
    }

    private boolean checkReMatch() {
        return pairMenu.pairReMatch().isYes();
    }

    private void validateDuplicatedPairMatchResult(boolean isDuplicated) {
        if (isDuplicated) {
            throw new IllegalArgumentException(CREW_MATCH_DUPLICATED_EXCEPTION.getMessage());
        }
    }
}
