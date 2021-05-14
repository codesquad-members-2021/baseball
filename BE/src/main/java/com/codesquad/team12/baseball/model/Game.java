package com.codesquad.team12.baseball.model;

import com.codesquad.team12.baseball.dto.response.GameDto;
import com.codesquad.team12.baseball.dto.response.ScoreDto;
import com.codesquad.team12.baseball.dto.response.ScoreTeamDto;
import com.codesquad.team12.baseball.dto.response.TeamDto;
import org.springframework.data.annotation.Id;

import java.util.Random;

public class Game {
    @Id
    private Long id;

    private Integer homeScore;
    private Integer awayScore;
    private boolean isEnd;
    private String homeName;
    private String awayName;

    public Game(Long id, Integer homeScore, Integer awayScore, boolean isEnd, String homeName, String awayName) {
        this.id = id;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.isEnd = isEnd;
        this.homeName = homeName;
        this.awayName = awayName;
    }

    public static GameDto createGameDto(Game game) {
        boolean[] isPlayings = new boolean[]{true, false, false, false, false, false, true, false, false, true};
        Random random = new Random();

        boolean isPlaying = isPlayings[random.nextInt(isPlayings.length)];
        TeamDto home = Team.createTeamDto(new Team(game.homeName, isPlaying));

        isPlaying = isPlayings[random.nextInt(isPlayings.length)];
        TeamDto away = Team.createTeamDto(new Team(game.awayName, isPlaying));

        return new GameDto(game.id, home, away);
    }

    public String getHomeName() {
        return homeName;
    }

    public String getAwayName() {
        return awayName;
    }

    public static ScoreDto createScoreDto(Game game) {
        ScoreTeamDto home = new ScoreTeamDto(game.homeName, null);
        ScoreTeamDto away = new ScoreTeamDto(game.awayName, null);

        return new ScoreDto(home, away);
    }

}
