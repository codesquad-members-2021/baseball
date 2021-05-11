package com.codesquad.team12.baseball.model;

import com.codesquad.team12.baseball.dto.InningDto;

public class Inning {
    private Integer number;
    private Integer score;

    public Inning(Integer number, Integer score) {
        this.number = number;
        this.score = score;
    }

    public static InningDto createInningDto(Inning inning) {
        return new InningDto(inning.number, inning.score);
    }
}
