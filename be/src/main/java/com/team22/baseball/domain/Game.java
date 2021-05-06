package com.team22.baseball.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "GAME")
public class Game {

    @Id
    private final Long id;

    private final int round;

    private final boolean inProgress;

    @PersistenceConstructor
    private Game(Long id, int round, boolean inProgress) {
        this.id = id;
        this.round = round;
        this.inProgress = inProgress;
    }

    public Long getId() {
        return id;
    }

    public int getRound() {
        return round;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public static Game of(int round, boolean inProgress){
        return new Game(null, round, inProgress);
    }

}
