package com.baseball.domain.team;

import com.baseball.domain.player.Batter;
import com.baseball.domain.player.Pitcher;
import com.baseball.domain.player.Players;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private final String name;
    private Players players;
    private final List<Integer> scores = new ArrayList<>();

    public Team(String name, Players players) {
        this.name = name;
        this.players = players;
    }

    public void pushScore(Integer score) {
        scores.add(score);
    }

    public void increaseScore() {
        int lastIndex = scores.size() - 1;
        scores.set(lastIndex, scores.get(lastIndex) + 1);
    }

    public Integer totalScore() {
        return scores.stream()
                .reduce(Integer::sum)
                .orElse(0);
    }

    public String getName() {
        return name;
    }

    public Players getPlayers() {
        return players;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public Pitcher getPitcher() {
        return players.getPitcher();
    }

    public Batter getBatter() {
        return players.getBatter();
    }

    public void changePitcher() {
        players.changePitcher();
    }

    public void changeBatter() {
        players.changeBatter();
    }
}
