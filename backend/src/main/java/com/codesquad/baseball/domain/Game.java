package com.codesquad.baseball.domain;

import com.codesquad.baseball.exceptions.TeamNotFoundException;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;

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
    private Set<TeamParticipatingInGame> teams = new HashSet<>();

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
        teams.add(builder.homeTeam);
        teams.add(builder.awayTeam);
    }

    public static Game createGame(String gameTitle, TeamParticipatingInGame homeTeam, TeamParticipatingInGame awayTeam) {
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

    public boolean isAvailable() {
        return !isOccupied;
    }

    public boolean isSameTitle(String title) {
        return this.gameTitle.equals(title);
    }

    public TeamParticipatingInGame homeTeam() {
        return teams.stream()
                .filter(TeamParticipatingInGame::isHomeTeam)
                .findFirst()
                .orElseThrow(() -> new TeamNotFoundException(TeamNotFoundException.HOME_TEAM_NOT_FOUND));
    }

    public TeamParticipatingInGame awayTeam() {
        return teams.stream()
                .filter(TeamParticipatingInGame::isAwayTeam)
                .findFirst()
                .orElseThrow(() -> new TeamNotFoundException(TeamNotFoundException.AWAY_TEAM_NOT_FOUND));
    }

    public int sizeOfHomeTeam() {
        return homeTeam().sizeOfPlayer();
    }

    public int sizeOfAwayTeam() {
        return awayTeam().sizeOfPlayer();
    }

    public Integer getId() {
        return id;
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
                ", teams=" + teams +
                '}';
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
        private TeamParticipatingInGame homeTeam;
        private TeamParticipatingInGame awayTeam;

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

        public Builder homeTeam(TeamParticipatingInGame value) {
            homeTeam = value;
            return this;
        }

        public Builder awayTeam(TeamParticipatingInGame value) {
            awayTeam = value;
            return this;
        }

        public Game build() {
            return new Game(this);
        }
    }
}
