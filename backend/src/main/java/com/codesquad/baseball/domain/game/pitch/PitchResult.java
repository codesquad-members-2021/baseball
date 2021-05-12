package com.codesquad.baseball.domain.game.pitch;

import com.codesquad.baseball.domain.game.Game;
import com.codesquad.baseball.domain.game.GameState;
import com.codesquad.baseball.domain.game.inning.History;
import com.codesquad.baseball.domain.game.PlayType;

import java.util.ArrayList;
import java.util.List;

public class PitchResult {

    private PlayType playType;
    private List<Integer> backHomeRunners = new ArrayList<>();
    private GameState gameState;
    private History history;

    public PitchResult(PlayType playType) {
        this.playType = playType;
        gameState = GameState.IN_PROGRESS;
    }

    public int numberOfRunners() {
        return backHomeRunners.size();
    }

    public int findRunnerByOrder(int order) {
        return backHomeRunners.get(order);
    }

    public boolean hasRunner() {
        return backHomeRunners.size() > 0;
    }

    public void addRunner(int runner) {
        if (runner == Game.NO_PLAYER) {
            return;
        }
        backHomeRunners.add(runner);
    }

    public void addRunner(List<Integer> runners) {
        backHomeRunners.addAll(runners);
    }

    public void changePlayTypeToStrikeOut() {
        playType = PlayType.STRIKE_OUT;
    }

    public void changePlayTypeToFourBall() {
        playType = PlayType.FOUR_BALL;
    }

    public void changeGameStateToGameOver() {
        gameState = GameState.GAME_OVER;
    }

    public PlayType getPlayType() {
        return playType;
    }

    public List<Integer> getBackHomeRunners() {
        return backHomeRunners;
    }

    public GameState getGameState() {
        return gameState;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }
}
