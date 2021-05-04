package com.baseball.dto;

public class GameInfoDto {

    private final ScoreDto scores;
    private final InningsDto innings;
    private final PlayersDto awayPlayers;
    private final PlayersDto homePlayers;

    public GameInfoDto(ScoreDto scores, InningsDto innings, PlayersDto awayPlayers, PlayersDto homePlayers) {
        this.scores = scores;
        this.innings = innings;
        this.awayPlayers = awayPlayers;
        this.homePlayers = homePlayers;
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
}
