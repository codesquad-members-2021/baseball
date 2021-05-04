package com.baseball.dto;

public class BatterDto {

    private String name;
    private Integer plateAppearances;
    private Integer hit;
    private Integer out;
    private Float average;

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

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPlateAppearances() {
        return plateAppearances;
    }

    public void setPlateAppearances(Integer plateAppearances) {
        this.plateAppearances = plateAppearances;
    }

    public Integer getHit() {
        return hit;
    }

    public void setHit(Integer hit) {
        this.hit = hit;
    }

    public Integer getOut() {
        return out;
    }

    public void setOut(Integer out) {
        this.out = out;
    }

    public Float getAverage() {
        return average;
    }

    public void setAverage(Float average) {
        this.average = average;
    }
}
