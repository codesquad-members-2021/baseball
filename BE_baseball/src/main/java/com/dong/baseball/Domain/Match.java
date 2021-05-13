package com.dong.baseball.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.ArrayList;
import java.util.List;

public class Match {

    @Id
    private Long id;
    private String home;
    private String away;

    @MappedCollection(keyColumn = "match_id")
    List<Board> gameBoards = new ArrayList<>();

    public void addGameBoards(Board... boards) {
        for (Board board : boards) {
            this.gameBoards.add(board);
        }
    }

    public List<Board> getGameBoards() {
        return gameBoards;
    }

    public Long getId() {
        return id;
    }

    public String getHome() {
        return home;
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
                "id=" + id +
                ", home='" + home + '\'' +
                ", away='" + away + '\'' +
                ", gameBoards=" + gameBoards +
                '}';
    }
}
