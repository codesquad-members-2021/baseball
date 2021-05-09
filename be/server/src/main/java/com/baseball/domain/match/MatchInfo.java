package com.baseball.domain.match;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatchInfo {
    private Integer halvesCount = 0;
    private List<Boolean> bases = Arrays.asList(false, false, false);
    private List<PitchResult> pitchResults = new ArrayList<>();

    public Integer getHalvesCount() {
        return halvesCount;
    }

    public Integer getStrike() {
        return (int) pitchResults.stream()
                .filter(pitch -> pitch == PitchResult.STRIKE)
                .count();
    }

    public Integer getBall() {
        return (int) pitchResults.stream()
                .filter(pitch -> pitch == PitchResult.BALL)
                .count();
    }

    public Integer getOutCount() {
        return getStrike() / 3;
    }

    public List<Boolean> getBases() {
        return bases;
    }

    public List<Boolean> getPitcherInfo() {
        return pitchResults.stream()
                .filter(pitch -> pitch != PitchResult.HIT)
                .map(PitchResult::toBoolean)
                .collect(Collectors.toList());
    }

    public void pushPitchResult(PitchResult pitchResult) {
        pitchResults.add(pitchResult);
    }
}
