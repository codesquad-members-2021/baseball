package com.dong.baseball.Domain;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Match {
    @Id
    private Long matchId;

    private String home;
    private String away;

    List<Board> gameBoards = new ArrayList<>();

    public void addGameBoards(Board... boards) {
        for (Board board : boards) {
            this.gameBoards.add(board);
        }
    }

    public List<Board> getGameBoards() {
        return gameBoards;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    @Override
    public String toString() {
        return "Match{" +
                "matchId=" + matchId +
                ", home='" + home + '\'' +
                ", away='" + away + '\'' +
                ", gameBoards=" + gameBoards +
                '}';
    }
}
