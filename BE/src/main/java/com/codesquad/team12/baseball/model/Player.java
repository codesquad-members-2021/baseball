package com.codesquad.team12.baseball.model;

import org.springframework.data.annotation.Id;

public class Player {
    @Id
    private Long id;

    private Integer number;
    private String name;
    private Integer pa;
    private Integer hit;
    private Integer out;
    private Double average;

    public Player(Long id, Integer number, String name, Integer pa, Integer hit, Integer out, Double average) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.pa = pa;
        this.hit = hit;
        this.out = out;
        this.average = average;
    }
}
