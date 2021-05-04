package com.baseball.dto;

public class InningsDto {

    private Integer[] away;
    private Integer[] home;

    public InningsDto(Integer[] away, Integer[] home) {
        this.away = away;
        this.home = home;
    }

    public Integer[] getAway() {
        return away;
    }

    public void setAway(Integer[] away) {
        this.away = away;
    }

    public Integer[] getHome() {
        return home;
    }

    public void setHome(Integer[] home) {
        this.home = home;
    }
}
