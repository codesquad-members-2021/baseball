package com.codesquad.team12.baseball.model;

import com.codesquad.team12.baseball.dto.response.PlayingDto;
import org.springframework.data.annotation.Id;

public class Playing {
    @Id
    private Long id;

    private String teamName;
    private Integer playerNumber;
    private String playerName;
    private String position;
    private Integer pa;
    private Integer hit;
    private Integer out;
    private Double average;
    private Long gameId;

    private Playing() {
    }

    public Playing(String teamName, Integer playerNumber, String playerName, String position, Long gameId) {
        this.teamName = teamName;
        this.playerNumber = playerNumber;
        this.playerName = playerName;
        this.position = position;
        this.gameId = gameId;
        this.pa = 0;
        this.hit = 0;
        this.out = 0;
        this.average = 0.0;
    }

    public Playing(Long id, String teamName, Integer playerNumber, String playerName, String position, Integer pa, Integer hit, Integer out, Double average, Long gameId) {
        this.id = id;
        this.teamName = teamName;
        this.playerNumber = playerNumber;
        this.playerName = playerName;
        this.position = position;
        this.pa = pa;
        this.hit = hit;
        this.out = out;
        this.average = average;
        this.gameId = gameId;
    }

    public static PlayingDto createPlayingDto(Playing playing) {
        return new PlayingDto(playing.playerName, playing.position, playing.pa, playing.hit, playing.out, playing.average);
    }

    public Integer getPlayerNumber() {
        return playerNumber;
    }
}
