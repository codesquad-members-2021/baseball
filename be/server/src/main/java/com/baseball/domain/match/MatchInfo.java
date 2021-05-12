package com.baseball.domain.match;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static com.baseball.domain.match.PlayResult.BALL;
import static com.baseball.domain.match.PlayResult.STRIKE;

public class MatchInfo {
    private Integer halvesCount = 1;
    private LinkedList<Boolean> bases = new LinkedList<>(Arrays.asList(false, false, false));
    private List<PlayResult> pitcherInfo = new ArrayList<>();

    int strikeCount = 0;
    int ballCount = 0;
    int outCount = 0;

    public Integer getHalvesCount() {
        return halvesCount;
    }

    public Integer getStrikeCount() {
        return strikeCount;
    }

    public Integer getBallCount() {
        return ballCount;
    }

    public Integer getOutCount() {
        return outCount;
    }

    public List<Boolean> getBases() {
        return bases;
    }

    public List<Boolean> getPitcherInfo() {
        /**
         * HELP: 타자(Batter) 가 다음 루에 진출하면,
         * pitcherInfo 를 초기화 하는게 맞는지 질문
         */
        return pitcherInfo.stream()
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
        if (playResult == STRIKE) {
            strikeCount++;
        } else if (playResult == BALL) {
            ballCount++;
        }
        pitcherInfo.add(playResult);
        if (getStrikeCount() == 3) {
            outCount++;
        }
    }

    public void proceedToNextBase() {
        bases.removeLast();
        bases.addFirst(Boolean.TRUE);
        strikeCount = 0;
        ballCount = 0;
    }

    public void proceedToNextHalve() {
        outCount = 0;
        halvesCount++;
        bases = new LinkedList<>(Arrays.asList(false, false, false));
        pitcherInfo = new ArrayList<>();
    }
}
