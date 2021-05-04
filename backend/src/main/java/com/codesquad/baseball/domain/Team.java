package com.codesquad.baseball.domain;

import org.springframework.data.annotation.Id;

public class Team {
    @Id
    private Integer id;
    private String teamName;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public boolean isSameName(String teamName) {
        return this.teamName.equals(teamName);
    }

    public boolean isSameId(Team otherTeam) {
        return id.equals(otherTeam.id);
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}
