package com.baseball.dto;

public class PitcherDto {

    private String name;
    private Integer numberOfPitching;
    private Integer hit;
    private Integer baseOnBalls;
    private Integer innings;

    public PitcherDto(String name, Integer numberOfPitching, Integer hit, Integer baseOnBalls, Integer innings) {
        this.name = name;
        this.numberOfPitching = numberOfPitching;
        this.hit = hit;
        this.baseOnBalls = baseOnBalls;
        this.innings = innings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfPitching() {
        return numberOfPitching;
    }

    public void setNumberOfPitching(Integer numberOfPitching) {
        this.numberOfPitching = numberOfPitching;
    }

    public Integer getHit() {
        return hit;
    }

    public void setHit(Integer hit) {
        this.hit = hit;
    }

    public Integer getBaseOnBalls() {
        return baseOnBalls;
    }

    public void setBaseOnBalls(Integer baseOnBalls) {
        this.baseOnBalls = baseOnBalls;
    }

    public Integer getInnings() {
        return innings;
    }

    public void setInnings(Integer innings) {
        this.innings = innings;
    }
}
