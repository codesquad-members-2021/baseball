package com.codesquad.baseball.dto.game;

import com.codesquad.baseball.domain.game.Game;
import com.codesquad.baseball.domain.game.GameState;
import com.codesquad.baseball.domain.game.PlayType;
import com.codesquad.baseball.domain.game.pitch.PitchResult;
import com.codesquad.baseball.domain.team.TeamType;

import java.util.List;

public class PitchResultDTO {
    private int pitcherId;
    private int hitterId;
    private PlayType playType;
    private int firstBase;
    private int secondBase;
    private int thirdBase;
    private List<Integer> backHome;
    private int pointsEarned;
    private GameState gameState;
    private TeamType winningTeam;

    public PitchResultDTO(Builder builder) {
        this.pitcherId = builder.pitcherId;
        hitterId = builder.hitterId;
        this.playType = builder.playType;
        this.firstBase = builder.firstBase;
        this.secondBase = builder.secondBase;
        this.thirdBase = builder.thirdBase;
        this.backHome = builder.backHome;
        this.pointsEarned = builder.pointsEarned;
        this.gameState = builder.gameState;
        this.winningTeam = builder.winningTeam;
    }

    public static PitchResultDTO from(PitchResult pitchResult, Game game) {
        return new Builder()
                .pitcherId(pitchResult.getHistory().getPitcher())
                .hitterId(pitchResult.getHistory().getHitter())
                .playType(pitchResult.getPlayType())
                .firstBase(game.firstBaseRunner())
                .secondBase(game.secondBaseRunner())
                .thirdBase(game.thirdBaseRunner())
                .backHome(pitchResult.getBackHomeRunners())
                .pointsEarned(pitchResult.numberOfRunners())
                .gameState(pitchResult.getGameState())
                .winningTeam(game.winner())
                .build();
    }

    public int getPitcherId() {
        return pitcherId;
    }

    public int getHitterId() {
        return hitterId;
    }

    public PlayType getPlayType() {
        return playType;
    }

    public int getFirstBase() {
        return firstBase;
    }

    public int getSecondBase() {
        return secondBase;
    }

    public int getThirdBase() {
        return thirdBase;
    }

    public List<Integer> getBackHome() {
        return backHome;
    }

    public int getPointsEarned() {
        return pointsEarned;
    }

    public GameState getGameState() {
        return gameState;
    }

    public TeamType getWinningTeam() {
        return winningTeam;
    }

    public static class Builder {
        private int pitcherId;
        private int hitterId;
        private PlayType playType;
        private int firstBase;
        private int secondBase;
        private int thirdBase;
        private List<Integer> backHome;
        private int pointsEarned;
        private GameState gameState;
        private TeamType winningTeam;

        public Builder pitcherId(int value) {
            pitcherId = value;
            return this;
        }

        public Builder hitterId(int value) {
            hitterId = value;
            return this;
        }

        public Builder playType(PlayType value) {
            playType = value;
            return this;
        }

        public Builder firstBase(int value) {
            firstBase = value;
            return this;
        }

        public Builder secondBase(int value) {
            secondBase = value;
            return this;
        }

        public Builder thirdBase(int value) {
            thirdBase = value;
            return this;
        }

        public Builder backHome(List<Integer> value) {
            backHome = value;
            return this;
        }

        public Builder pointsEarned(int value) {
            pointsEarned = value;
            return this;
        }

        public Builder gameState(GameState value) {
            gameState = value;
            return this;
        }

        public Builder winningTeam(TeamType value) {
            winningTeam = value;
            return this;
        }

        public PitchResultDTO build() {
            return new PitchResultDTO(this);
        }
    }
}
