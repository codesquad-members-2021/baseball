package com.baseball.dto;

public class MatchDto {

    private final String home;
    private final String away;
    private final String id;

    public MatchDto(String home, String away, String id) {
        this.home = home;
        this.away = away;
        this.id = id;
    }

    public String getHome() {
        return home;
    }

    public String getAway() {
        return away;
    }

    public String getId() {
        return id;
    }
}
