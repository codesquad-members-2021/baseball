package com.baseball.dto;

public class InningsDto {

    private final Integer[] away;
    private final Integer[] home;

    public InningsDto(Integer[] away, Integer[] home) {
        this.away = away;
        this.home = home;
    }

    public Integer[] getAway() {
        return away;
    }

    public Integer[] getHome() {
        return home;
    }
}
