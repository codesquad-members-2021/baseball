package com.codesquad.team12.baseball.model;

import com.codesquad.team12.baseball.dto.InningDto;
import org.springframework.data.annotation.Id;

public class Inning {
    @Id
    private Long id;

    private String teamName;
    private Integer number;
    private Integer score;
    private Long gameId;

    public Inning(String teamName, Integer number, Integer score, Long gameId) {
        this.teamName = teamName;
        this.number = number;
        this.score = score;
        this.gameId = gameId;
    }

    public static InningDto createInningDto(Inning inning) {
        return new InningDto(inning.number, inning.score);
    }
}
