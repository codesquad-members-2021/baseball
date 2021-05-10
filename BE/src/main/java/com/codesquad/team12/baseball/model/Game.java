package com.codesquad.team12.baseball.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.HashMap;
import java.util.Map;

public class Game {
    @Id
    private Long id;

    private Integer homeScore;
    private Integer awayScore;
    private boolean isEnd;
    private Long homeId;
    private Long awayId;

    @MappedCollection(keyColumn = "id")
    private Map<Long, Inning> innings = new HashMap<>();

    @MappedCollection(keyColumn = "id")
    private Map<Long, Playing> playings = new HashMap<>();

    public Game(Long id, Integer homeScore, Integer awayScore, boolean isEnd, Long homeId, Long awayId) {
        this.id = id;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.isEnd = isEnd;
        this.homeId = homeId;
        this.awayId = awayId;
    }
}
