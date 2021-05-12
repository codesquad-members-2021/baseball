package com.codesquad.baseball.domain;

import org.springframework.data.annotation.Id;

public class Player {

    @Id
    private Integer id;
    private int uniformNumber;
    private String playerName;
    private PlayerRole role;
    private int team;

    protected Player() {
    }

    private Player(Builder builder) {
        this.id = builder.id;
        this.uniformNumber = builder.uniformNumber;
        this.playerName = builder.playerName;
        this.role = builder.role;
        this.team = builder.team;
    }

    public boolean isPitcher() {
        return role == PlayerRole.PITCHER;
    }

    public boolean isHitter() {
        return role == PlayerRole.HITTER;
    }

    public Integer getId() {
        return id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public PlayerRole getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", uniformNumber=" + uniformNumber +
                ", playerName='" + playerName + '\'' +
                ", role=" + role +
                ", team=" + team +
                '}';
    }

    public static class Builder {
        private Integer id;
        private int uniformNumber;
        private String playerName;
        private PlayerRole role;
        private int team;

        public Builder id(int value) {
            id = value;
            return this;
        }

        public Builder uniformNumber(int value) {
            uniformNumber = value;
            return this;
        }

        public Builder playerName(String value) {
            playerName = value;
            return this;
        }

        public Builder role(PlayerRole value) {
            role = value;
            return this;
        }

        public Builder team(int value) {
            team = value;
            return this;
        }

        public Player build() {
            return new Player(this);
        }
    }
}
