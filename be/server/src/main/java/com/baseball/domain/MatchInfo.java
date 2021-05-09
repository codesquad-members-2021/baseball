package com.baseball.domain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatchInfo {
    private Integer halvesCount = 0;
    private List<Boolean> bases = Arrays.asList(false, false, false);
    private List<PitchResult> pitchResults = new ArrayList<>();

    public Integer getInningCount() {
        /**
         * NOTE: 한 이닝은 2개의 halves 로 이루어져있다.
         * 출처: https://en.wikipedia.org/wiki/Inning
         */
        return 1 + (halvesCount / 2);
    }

    public Boolean getUserTop() {
        return halvesCount % 2 == 0;
    }

    public Boolean getUserOffense() {
        return false;
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
}
