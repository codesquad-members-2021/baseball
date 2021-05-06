package codesquad.team7.baseball.view;

public class Pitcher {

    private Integer number;
    private Integer pitches;

    public Pitcher(Integer number, Integer pitches) {
        this.number = number;
        this.pitches = pitches;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getPitches() {
        return pitches;
    }
}
