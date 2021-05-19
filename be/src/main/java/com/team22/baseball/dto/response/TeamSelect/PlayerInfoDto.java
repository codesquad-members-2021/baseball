package com.team22.baseball.dto.response.TeamSelect;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerInfoDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("uniform_number")
    private int uniformNumber;

    @JsonIgnore   // 왜인지는 모르겠지만 boolean 형식의 자료형은 Json필드가 하다 더 생김... 이건 pitcher이름으로 생김 그래서 무시옵션
    private boolean isPitcher;

    public PlayerInfoDto(String name, int uniformNumber, boolean isPitcher) {
        this.name = name;
        this.uniformNumber = uniformNumber;
        this.isPitcher = isPitcher;
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

    public boolean isPitcher() {
        return isPitcher;
    }

    public void setPitcher(boolean pitcher) {
        isPitcher = pitcher;
    }

    @Override
    public String toString() {
        return "PlayerInfoDto{" +
                "name='" + name + '\'' +
                ", uniformNumber=" + uniformNumber +
                ", isPitcher=" + isPitcher +
                '}';
    }
}
