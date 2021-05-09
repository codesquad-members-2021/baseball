package com.codesquad.baseball.domain;

import org.springframework.data.annotation.Id;

public class Inning {

    private static final int INITIAL_SCORE = 0;

    @Id
    private int id;
    private int game;
    private int inningNumber;
    private int homeTeamScore;
    private int awayTeamScore;

    protected Inning() {
    }

    public Inning(int homeTeamScore, int awayTeamScore) {
        this.inningNumber = inningNumber;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
    }

    public static Inning createDefaultInning() {
        return new Inning(INITIAL_SCORE, INITIAL_SCORE);
    }

    public void addScore(TeamParticipatingInGame attackingTeam) {
        TeamType teamType = attackingTeam.getTeamType();
        if (teamType == TeamType.HOME) {
            addHomeTeamScore();
        } else if (teamType == TeamType.AWAY) {
            addAwayTeamScore();
        }
    }

    private void addHomeTeamScore() {
        homeTeamScore++;
    }

    private void addAwayTeamScore() {
        awayTeamScore++;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    @Override
    public String toString() {
        return "Inning{" +
                "id=" + id +
                ", game=" + game +
                ", inningNumber=" + inningNumber +
                ", homeTeamScore=" + homeTeamScore +
                ", awayTeamScore=" + awayTeamScore +
                '}';
    }
}
