package com.baseball.domain;

import com.baseball.domain.player.Players;

public class GameInfo {
    private final Score scores;
    private final Innings innings;
    private final Players awayPlayers;
    private final Players homePlayers;

    public GameInfo(Score scores, Innings innings, Players awayPlayers, Players homePlayers) {
        this.scores = scores;
        this.innings = innings;
        this.awayPlayers = awayPlayers;
        this.homePlayers = homePlayers;
    }

    public Score getScores() {
        return scores;
    }

    public Innings getInnings() {
        return innings;
    }

    public Players getAwayPlayers() {
        return awayPlayers;
    }

    public Players getHomePlayers() {
        return homePlayers;
    }
}
