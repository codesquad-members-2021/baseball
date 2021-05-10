package com.baseball.domain.player;

import com.baseball.domain.match.PitchResult;

public class Pitcher extends Player {
    private Integer numberOfPitching = 0;
    private Integer ballCount = 0;
    private Integer strikeCount = 0;

    public Pitcher(String name) {
        super(name);
    }

    @Override
    public void play(PitchResult pitchResult) {
        // TODO: pitchResult 에 따른 상태변화를 TDD 로 구현
        if (pitchResult == PitchResult.STRIKE) {
            numberOfPitching++;
            strikeCount++;
        }
        if (pitchResult == PitchResult.BALL) {
            numberOfPitching++;
            ballCount++;
        }
    }

    public Integer getNumberOfPitching() {
        return numberOfPitching;
    }

    public Float getBaseOnBalls() {
        return (float) ballCount / 4;
    }

    private Integer getOutCount() {
        return strikeCount / 3;
    }

    public Float getInnings() {
        return (float) getOutCount() / 3;

    }

}
