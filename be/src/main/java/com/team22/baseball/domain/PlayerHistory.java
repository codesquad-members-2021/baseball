package com.team22.baseball.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "PLAYER_HISTORY")
public class PlayerHistory {

    @Id
    private final Long id;

    private final Long playerId;

    private final int round;

    private final String record;

    @PersistenceConstructor
    private PlayerHistory(Long id, Long playerId, int round, String record) {
        this.id = id;
        this.playerId = playerId;
        this.round = round;
        this.record = record;
    }

    public Long getId() {
        return id;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public int getRound() {
        return round;
    }

    public String getRecord() {
        return record;
    }

    public static PlayerHistory of(Long playerId, int round, String record) {
        return new PlayerHistory(null, playerId, round, record);
    }
}
