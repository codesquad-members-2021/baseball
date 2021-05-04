package com.baseball.dto;

public class GameInfoDto {

    private ScoreDto scores;
    private InningsDto innings;
    private PlayersDto awayPlayers;
    private PlayersDto homePlayers;

    public GameInfoDto(ScoreDto scores, InningsDto innings, PlayersDto awayPlayers, PlayersDto homePlayers) {
        this.scores = scores;
        this.innings = innings;
        this.awayPlayers = awayPlayers;
        this.homePlayers = homePlayers;
    }

    public ScoreDto getScores() {
        return scores;
    }

    public void setScores(ScoreDto scores) {
        this.scores = scores;
    }

    public InningsDto getInnings() {
        return innings;
    }

    public void setInnings(InningsDto innings) {
        this.innings = innings;
    }

    public PlayersDto getAwayPlayers() {
        return awayPlayers;
    }

    public void setAwayPlayers(PlayersDto awayPlayers) {
        this.awayPlayers = awayPlayers;
    }

    public PlayersDto getHomePlayers() {
        return homePlayers;
    }

    public void setHomePlayers(PlayersDto homePlayers) {
        this.homePlayers = homePlayers;
    }
}
