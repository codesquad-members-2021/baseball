package com.baseball.domain;


import java.util.List;

public class MatchInfo {
    private final Score scores;
    private final Integer strike;
    private final Integer ball;
    private final Integer outCount;
    private final List<Boolean> bases;
    private final InningInfo inningInfo;
    private final Pitcher pitcher;
    private final Batter batter;
    private final List<Boolean> pitcherInfo;

    public MatchInfo(Score scores, Integer strike, Integer ball, Integer outCount, List<Boolean> bases, InningInfo inningInfo, Pitcher pitcher, Batter batter, List<Boolean> pitcherInfo) {
        this.scores = scores;
        this.strike = strike;
        this.ball = ball;
        this.outCount = outCount;
        this.bases = bases;
        this.inningInfo = inningInfo;
        this.pitcher = pitcher;
        this.batter = batter;
        this.pitcherInfo = pitcherInfo;
    }

    public Score getScores() {
        return scores;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }

    public Integer getOutCount() {
        return outCount;
    }

    public List<Boolean> getBases() {
        return bases;
    }

    public InningInfo getInningInfo() {
        return inningInfo;
    }

    public Pitcher getPitcher() {
        return pitcher;
    }

    public Batter getBatter() {
        return batter;
    }

    public List<Boolean> getPitcherInfo() {
        return pitcherInfo;
    }
}
