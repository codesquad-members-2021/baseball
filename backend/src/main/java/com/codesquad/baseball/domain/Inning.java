package com.codesquad.baseball.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.ArrayList;
import java.util.List;

public class Inning {

    private static final int INITIAL_SCORE = 0;

    @Id
    private Integer id;
    private int game;
    private int inningNumber;
    private int homeTeamScore;
    private int awayTeamScore;
    @MappedCollection(idColumn = "inning", keyColumn = "history_order")
    private List<History> histories = new ArrayList<>();

    protected Inning() {
    }

    public Inning(int homeTeamScore, int awayTeamScore) {
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

    public History createHistory(PlayType playType, int strikeCount, int ballCount, int pitcher, int hitter, int earnedScore) {
        return new History(playType, strikeCount, ballCount, pitcher, hitter, earnedScore);
    }

    public void addHistory(History history) {
        histories.add(history);
    }

    public List<History> showHistory() {
        return histories;
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

    public int getInningNumber() {
        return inningNumber + 1;
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
