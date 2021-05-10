package com.codesquad.baseball.domain;

import org.springframework.data.annotation.Id;

public class PitcherParticipatingInGame {
    @Id
    private Integer id;
    private int team_participating_in_game;
    private int player;
    private PitcherPosition pitcherPosition;
    private int hitCount;
    private int outCount;

    public PitcherParticipatingInGame() {
    }

    public PitcherParticipatingInGame(int player) {
        this.player = player;
        this.hitCount = 0;
        this.outCount = 0;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PitcherParticipatingInGame{" +
                "id=" + id +
                ", team_participating_in_game=" + team_participating_in_game +
                ", player=" + player +
                ", pitcherPosition=" + pitcherPosition +
                ", hitCount=" + hitCount +
                ", outCount=" + outCount +
                '}';
    }
}
