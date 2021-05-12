package codesquad.team7.baseball.game;

public class BatterInningHistory {

    private final Pitch pitch;
    private final String state;

    public BatterInningHistory(Pitch pitch, String state) {
        this.pitch = pitch;
        this.state = state;
    }

    public Pitch getPitch() {
        return pitch;
    }

    public String getState() {
        return state;
    }

    public boolean checkBatterChangeEvent() {
        return pitch == Pitch.HIT || pitch == Pitch.OUT || pitch == Pitch.FOUR_BALL;
    }
}
