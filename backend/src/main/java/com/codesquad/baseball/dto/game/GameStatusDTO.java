package com.codesquad.baseball.dto.game;

import com.codesquad.baseball.domain.game.Game;

public class GameStatusDTO {
    private int inning;
    private boolean isTop;
    private int strikeCount;
    private int ballCount;
    private int outCount;
    private int currentHitter;
    private int nextHitter;
    private int currentPitcher;

    public GameStatusDTO(Builder builder) {
        this.inning = builder.inning;
        this.isTop = builder.isTop;
        this.strikeCount = builder.strikeCount;
        this.ballCount = builder.ballCount;
        this.outCount = builder.outCount;
        this.currentHitter = builder.currentHitter;
        this.nextHitter = builder.nextHitter;
        this.currentPitcher = builder.currentPitcher;
    }

    public static GameStatusDTO from(Game game) {
        return new Builder()
                .inning(game.currentInningNumber())
                .isTop(game.isTop())
                .strikeCount(game.getCurrentStrikeCount())
                .outCount(game.getCurrentOutCount())
                .currentHitter(game.currentHitter())
                .nextHitter(game.nextHitter())
                .currentPitcher(game.currentPitcher())
                .build();
    }

    public int getInning() {
        return inning;
    }

    public boolean isTop() {
        return isTop;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getOutCount() {
        return outCount;
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

    private static class Builder {
        private int inning;
        private boolean isTop;
        private int strikeCount;
        private int ballCount;
        private int outCount;
        private int currentHitter;
        private int nextHitter;
        private int currentPitcher;

        public Builder inning(int value) {
            inning = value;
            return this;
        }

        public Builder isTop(boolean value) {
            isTop = value;
            return this;
        }

        public Builder strikeCount(int value) {
            strikeCount = value;
            return this;
        }

        public Builder ballCount(int value) {
            ballCount = value;
            return this;
        }

        public Builder outCount(int value) {
            outCount = value;
            return this;
        }

        public Builder currentHitter(int value) {
            currentHitter = value;
            return this;
        }

        public Builder nextHitter(int value) {
            nextHitter = value;
            return this;
        }

        public Builder currentPitcher(int value) {
            currentPitcher = value;
            return this;
        }

        public GameStatusDTO build() {
            return new GameStatusDTO(this);
        }
    }
}
