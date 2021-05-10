package com.baseball.domain.player;

import com.baseball.domain.match.PlayResult;

public abstract class Player {
    private final String name;
    private Integer hit = 0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getHit() {
        return hit;
    }

    public abstract void play(PlayResult playResult);
}
