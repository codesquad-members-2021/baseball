package com.codesquad.coco.game.domain;

import org.springframework.data.annotation.Id;

public class Innings {

    @Id
    private Long id;

    private int score;
}
