package com.baseball.dto;

import com.baseball.domain.player.Pitcher;

public class PitcherDto {

    private final String name;
    private final Integer numberOfPitching;
    private final Integer hit;
    private final Integer baseOnBalls;
    private final Float innings;

    private PitcherDto(Builder builder) {
        this.name = builder.name;
        this.numberOfPitching = builder.numberOfPitching;
        this.hit = builder.hit;
        this.baseOnBalls = builder.baseOnBalls;
        this.innings = builder.innings;
    }

    private static class Builder {
        private String name;
        private Integer numberOfPitching;
        private Integer hit;
        private Integer baseOnBalls;
        private Float innings;

        private Builder name(String name) {
            this.name = name;
            return this;
        }

        private Builder numberOfPitching(Integer numberOfPitching) {
            this.numberOfPitching = numberOfPitching;
            return this;
        }

        private Builder hit(Integer hit) {
            this.hit = hit;
            return this;
        }

        private Builder baseOnBalls(Integer baseOnBalls) {
            this.baseOnBalls = baseOnBalls;
            return this;
        }

        private Builder innings(Float innings) {
            this.innings = innings;
            return this;
        }

        private PitcherDto build() {
            return new PitcherDto(this);
        }
    }

    public String getName() {
        return name;
    }

    public Integer getNumberOfPitching() {
        return numberOfPitching;
    }

    public Integer getHit() {
        return hit;
    }

    public Integer getBaseOnBalls() {
        return baseOnBalls;
    }

    public Float getInnings() {
        return innings;
    }

    public static PitcherDto from(Pitcher pitcher) {
        Builder builder = new Builder()
                .name(pitcher.getName())
                .numberOfPitching(pitcher.getNumberOfPitching())
                .hit(pitcher.getHit())
                .baseOnBalls(pitcher.getBaseOnBalls())
                .innings(pitcher.getInnings());
        return builder.build();
    }
}
