package com.baseball.domain.player;

import com.baseball.domain.match.PitchResult;

public class Pitcher extends Player {
    private Integer numberOfPitching = 0;
    private Integer baseOnBalls = 0;
    private Integer innings = 0;

    public Pitcher(String name) {
        super(name);
    }

    @Override
    public void play(PitchResult pitchResult) {
        // TODO: pitchResult 에 따른 상태변화를 TDD 로 구현
    }

    public Integer getNumberOfPitching() {
        return numberOfPitching;
    }

    public Integer getBaseOnBalls() {
        return baseOnBalls;
    }

    public Integer getInnings() {
        return innings;
    }
}
