package com.dong.baseball.Domain;

public class Player {
    private String name;
    private Integer uniformNumber;
    private Integer playedGames;
    private Integer atBat;
    private Integer hit;
    private Integer ball;
    private Integer strike;
    private Double battingAverage;

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
