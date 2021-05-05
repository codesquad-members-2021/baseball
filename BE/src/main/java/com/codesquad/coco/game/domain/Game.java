package com.codesquad.coco.game.domain;

import com.codesquad.coco.team.domain.Team;
import org.springframework.data.annotation.Id;

public class Game {

    @Id
    private Long id;

    private Team away;

    private Team home;

    private String userType;

    public Game(Long id, Team away, Team home, String userType) {
        this.id = id;
        this.away = away;
        this.home = home;
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

    public String getUserType() {
        return userType;
    }

    public String awayTeamName() {
        return away.getName();
    }

    public String homeTeamName() {
        return home.getName();
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", away=" + away +
                ", home=" + home +
                ", userType='" + userType + '\'' +
                '}';
    }
}
