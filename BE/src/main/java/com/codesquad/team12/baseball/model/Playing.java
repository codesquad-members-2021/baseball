package com.codesquad.team12.baseball.model;

import org.springframework.data.annotation.Id;

public class Playing {
    @Id
    private Long id;

    private String teamName;
    private Integer playerNumber;
    private String playerName;
    private Integer pa;
    private Integer hit;
    private Integer out;
    private Double average;

    public Playing(Long id, String teamName, Integer playerNumber, String playerName, Integer pa, Integer hit, Integer out, Double average) {
        this.id = id;
        this.teamName = teamName;
        this.playerNumber = playerNumber;
        this.playerName = playerName;
        this.pa = pa;
        this.hit = hit;
        this.out = out;
        this.average = average;
    }
}
