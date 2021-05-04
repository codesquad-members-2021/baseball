package com.dong.baseball.Domain;

import org.springframework.data.annotation.Id;

public class Board {

    @Id
    private Long gameId;

    private String turn;
    private int strike;
    private int ball;
    private int out;
    private int point;
    private String pitcher;
    private String batter;
}
