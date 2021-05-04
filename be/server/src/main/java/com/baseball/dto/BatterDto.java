package com.baseball.dto;

public class BatterDto {

    private final String name;
    private final Integer plateAppearances;
    private final Integer hit;
    private final Integer out;
    private final Float average;

    public BatterDto(String name, Integer plateAppearances, Integer hit, Integer out, Float average) {
        this.name = name;
        this.plateAppearances = plateAppearances;
        this.hit = hit;
        this.out = out;
        this.average = average;
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
}
