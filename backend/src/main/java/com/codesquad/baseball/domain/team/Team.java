package com.codesquad.baseball.domain.team;

import com.codesquad.baseball.domain.game.participant.TeamParticipatingInGame;
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

    public TeamParticipatingInGame createParticipantAsHomeTeam() {
        return new TeamParticipatingInGame(TeamType.HOME, this.id);
    }

    public TeamParticipatingInGame createParticipantAsAwayTeam() {
        return new TeamParticipatingInGame(TeamType.AWAY, this.id);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public int numberOfPlayer() {
        return players.size();
    }


    public boolean isSameTeam(String teamName) {
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

    public String getTeamName() {
        return teamName;
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
