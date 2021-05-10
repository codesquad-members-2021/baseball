package com.baseball.domain.player;

import com.baseball.domain.match.PitchResult;

public class Batter extends Player {
    private Integer plateAppearances = 1;
    private Integer out = 0;

    public Batter(String name) {
        super(name);
    }

    @Override
    public void play(PitchResult pitchResult) {
        // TODO: pitchResult 에 따른 상태변화를 TDD 로 구현
    }

    public Integer getPlateAppearances() {
        return plateAppearances;
    }

    public Integer getOut() {
        return out;
    }

    public Float getAverage() {
        return (float) getHit() / plateAppearances;
    }
}
