package com.baseball.domain.player;

public class Player {
    private final String name;
    private Integer hit = 0;

    public Player(String name) {
        this.name = name;
    }

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
