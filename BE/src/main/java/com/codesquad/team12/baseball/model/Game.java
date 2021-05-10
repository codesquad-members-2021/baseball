package com.codesquad.team12.baseball.model;

import com.codesquad.team12.baseball.dto.GameDto;
import com.codesquad.team12.baseball.dto.TeamDto;
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
    private String homeName;
    private String awayName;

//    @MappedCollection(keyColumn = "id")
//    private Map<Long, Inning> innings = new HashMap<>();
//
//    @MappedCollection(keyColumn = "id")
//    private Map<Long, Playing> playings = new HashMap<>();


    public Game(Long id, Integer homeScore, Integer awayScore, boolean isEnd, String homeName, String awayName) {
        this.id = id;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.isEnd = isEnd;
        this.homeName = homeName;
        this.awayName = awayName;
    }

    public static GameDto of(Game game) {
        TeamDto home = Team.of(new Team(game.homeName, false));
        TeamDto away = Team.of(new Team(game.awayName, false));
        return new GameDto(game.id, home, away);
    }
}
