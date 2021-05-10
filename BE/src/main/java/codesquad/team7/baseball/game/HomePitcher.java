package codesquad.team7.baseball.game;

public class HomePitcher implements Pitcher{

    private Integer homePitcherNumber;

    private Integer homePitches;

    public HomePitcher(Integer homePitcherNumber, Integer homePitches) {
        this.homePitcherNumber = homePitcherNumber;
        this.homePitches = homePitches;
    }

    @Override
    public Integer getNumber() {
        return homePitcherNumber;
    }

    @Override
    public Integer getPitches() {
        return homePitches;
    }

    @Override
    public void pitchUp() {
        homePitches++;
    }
}
