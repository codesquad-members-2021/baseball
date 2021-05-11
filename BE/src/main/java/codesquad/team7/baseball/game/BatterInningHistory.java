package codesquad.team7.baseball.game;

public class BatterInningHistory {

    private final Pitch pitch;
    private final String state;

    BatterInningHistory(Pitch pitch, String state) {
        this.pitch = pitch;
        this.state = state;
    }

    public Pitch getPictch() {
        return pitch;
    }

    public String getState() {
        return state;
    }
}
