package com.codesquad.baseball.domain;

import org.springframework.data.annotation.Id;

public class Game {

    @Id
    private Integer id;
    private String gameTitle;
    private int currentInning;
    private boolean isTop;
    private int currentStrikeCount;
    private int currentOutCount;
    private int currentBallCount;
    private int currentPitcher;
    private int currentHitter;
    private boolean isOccupied;
    private int homeTeam;
    private int awayTeam;

    protected Game() {
    }

    private Game(Builder builder) {
        this.id = builder.id;
        this.gameTitle = builder.gameTitle;
        this.currentInning = builder.currentInning;
        this.isTop = builder.isTop;
        this.currentStrikeCount = builder.currentStrikeCount;
        this.currentOutCount = builder.currentOutCount;
        this.currentBallCount = builder.currentBallCount;
        this.currentPitcher = builder.currentPitcher;
        this.currentHitter = builder.currentHitter;
        this.isOccupied = builder.isOccupied;
        this.homeTeam = builder.homeTeam.getId();
        this.awayTeam = builder.awayTeam.getId();
    }

    public static Game createGame(String gameTitle, Team homeTeam, Team awayTeam) {
        //@TODO 생각해보니 수비측, 공격측 투수가 필요함. 그리고 타순은 어떻게? 아마도 Game에서 PlayerParticipatingInGame을 리스트로 가지고 있어야 할듯?
        return new Builder()
                .gameTitle(gameTitle)
                .isOccupied(false)
                .currentStrikeCount(0)
                .currentBallCount(0)
                .currentOutCount(0)
                .isTop(true)
                .homeTeam(homeTeam)
                .awayTeam(awayTeam)
                .build();
    }

    public boolean isSameTitle(String title) {
        return this.gameTitle.equals(title);
    }

    public Integer getId() {
        return id;
    }

    public static class Builder {
        private Integer id;
        private String gameTitle;
        private int currentInning;
        private boolean isTop;
        private int currentStrikeCount;
        private int currentOutCount;
        private int currentBallCount;
        private int currentPitcher;
        private int currentHitter;
        private boolean isOccupied;
        private Team homeTeam;
        private Team awayTeam;

        public Builder id(Integer value) {
            id = value;
            return this;
        }

        public Builder gameTitle(String value) {
            gameTitle = value;
            return this;
        }

        public Builder currentInning(int value) {
            currentInning = value;
            return this;
        }

        public Builder isTop(boolean value) {
            isTop = value;
            return this;
        }

        public Builder currentStrikeCount(int value) {
            currentStrikeCount = value;
            return this;
        }

        public Builder currentOutCount(int value) {
            currentOutCount = value;
            return this;
        }

        public Builder currentBallCount(int value) {
            currentBallCount = value;
            return this;
        }

        public Builder currentPitcher(int value) {
            currentPitcher = value;
            return this;
        }

        public Builder currentHitter(int value) {
            currentHitter = value;
            return this;
        }

        public Builder isOccupied(boolean value) {
            isOccupied = value;
            return this;
        }

        public Builder homeTeam(Team value) {
            homeTeam = value;
            return this;
        }

        public Builder awayTeam(Team value) {
            awayTeam = value;
            return this;
        }

        public Game build() {
            return new Game(this);
        }
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", gameTitle='" + gameTitle + '\'' +
                ", currentInning=" + currentInning +
                ", isTop=" + isTop +
                ", currentStrikeCount=" + currentStrikeCount +
                ", currentOutCount=" + currentOutCount +
                ", currentBallCount=" + currentBallCount +
                ", currentPitcher=" + currentPitcher +
                ", currentHitter=" + currentHitter +
                ", isOccupied=" + isOccupied +
                ", homeTeam=" + homeTeam +
                ", awayTeam=" + awayTeam +
                '}';
    }
}
