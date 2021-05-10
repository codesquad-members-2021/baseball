package com.codesquad.team12.baseball.model;

import com.codesquad.team12.baseball.dto.PlayerDto;

public class Player {
    private Integer number;
    private String name;
    private Integer pa;
    private Integer hit;
    private Integer out;
    private Double average;

    public Player(Integer number, String name, Integer pa, Integer hit, Integer out, Double average) {
        this.number = number;
        this.name = name;
        this.pa = pa;
        this.hit = hit;
        this.out = out;
        this.average = average;
    }

    public static PlayerDto createPlayerDto(Player player) {
        return new PlayerDto(player.number, player.name);
    }
}
