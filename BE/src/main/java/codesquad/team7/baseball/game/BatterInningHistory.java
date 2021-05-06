package codesquad.team7.baseball.game;

public class BatterInningHistory {

    private final Pictch pictch;
    private final String state;

    BatterInningHistory(Pictch pictch, String state) {
        this.pictch = pictch;
        this.state = state;
    }

    public Pictch getPictch() {
        return pictch;
    }

    public String getState() {
        return state;
    }
}
