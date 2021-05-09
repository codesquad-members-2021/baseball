package com.baseball.dto;


import com.baseball.domain.match.Match;
import com.baseball.domain.team.Team;
import com.baseball.domain.team.Teams;

public class GameInfoDto {

    private final ScoreDto scores;
    private final InningsDto innings;
    private final PlayersDto awayPlayers;
    private final PlayersDto homePlayers;

    private GameInfoDto(Builder builder) {
        this.scores = builder.scores;
        this.innings = builder.innings;
        this.awayPlayers = builder.awayPlayers;
        this.homePlayers = builder.homePlayers;
    }

    private static class Builder {
        private ScoreDto scores;
        private InningsDto innings;
        private PlayersDto awayPlayers;
        private PlayersDto homePlayers;

        private Builder scores(ScoreDto scores) {
            this.scores = scores;
            return this;
        }

        private Builder innings(InningsDto innings) {
            this.innings = innings;
            return this;
        }

        private Builder awayPlayers(PlayersDto awayPlayers) {
            this.awayPlayers = awayPlayers;
            return this;
        }

        private Builder homePlayers(PlayersDto homePlayers) {
            this.homePlayers = homePlayers;
            return this;
        }

        private GameInfoDto build() {
            return new GameInfoDto(this);
        }
    }

    public ScoreDto getScores() {
        return scores;
    }

    public InningsDto getInnings() {
        return innings;
    }

    public PlayersDto getAwayPlayers() {
        return awayPlayers;
    }

    public PlayersDto getHomePlayers() {
        return homePlayers;
    }

    public static GameInfoDto from(Match match) {
        Teams teams = match.getTeams();
        Team awayTeam = teams.getAwayTeam();
        Team homeTeam = teams.getHomeTeam();
        Builder builder = new Builder()
                .scores(ScoreDto.from(awayTeam, homeTeam))
                .innings(InningsDto.from(awayTeam, homeTeam))
                .awayPlayers(PlayersDto.from(awayTeam.getPlayers()))
                .homePlayers(PlayersDto.from(homeTeam.getPlayers()));
        return builder.build();
    }
}
