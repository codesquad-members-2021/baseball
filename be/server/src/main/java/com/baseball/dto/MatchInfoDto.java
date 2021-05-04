package com.baseball.dto;

public class MatchInfoDto {

    private final ScoreDto scores;
    private final Integer strike;
    private final Integer ball;
    private final Integer outCount;
    private final Boolean[] bases;
    private final String inningInfo;
    private final PitcherDto pitcher;
    private final BatterDto batter;
    private final Boolean[] pitcherInfo;

    public MatchInfoDto(ScoreDto scores, Integer strike, Integer ball, Integer outCount, Boolean[] bases, String inningInfo, PitcherDto pitcher, BatterDto batter, Boolean[] pitcherInfo) {
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

    public ScoreDto getScores() {
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

    public Boolean[] getBases() {
        return bases;
    }

    public String getInningInfo() {
        return inningInfo;
    }

    public PitcherDto getPitcher() {
        return pitcher;
    }

    public BatterDto getBatter() {
        return batter;
    }

    public Boolean[] getPitcherInfo() {
        return pitcherInfo;
    }
}
