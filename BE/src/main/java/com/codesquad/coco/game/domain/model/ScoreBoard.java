package com.codesquad.coco.game.domain.model;

import org.springframework.data.annotation.Id;

import java.util.List;

public class ScoreBoard {

    @Id
    private Long id;

    private Long game;
    private String team;
    private List<Innings> innings;


    public ScoreBoard(Long id, Long game, String teamName, List<Innings> innings) {
        this.id = id;
        this.game = game;
        this.team = teamName;
        this.innings = innings;
    }

    public ScoreBoard(Long gameId, String team) {
        this.game = gameId;
        this.team = team;
    }

    public Innings updateScore(int round, int point) {
        //fixme : 만약 해당 이닝에 점수가 나지 않았다면? -> 리스트는 0이 되어야함함
        // fixme : 이닝이 끝날 때 마다 보내 줌 -> 해당 팀만?, 상대 팀도?
        return new Innings(this.id, point, round);
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


}
