package com.baseball.domain;

import java.util.List;

public class Innings {

    private final List<Integer> away;
    private final List<Integer> home;

    public Innings(List<Integer> away, List<Integer> home) {
        this.away = away;
        this.home = home;
    }

    public List<Integer> getAway() {
        return away;
    }

    public List<Integer> getHome() {
        return home;
    }
}
