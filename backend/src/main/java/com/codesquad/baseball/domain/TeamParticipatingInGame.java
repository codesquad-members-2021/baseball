package com.codesquad.baseball.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.ArrayList;
import java.util.List;

public class TeamParticipatingInGame {

    @Id
    private int id;
    private int team;
    @MappedCollection(idColumn = "team_participating_in_game", keyColumn = "bat_order")
    private List<PlayerParticipatingInGame> players = new ArrayList<>();
    private boolean isHomeTeam;

    protected TeamParticipatingInGame() {
    }

    public TeamParticipatingInGame(int id, boolean isHomeTeam) {
        this.id = id;
        this.isHomeTeam = isHomeTeam;
    }

    public void addPlayer(Player player) {
        PlayerParticipatingInGame participatingPlayer = new PlayerParticipatingInGame(player.getId());
        players.add(participatingPlayer);
    }

    public int getId() {
        return id;
    }

    public boolean isHomeTeam() {
        return isHomeTeam;
    }

    public boolean isAwayTeam() {
        return !isHomeTeam;
    }

    public int sizeOfPlayer() {
        return players.size();
    }

    @Override
    public String toString() {
        return "TeamParticipatingInGame{" +
                "id=" + id +
                ", team=" + team +
                ", players=" + players +
                ", isHomeTeam=" + isHomeTeam +
                '}';
    }
}
