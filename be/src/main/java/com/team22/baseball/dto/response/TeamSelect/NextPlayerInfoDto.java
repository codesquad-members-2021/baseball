package com.team22.baseball.dto.response.TeamSelect;

public class NextPlayerInfoDto {

    private String name;

    private int uniformNumber;

    private int plateAppearance;

    private int hits;

    public NextPlayerInfoDto(String name, int uniformNumber, int plateAppearance, int hits) {
        this.name = name;
        this.uniformNumber = uniformNumber;
        this.plateAppearance = plateAppearance;
        this.hits = hits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUniformNumber() {
        return uniformNumber;
    }

    public void setUniformNumber(int uniformNumber) {
        this.uniformNumber = uniformNumber;
    }

    public int getPlateAppearance() {
        return plateAppearance;
    }

    public void setPlateAppearance(int plateAppearance) {
        this.plateAppearance = plateAppearance;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }
}
