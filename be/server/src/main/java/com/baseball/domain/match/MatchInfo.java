package com.baseball.domain.match;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MatchInfo {
    private Integer halvesCount = 1;
    private LinkedList<Boolean> bases = new LinkedList<>(Arrays.asList(false, false, false));
    private List<PlayResult> playResults = new ArrayList<>();

    int outCount = 0;

    public Integer getHalvesCount() {
        return halvesCount;
    }

    public Integer getStrikeCount() {
        return (int) playResults.stream()
                .filter(pitch -> pitch == PlayResult.STRIKE)
                .count();
    }

    public Integer getBallCount() {
        return (int) playResults.stream()
                .filter(pitch -> pitch == PlayResult.BALL)
                .count();
    }

    public Integer getOutCount() {
        return outCount;
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

    public Integer getInningCount() {
        /**
         * NOTE: 한 이닝은 2개의 halves 로 이루어져있다.
         * 출처: https://en.wikipedia.org/wiki/Inning
         */
        return (halvesCount + 1) / 2;
    }

    public Boolean getUserTop() {
        return halvesCount % 2 == 1;
    }

    public Boolean isThirdBaseTrue() {
        return bases.get(3);
    }

    public void pushPlayResult(PlayResult playResult) {
        playResults.add(playResult);
        if (getStrikeCount() % 3 == 0) {
            outCount++;
        }
    }

    public void resetPlayResults() {
        playResults = new ArrayList<>();
    }

    public void proceedToNextBase() {
        bases.removeLast();
        bases.addFirst(Boolean.TRUE);
        resetPlayResults();
    }

    public void proceedToNextHalve() {
        halvesCount++;
        bases = new LinkedList<>(Arrays.asList(false, false, false));
        resetPlayResults();
        outCount = 0;
    }
}
