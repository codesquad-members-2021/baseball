package com.codesquad.coco.game.domain;

import com.codesquad.coco.team.domain.Team;
import org.springframework.data.annotation.Id;

import java.util.List;

public class ScoreBoard {

    @Id
    private Long id;

    private Game game;
    private Team team;
    private List<Innings> innings;

    public Long getId() {
        return id;
    }

    public Game getGame() {
        return game;
    }

    public Team getTeam() {
        return team;
    }

    public List<Innings> getInnings() {
        return innings;
    }

    @Override
    public String toString() {
        return "ScoreBoard{" +
                "id=" + id +
                ", game=" + game +
                ", team=" + team +
                ", innings=" + innings +
                '}';
    }
}
