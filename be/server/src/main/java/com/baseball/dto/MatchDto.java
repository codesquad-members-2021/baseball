package com.baseball.dto;

public class MatchDto {

    private String home;
    private String away;
    private String id;

    public MatchDto(String home, String away, String id) {
        this.home = home;
        this.away = away;
        this.id = id;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
