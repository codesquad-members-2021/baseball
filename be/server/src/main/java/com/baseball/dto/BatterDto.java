package com.baseball.dto;

import com.baseball.domain.Batter;

public class BatterDto {

    private final String name;
    private final Integer plateAppearances;
    private final Integer hit;
    private final Integer out;
    private final Float average;

    private BatterDto(Builder builder) {
        this.name = builder.name;
        this.plateAppearances = builder.plateAppearances;
        this.hit = builder.hit;
        this.out = builder.out;
        this.average = builder.average;
    }

    private static class Builder {
        private String name;
        private Integer plateAppearances;
        private Integer hit;
        private Integer out;
        private Float average;

        private Builder name(String name) {
            this.name = name;
            return this;
        }

        private Builder plateAppearances(Integer plateAppearances) {
            this.plateAppearances = plateAppearances;
            return this;
        }

        private Builder hit(Integer hit) {
            this.hit = hit;
            return this;
        }

        private Builder out(Integer out) {
            this.out = out;
            return this;
        }

        private Builder average(Float average) {
            this.average = average;
            return this;
        }

        private BatterDto build() {
            return new BatterDto(this);
        }
    }

    public String getName() {
        return name;
    }

    public Integer getPlateAppearances() {
        return plateAppearances;
    }

    public Integer getHit() {
        return hit;
    }

    public Integer getOut() {
        return out;
    }

    public Float getAverage() {
        return average;
    }

    public static BatterDto from(Batter batter) {
        Builder builder = new Builder()
                .name(batter.getName())
                .plateAppearances(batter.getPlateAppearances())
                .hit(batter.getHit())
                .out(batter.getOut())
                .average(batter.getAverage());
        return builder.build();
    }
}
