package com.codesquad.coco.game.domain.model;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {

    @Id
    private Long id;

    private Long game;
    private String team;
    private List<Innings> innings;

    public ScoreBoard(Long id, Long game, String team, List<Innings> innings) {
        this.id = id;
        this.game = game;
        this.team = team;
        this.innings = innings;
    }

    public Innings updateScore(int round, int point) {
        return new Innings(this.id, point, round);
    }

    public void addInnings(Innings inning) {
        innings.add(inning);
    }

    public Long getId() {
        return id;
    }

    public Long getGameId() {
        return game;
    }

    public String teamName() {
        return team;
    }

    public String getTeam() {
        return team;
    }

    public List<Innings> getInnings() {
        return innings;
    }

    @Override
    public String toString() {
        return "ScoreBoard{" +
                "id=" + id +
                ", gameId=" + game +
                ", team=" + team +
                ", innings=" + innings +
                '}';
    }

    public static class Builder {
        private Long id;
        private Long game;
        private String team;
        private List<Innings> innings = new ArrayList<>();

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder game(Long val) {
            game = val;
            return this;
        }

        public Builder team(String val) {
            team = val;
            return this;
        }

        public Builder innings(List<Innings> val) {
            innings = val;
            return this;
        }

        public ScoreBoard build() {
            return new ScoreBoard(id, game, team, innings);
        }
    }

}
