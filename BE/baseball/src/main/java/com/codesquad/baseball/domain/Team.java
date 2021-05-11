package com.codesquad.baseball.domain;

import com.codesquad.baseball.error.exception.PlayerNotFoundException;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;

public class Team {

    @Id
    private Long id;

    private String name;

    private boolean isHome;

    private boolean isPlayable;

    private Long pitcherId;

    private boolean userSelected;

    private Set<Player> players = new HashSet<>();

    private Set<Score> scores = new HashSet<>();

    public Team(String name, boolean isHome, boolean isPlayable) {
        this.name = name;
        this.isHome = isHome;
        this.isPlayable = isPlayable;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isHome() {
        return isHome;
    }

    public boolean isPlayable() {
        return isPlayable;
    }

    public Long getPitcherId() {
        return pitcherId;
    }

    public boolean isUserSelected() {
        return userSelected;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public Set<Score> getScores() {
        return scores;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHome(boolean home) {
        isHome = home;
    }

    public void setPlayable(boolean playable) {
        isPlayable = playable;
    }

    public void setPitcherId(Long pitcherId) {
        this.pitcherId = pitcherId;
    }

    public Team setUserSelected(boolean userSelected) {
        this.userSelected = userSelected;
        return this;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void updatePlayerSet(Player player) {
        players.remove(getPlayerById(player.getId()));
        addPlayer(player);
    }

    public Player getPlayerById(Long id) {
        for (Player player : players) {
            if (id.equals(player.getId())) {
                return player;
            }
        }
        throw new PlayerNotFoundException();
    }

    public void addScore(Score score) {
        scores.add(score);
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", players=" + players +
                '}';
    }
}
