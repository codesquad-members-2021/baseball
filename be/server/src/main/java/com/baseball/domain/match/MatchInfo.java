package com.baseball.domain.match;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatchInfo {
    private Integer halvesCount = 1;
    private List<Boolean> bases = new ArrayList<>(Arrays.asList(false, false, false));
    private List<PlayResult> playResults = new ArrayList<>();

    public Integer getHalvesCount() {
        return halvesCount;
    }

    public Integer getStrike() {
        return (int) playResults.stream()
                .filter(pitch -> pitch == PlayResult.STRIKE)
                .count();
    }

    public Integer getBall() {
        return (int) playResults.stream()
                .filter(pitch -> pitch == PlayResult.BALL)
                .count();
    }

    public Integer getOutCount() {
        return getStrike() / 3;
    }

    public List<Boolean> getBases() {
        return bases;
    }

    public List<Boolean> getPitcherInfo() {
        return playResults.stream()
                .filter(pitch -> pitch != PlayResult.HIT)
                .map(PlayResult::toBoolean)
                .collect(Collectors.toList());
    }

    public void update(PlayResult playResult) {
        // TODO: playResult 에 따른 상태변화를 TDD 로 구현
        playResults.add(playResult);

        if (playResult == PlayResult.HIT) {
            bases.remove(2);
            bases.add(0, Boolean.TRUE);
        }

        if (playResult == PlayResult.STRIKE) {
            if (getOutCount() == 3) {
                halvesCount++;
            }
        }
    }
}
