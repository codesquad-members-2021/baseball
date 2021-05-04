package com.baseball.dto;

import java.util.List;

public class InningsDto {

    private final List<Integer> away;
    private final List<Integer> home;

    public InningsDto(List<Integer> away, List<Integer> home) {
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
