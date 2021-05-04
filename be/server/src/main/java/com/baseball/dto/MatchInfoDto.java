package com.baseball.dto;

public class MatchInfoDto {

    private ScoreDto scores;
    private Integer strike;
    private Integer ball;
    private Integer outCount;
    private Boolean[] bases;
    private String inningInfo;
    private PitcherDto pitcher;
    private BatterDto batter;
    private Boolean[] pitcherInfo;

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

    public void setScores(ScoreDto scores) {
        this.scores = scores;
    }

    public Integer getStrike() {
        return strike;
    }

    public void setStrike(Integer strike) {
        this.strike = strike;
    }

    public Integer getBall() {
        return ball;
    }

    public void setBall(Integer ball) {
        this.ball = ball;
    }

    public Integer getOutCount() {
        return outCount;
    }

    public void setOutCount(Integer outCount) {
        this.outCount = outCount;
    }

    public Boolean[] getBases() {
        return bases;
    }

    public void setBases(Boolean[] bases) {
        this.bases = bases;
    }

    public String getInningInfo() {
        return inningInfo;
    }

    public void setInningInfo(String inningInfo) {
        this.inningInfo = inningInfo;
    }

    public PitcherDto getPitcher() {
        return pitcher;
    }

    public void setPitcher(PitcherDto pitcher) {
        this.pitcher = pitcher;
    }

    public BatterDto getBatter() {
        return batter;
    }

    public void setBatter(BatterDto batter) {
        this.batter = batter;
    }

    public Boolean[] getPitcherInfo() {
        return pitcherInfo;
    }

    public void setPitcherInfo(Boolean[] pitcherInfo) {
        this.pitcherInfo = pitcherInfo;
    }
}
