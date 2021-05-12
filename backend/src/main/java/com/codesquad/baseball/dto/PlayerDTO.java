package com.codesquad.baseball.dto;

import com.codesquad.baseball.domain.team.Player;
import com.codesquad.baseball.domain.game.participant.PlayerParticipatingInGame;
import com.codesquad.baseball.domain.team.PlayerRole;

public class PlayerDTO {
    private int id;
    private String name;
    private PlayerRole role;
    private int batOrder;
    private int plateAppearances;
    private int hitCount;
    private int outCount;
    private float avg;

    public PlayerDTO(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.role = builder.role;
        this.batOrder = builder.batOrder;
        this.plateAppearances = builder.plateAppearances;
        this.hitCount = builder.hitCount;
        this.outCount = builder.outCount;
        this.avg = builder.avg;
    }

    public static PlayerDTO from(Player player, PlayerParticipatingInGame participant) {
        return new Builder()
                .id(player.getId())
                .name(player.getPlayerName())
                .role(player.getRole())
                .batOrder(participant.getBatOrder())
                .plateAppearances(participant.getPlateAppearances())
                .hitCount(participant.getHitCount())
                .outCount(participant.getOutCount())
                .avg(participant.avg())
                .build();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PlayerRole getRole() {
        return role;
    }

    public int getBatOrder() {
        return batOrder;
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

    public float getAvg() {
        return avg;
    }

    public static class Builder {
        private int id;
        private String name;
        private PlayerRole role;
        private int batOrder;
        private int plateAppearances;
        private int hitCount;
        private int outCount;
        private float avg;

        public Builder id(int value) {
            id = value;
            return this;
        }

        public Builder name(String value) {
            name = value;
            return this;
        }

        public Builder role(PlayerRole value) {
            role = value;
            return this;
        }

        public Builder batOrder(int value) {
            batOrder = value;
            return this;
        }

        public Builder plateAppearances(int value) {
            plateAppearances = value;
            return this;
        }

        public Builder hitCount(int value) {
            hitCount = value;
            return this;
        }

        public Builder outCount(int value) {
            outCount = value;
            return this;
        }

        public Builder avg(float value) {
            avg = value;
            return this;
        }

        public PlayerDTO build() {
            return new PlayerDTO(this);
        }
    }
}
