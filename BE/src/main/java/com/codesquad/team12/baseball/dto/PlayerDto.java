package com.codesquad.team12.baseball.dto;

public class PlayerDto {
    private Integer number;
    private String name;

    public PlayerDto(Integer number, String name) {
        this.number = number;
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
