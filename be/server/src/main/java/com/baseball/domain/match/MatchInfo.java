package com.baseball.domain.match;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static com.baseball.domain.match.PlayResult.STRIKE;

public class MatchInfo {
    private Integer halvesCount = 1;
    private LinkedList<Boolean> bases = new LinkedList<>(Arrays.asList(false, false, false));
    private List<PlayResult> playResults = new ArrayList<>();

    int strikeCount = 0;
    int outCount = 0;

    public Integer getHalvesCount() {
        return halvesCount;
    }

    public Integer getStrikeCount() {
        return strikeCount;
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
        return bases.get(2);
    }

    public void pushPlayResult(PlayResult playResult) {
        playResults.add(playResult);
        if (playResult == STRIKE) {
            strikeCount++;
        }
        if (strikeCount >= 3) {
            outCount++;
            strikeCount = 0;
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
