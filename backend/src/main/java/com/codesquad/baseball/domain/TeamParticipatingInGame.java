package com.codesquad.baseball.domain;

import com.codesquad.baseball.exceptions.PlayerNotFoundException;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.ArrayList;
import java.util.List;

public class TeamParticipatingInGame {

    private static final int BAT_ORDER_OF_FIRST_HITTER = 0;

    @Id
    private int id;
    private int team;
    @MappedCollection(idColumn = "team_participating_in_game", keyColumn = "bat_order")
    private List<PlayerParticipatingInGame> players = new ArrayList<>();
    private TeamType teamType;
    private int currentHitter = -1;
    private int currentPitcher = -1;

    protected TeamParticipatingInGame() {
    }

    public TeamParticipatingInGame(int id, TeamType teamType) {
        this.id = id;
        this.teamType = teamType;
    }

    public void initializeTeam() {
        PlayerParticipatingInGame firstHitter = players.get(BAT_ORDER_OF_FIRST_HITTER);
        firstHitter.increasePlateAppearances();
        currentHitter = firstHitter.getBatOrder();
        currentPitcher = findStartingPitcher().getBatOrder();
    }

    public PlayerParticipatingInGame findPlayerByBatOrder(int batOrder) {
        return players.get(batOrder);
    }

    private PlayerParticipatingInGame findStartingPitcher() {
        return players.stream()
                .filter(PlayerParticipatingInGame::isStartingPitcher)
                .findFirst()
                .orElseThrow(() -> new PlayerNotFoundException(PlayerNotFoundException.FIND_STARTING_PITCHER_FAILED));
    }

    public int changeHitter() {
        currentHitter = nextHitter();
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

    public int nextHitter() {
        int next = currentHitter + 1;
        if (players.size() == next) {
            next = 0;
        }
        return next;
    }

    public int getId() {
        return id;
    }

    public boolean isHomeTeam() {
        return teamType == TeamType.HOME;
    }

    public boolean isAwayTeam() {
        return teamType == TeamType.AWAY;
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

    public void setCurrentHitter(int currentHitter) {
        this.currentHitter = currentHitter;
    }

    public int getCurrentPitcher() {
        return currentPitcher;
    }

    public void setCurrentPitcher(int currentPitcher) {
        this.currentPitcher = currentPitcher;
    }

    public List<PlayerParticipatingInGame> getPlayers() {
        return players;
    }

    public TeamType getTeamType() {
        return teamType;
    }

    @Override
    public String toString() {
        return "TeamParticipatingInGame{" +
                "id=" + id +
                ", team=" + team +
                ", players=" + players +
                ", teamType=" + teamType +
                '}';
    }
}
