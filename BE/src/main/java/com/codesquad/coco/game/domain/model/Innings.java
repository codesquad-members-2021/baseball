package com.codesquad.coco.game.domain.model;

import org.springframework.data.annotation.Id;

public class Innings {

    @Id
    private Long id;

    private Long scoreBoard;
    private int score;
    private int inning;

    public Innings(Long scoreBoard, int score, int inning) {
        this.scoreBoard = scoreBoard;
        this.score = score;
        this.inning = inning;
    }

    public Innings(Long id, Long scoreBoard, int score) {
        this.id = id;
        this.scoreBoard = scoreBoard;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public Long getScoreBoard() {
        return scoreBoard;
    }

    public int getScore() {
        return score;
    }

    public int getInning() {
        return inning;
    }

    @Override
    public String toString() {
        return "Innings{" +
                "id=" + id +
                ", scoreBoard=" + scoreBoard +
                ", score=" + score +
                '}';
    }

    public void update(int point) {
        this.score += point;
    }
}
