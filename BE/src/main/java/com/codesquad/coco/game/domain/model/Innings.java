package com.codesquad.coco.game.domain.model;

import org.springframework.data.annotation.Id;

public class Innings {

    @Id
    private Long id;

    private Long scoreBoard;
    private int score;

    public Innings(Long id, Long scoreBoard, int score) {
        this.id = id;
        this.scoreBoard = scoreBoard;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Innings{" +
                "id=" + id +
                ", scoreBoard=" + scoreBoard +
                ", score=" + score +
                '}';
    }
}
