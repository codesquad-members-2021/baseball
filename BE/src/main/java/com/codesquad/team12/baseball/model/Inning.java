package com.codesquad.team12.baseball.model;

import org.springframework.data.annotation.Id;

public class Inning {
    @Id
    private Long id;

    private Integer number;
    private Integer score;

    public Inning(Long id, Integer number, Integer score) {
        this.id = id;
        this.number = number;
        this.score = score;
    }
}
