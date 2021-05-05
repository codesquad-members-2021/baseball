package com.dong.baseball.Domain;

import org.springframework.data.annotation.Id;

public class Board {

    @Id
    private Long board_Id;

    private Long matchId;

    private String turn;
    private int strike;
    private int ball;
    private int out;
    private int HomePoint;
    private int AwayPoint;
    private String pitcher;
    private String batter;
}
