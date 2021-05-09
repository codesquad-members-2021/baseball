package com.baseball.domain.team;

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
}
