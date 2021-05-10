package codesquad.team7.baseball.game;

import org.springframework.data.relational.core.mapping.Column;

public class Pitcher {

    @Column("pitcher_number")
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

    public void pitchUp() {
        pitches++;
    }
}
