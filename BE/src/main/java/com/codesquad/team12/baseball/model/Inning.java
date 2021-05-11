package com.codesquad.team12.baseball.model;

import com.codesquad.team12.baseball.dto.InningDto;

public class Inning {
    private String teamName;
    private Integer number;
    private Integer score;

    public Inning(String teamName, Integer number, Integer score) {
        this.teamName = teamName;
        this.number = number;
        this.score = score;
    }

    public static InningDto createInningDto(Inning inning) {
        return new InningDto(inning.number, inning.score);
    }
}
