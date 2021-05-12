package com.codesquad.team12.baseball.model;

import com.codesquad.team12.baseball.dto.PlayerDto;

public class Player {
    private Integer number;
    private String name;
    private String position;

    public Player(Integer number, String name, String position) {
        this.number = number;
        this.name = name;
        this.position = position;
    }

    public static PlayerDto createPlayerDto(Player player) {
        return new PlayerDto(player.number, player.name, player.position);
    }

    public Integer getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }
}
