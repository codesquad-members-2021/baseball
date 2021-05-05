package com.dong.baseball.Domain;

import org.springframework.data.annotation.Id;

public class Board {

    @Id
    private Long board_Id;

    private Long matchId;
    private int inning;
    private String turn;
    private int strike;
    private int ball;
    private int out;
    private int HomePoint;
    private int AwayPoint;
    private String pitcher;
    private String batter;

    public Long getBoard_Id() {
        return board_Id;
    }

    public void setBoard_Id(Long board_Id) {
        this.board_Id = board_Id;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public int getInning() {
        return inning;
    }

    public void setInning(int inning) {
        this.inning = inning;
    }

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getOut() {
        return out;
    }

    public void setOut(int out) {
        this.out = out;
    }

    public int getHomePoint() {
        return HomePoint;
    }

    public void setHomePoint(int homePoint) {
        HomePoint = homePoint;
    }

    public int getAwayPoint() {
        return AwayPoint;
    }

    public void setAwayPoint(int awayPoint) {
        AwayPoint = awayPoint;
    }

    public String getPitcher() {
        return pitcher;
    }

    public void setPitcher(String pitcher) {
        this.pitcher = pitcher;
    }

    public String getBatter() {
        return batter;
    }

    public void setBatter(String batter) {
        this.batter = batter;
    }
}
