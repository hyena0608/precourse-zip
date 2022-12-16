package bridge.domain;

public class Round {

    private int round = 1;

    public void next() {
        this.round++;
    }

    public int getRound() {
        return round;
    }
}
