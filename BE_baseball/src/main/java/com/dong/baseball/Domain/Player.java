package com.dong.baseball.Domain;

public class Player {
    // 타자 투수 구별은 없음, 왜냐하면 불펜으로 타자가 투수할수도 있기 때문
    // 나중에 Player를 최대한 풍부하게 만들어놓고 batter, pitcher 클래스를 상속받아 만들면 됨
    private String name;
    private Integer uniformNumber;
    private Integer playedGames;
    private Integer atBat;
    private Integer hit;
    private Integer ball;
    private Integer strike;
    private Double battingAverage;

    /**
     * `ball`,
     * `name`,
     * `at_bat`,
     * strike`,
     * `played_games`,
     * ``uniform_number`,
     * `batting_average`,
     * `player_index`
     */

    public Integer getUniformNumber() {
        return uniformNumber;
    }

    public void setUniformNumber(Integer uniformNumber) {
        this.uniformNumber = uniformNumber;
    }

    public Integer getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(Integer playedGames) {
        this.playedGames = playedGames;
    }

    public Integer getAtBat() {
        return atBat;
    }

    public void setAtBat(Integer atBat) {
        this.atBat = atBat;
    }

    public Integer getHit() {
        return hit;
    }

    public void setHit(Integer hit) {
        this.hit = hit;
    }

    public Integer getBall() {
        return ball;
    }

    public void setBall(Integer ball) {
        this.ball = ball;
    }

    public Integer getStrike() {
        return strike;
    }

    public void setStrike(Integer strike) {
        this.strike = strike;
    }

    public Double getBattingAverage() {
        return battingAverage;
    }

    public void setBattingAverage(Double battingAverage) {
        this.battingAverage = (double) (this.hit + this.strike) / (double) (this.atBat);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", uniformNumber=" + uniformNumber +
                ", playedGames=" + playedGames +
                ", atBat=" + atBat +
                ", hit=" + hit +
                ", ball=" + ball +
                ", strike=" + strike +
                ", battingAverage=" + battingAverage +
                '}';
    }
}
