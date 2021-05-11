package codesquad.team7.baseball.game;

public class AwayPitcher implements Pitcher{

    private Integer awayPitcherNumber;

    private Integer awayPitches;

    public AwayPitcher(Integer awayPitcherNumber, Integer awayPitches) {
        this.awayPitcherNumber = awayPitcherNumber;
        this.awayPitches = awayPitches;
    }

    @Override
    public Integer getNumber() {
        return awayPitcherNumber;
    }

    @Override
    public Integer getPitches() {
        return awayPitches;
    }

    @Override
    public void pitchUp() {
        awayPitches++;
    }

}
