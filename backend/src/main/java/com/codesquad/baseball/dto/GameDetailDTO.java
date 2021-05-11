package com.codesquad.baseball.dto;

import com.codesquad.baseball.domain.Game;

public class GameDetailDTO {
    private TeamDetailDTO homeTeam;
    private TeamDetailDTO awayTeam;
    private GameStatus gameStatus;

    public GameDetailDTO(TeamDetailDTO homeTeam, TeamDetailDTO awayTeam, GameStatus gameStatus) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.gameStatus = gameStatus;
    }

    public static GameDetailDTO from(TeamDetailDTO homeTeam, TeamDetailDTO awayTeam, Game game) {
        return new GameDetailDTO(homeTeam, awayTeam, GameStatus.from(game));
    }

    public TeamDetailDTO getHomeTeam() {
        return homeTeam;
    }

    public TeamDetailDTO getAwayTeam() {
        return awayTeam;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public static class GameStatus {
        private int currentHitter;
        private int nextHitter;
        private int currentPitcher;

        public GameStatus(int currentHitter, int nextHitter, int currentPitcher) {
            this.currentHitter = currentHitter;
            this.nextHitter = nextHitter;
            this.currentPitcher = currentPitcher;
        }

        public static GameStatus from(Game game) {
            return new GameStatus(game.currentHitter(), game.nextHitter(), game.currentPitcher());
        }

        public int getCurrentHitter() {
            return currentHitter;
        }

        public int getNextHitter() {
            return nextHitter;
        }

        public int getCurrentPitcher() {
            return currentPitcher;
        }
    }
}
