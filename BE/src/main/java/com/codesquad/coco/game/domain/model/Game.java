package com.codesquad.coco.game.domain.model;

import com.codesquad.coco.player.domain.UserType;
import com.codesquad.coco.team.domain.Team;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;

public class Game {

    @Id
    private Long id;

    private Team away;

    private Team home;

    private Set<ScoreBoard> scoreBoard = new HashSet<>();

    private UserType userType;

    public Game(Team away, Team home, UserType userType) {
        this.away = away;
        this.home = home;
        this.userType = userType;
    }

    public Game(Long id, Team away, Team home, Set<ScoreBoard> scoreBoard, UserType userType) {
        this.id = id;
        this.away = away;
        this.home = home;
        this.scoreBoard = scoreBoard;
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public Team getAway() {
        return away;
    }

    public Team getHome() {
        return home;
    }

    public UserType getUserType() {
        return userType;
    }

    public String awayTeamName() {
        return away.getName();
    }

    public String homeTeamName() {
        return home.getName();
    }

    public void addScoreBoard(ScoreBoard board) {
        scoreBoard.add(board);
    }

    public Set<ScoreBoard> getScoreBoard() {
        return scoreBoard;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", away=" + away +
                ", home=" + home +
                ", scoreBoard=" + scoreBoard +
                ", userType='" + userType + '\'' +
                '}';
    }
}
