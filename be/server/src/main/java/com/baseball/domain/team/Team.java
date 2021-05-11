package com.baseball.domain.team;

import com.baseball.domain.match.PlayResult;
import com.baseball.domain.player.Batter;
import com.baseball.domain.player.Pitcher;
import com.baseball.domain.player.Players;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private final List<Integer> scores = new ArrayList<>();
    private final String name;
    private Players players;

    public Team(String name, Players players) {
        this.name = name;
        this.players = players;
    }

    public void pushScore() {
        scores.add(0);
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

    public void playOffense(PlayResult playResult) {
        Batter batter = players.getBatter();
        batter.play(playResult);
        if (playResult == PlayResult.HIT) {
            players.changeBatter();
        }
    }

    public void playDefense(PlayResult playResult) {
        Pitcher pitcher = players.getPitcher();
        pitcher.play(playResult);
    }

    public List<Integer> getScores() {
        return scores;
    }

    public String getName() {
        return name;
    }

    public List<Pitcher> getPitchers() {
        return players.getPitchers();
    }

    public List<Batter> getBatters() {
        return players.getBatters();
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
