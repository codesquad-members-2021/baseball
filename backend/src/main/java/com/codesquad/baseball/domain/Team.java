package com.codesquad.baseball.domain;

import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;

public class Team {
    @Id
    private Integer id;
    private String teamName;
    private Set<Player> players = new HashSet<>();

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public int numberOfPlayer() {
        return players.size();
    }

    public TeamParticipatingInGame createParticipantAsHomeTeam() {
        return new TeamParticipatingInGame(this.id, true);
    }

    public TeamParticipatingInGame createParticipantAsAwayTeam() {
        return new TeamParticipatingInGame(this.id, false);
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

    public Set<Player> getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", players=" + players +
                '}';
    }
}
