package com.baseball.domain.player;

public class Player {
    private final String name;
    private final Integer hit;

    public Player(String name, Integer hit) {
        this.name = name;
        this.hit = hit;
    }

    public String getName() {
        return name;
    }

    public Integer getHit() {
        return hit;
    }
}
