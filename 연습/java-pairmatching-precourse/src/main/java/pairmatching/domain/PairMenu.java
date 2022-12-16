package pairmatching.domain;

import pairmatching.repository.CrewRepository;
import pairmatching.repository.PairMatchRepository;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;

public class PairMenu {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final PairManager pairManager;

    public PairMenu() {
        this.pairManager = new PairManager(this, new CrewRepository(), new PairMatchRepository());
    }

    public void start() {
        while (true) {
            MenuType inputMenu = inputView.requestMenuType();
            if (inputMenu.isPairMatch()) {
                pairMatch();
            }
            if (inputMenu.isPairSearch()) {
                pairSearch();
            }
            if (inputMenu.isPairInit()) {
                pairInit();
            }
            if (inputMenu.isPairExit()) {
                break;
            }
        }
    }

    private void pairMatch() {
        while (true) {
            try {
                Mission mission = inputView.requestPairMatchInformation();
                List<CrewMatchResult> crewMatchResults = pairManager.executePairMatch(mission);
                outputView.printMatchResult(crewMatchResults);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public RePairMatchType pairReMatch() {
        return inputView.requestRePairMatch();
    }

    private void pairSearch() {
        try {
            Mission mission = inputView.requestPairMatchInformation();
            List<CrewMatchResult> crewMatchResults = pairManager.executePairSearch(mission);
            outputView.printMatchResult(crewMatchResults);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void pairInit() {
        pairManager.executePairInit();
        outputView.printPairInit();
    }
}
