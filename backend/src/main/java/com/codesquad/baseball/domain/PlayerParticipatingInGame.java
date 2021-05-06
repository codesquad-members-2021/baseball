package com.codesquad.baseball.domain;

import org.springframework.data.annotation.Id;

public class PlayerParticipatingInGame {
    @Id
    private Integer id;
    private int team_participating_in_game;
    private int bat_order;
    private int player;
    private int plateAppearances;
    private int hitCount;
    private int outCount;

    public PlayerParticipatingInGame() {
    }

    public PlayerParticipatingInGame(int player) {
        this.player = player;
        this.plateAppearances = 0;
        this.hitCount = 0;
        this.outCount = 0;
    }

    @Override
    public String toString() {
        return "PlayerParticipatingInGame{" +
                "id=" + id +
                ", team_participating_in_game=" + team_participating_in_game +
                ", bat_order=" + bat_order +
                ", player=" + player +
                ", plateAppearances=" + plateAppearances +
                ", hitCount=" + hitCount +
                ", outCount=" + outCount +
                '}';
    }
}
