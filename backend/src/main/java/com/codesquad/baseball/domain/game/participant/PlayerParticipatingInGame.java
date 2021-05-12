package com.codesquad.baseball.domain.game.participant;

import org.springframework.data.annotation.Id;

public class PlayerParticipatingInGame {

    @Id
    private Integer id;
    private int team_participating_in_game;
    private int batOrder;
    private int player;
    private int plateAppearances;
    private int hitCount;
    private int outCount;
    private PitcherPosition pitcherPosition;

    public PlayerParticipatingInGame() {
    }

    public PlayerParticipatingInGame(int player) {
        this.player = player;
        this.plateAppearances = 0;
        this.hitCount = 0;
        this.outCount = 0;
        this.pitcherPosition = PitcherPosition.NONE;
    }

    public PlayerParticipatingInGame(int player, PitcherPosition pitcherPosition) {
        this.player = player;
        this.plateAppearances = 0;
        this.hitCount = 0;
        this.outCount = 0;
        this.pitcherPosition = pitcherPosition;
    }

    public float avg() {
        if (plateAppearances == 0) {
            return 0.0f;
        }
        return (float) hitCount / (float) plateAppearances;
    }

    public void increasePlateAppearances() {
        this.plateAppearances++;
    }

    public void increaseHitCount() {
        this.hitCount++;
    }

    public void increaseOutCount() {
        this.outCount++;
    }

    public boolean isStartingPitcher() {
        return pitcherPosition == PitcherPosition.SP;
    }

    public Integer getId() {
        return id;
    }

    public int getBatOrder() {
        return batOrder;
    }

    public int getPlayer() {
        return player;
    }

    public int getPlateAppearances() {
        return plateAppearances;
    }

    public int getHitCount() {
        return hitCount;
    }

    public int getOutCount() {
        return outCount;
    }

    @Override
    public String toString() {
        return "PlayerParticipatingInGame{" +
                "id=" + id +
                ", team_participating_in_game=" + team_participating_in_game +
                ", bat_order=" + batOrder +
                ", player=" + player +
                ", plateAppearances=" + plateAppearances +
                ", hitCount=" + hitCount +
                ", outCount=" + outCount +
                '}' + '\n';
    }
}
