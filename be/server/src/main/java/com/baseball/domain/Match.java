package com.baseball.domain;

public class Match {
    private final String home;
    private final String away;
    private final String id;

    public Match(String home, String away, String id) {
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
