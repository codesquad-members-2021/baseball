package com.codesquad.baseball.domain;

import com.codesquad.baseball.exceptions.PlayerNotFoundException;
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
    private int currentHitter = -1;
    private int currentPitcher = -1;

    protected TeamParticipatingInGame() {
    }

    public TeamParticipatingInGame(int id, boolean isHomeTeam) {
        this.id = id;
        this.isHomeTeam = isHomeTeam;
    }

    public void initializeTeam() {
        currentHitter = players.get(0).getBatOrder();
        currentPitcher = findStartingPitcher().getBatOrder();
    }

    private PlayerParticipatingInGame findStartingPitcher() {
        return players.stream()
                .filter(PlayerParticipatingInGame::isStartingPitcher)
                .findFirst()
                .orElseThrow(() -> new PlayerNotFoundException(PlayerNotFoundException.FIND_STARTING_PITCHER_FAILED));
    }

    public int changeHitter() {
        currentHitter++;
        if (players.size() == currentHitter) {
            currentHitter = 0;
        }
        return currentHitter;
    }

    public void addPlayer(Player player) {
        PlayerParticipatingInGame participatingPlayer = new PlayerParticipatingInGame(player.getId());
        players.add(participatingPlayer);
    }

    public void addPlayer(Player player, PitcherPosition pitcherPosition) {
        PlayerParticipatingInGame participatingPlayer = new PlayerParticipatingInGame(player.getId(), pitcherPosition);
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

    public PlayerParticipatingInGame firstHitter() {
        return players.get(0);
    }

    public int getCurrentHitter() {
        return currentHitter;
    }

    public int getCurrentPitcher() {
        return currentPitcher;
    }

    public void setCurrentHitter(int currentHitter) {
        this.currentHitter = currentHitter;
    }

    public void setCurrentPitcher(int currentPitcher) {
        this.currentPitcher = currentPitcher;
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
