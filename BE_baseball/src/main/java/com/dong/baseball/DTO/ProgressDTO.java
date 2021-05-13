package com.dong.baseball.DTO;

import com.dong.baseball.Domain.Board;
import com.dong.baseball.Domain.Player;

import java.util.ArrayList;
import java.util.List;

public class ProgressDTO {
    private Long matchId;
    private String away;
    private String home;
    private int inning;
    private String offenseTeam;
    private List<Player> firstBase;
    private List<Player> secondBase;
    private List<Player> thirdBase;
    private String pitcher;
    private String batter;
    private int strike;
    private int ball;
    private int out;
    private int homePoint;
    private int awayPoint;

    public ProgressDTO(Board board) {
        this.matchId = board.getId();
        this.away = "awayteam to string";
        this.home = "hometeam to string";
        this.inning = board.getInning();
        this.offenseTeam = "offenseTeam to String";

        this.firstBase = new ArrayList<>();
        this.secondBase = new ArrayList<>();
        this.thirdBase = new ArrayList<>();

        this.pitcher = board.getPitcher();
        this.batter = board.getBatter();
        this.strike = board.getStrike();
        this.ball = board.getBall();
        this.out = board.getOut();
        this.homePoint = board.getHomePoint();
        this.awayPoint = board.getAwayPoint();
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public int getInning() {
        return inning;
    }

    public void setInning(int inning) {
        this.inning = inning;
    }

    public String getOffenseTeam() {
        return offenseTeam;
    }

    public void setOffenseTeam(String offenseTeam) {
        this.offenseTeam = offenseTeam;
    }

    public List<Player> getFirstBase() {
        return firstBase;
    }

    public void setFirstBase(List<Player> firstBase) {
        this.firstBase = firstBase;
    }

    public List<Player> getSecondBase() {
        return secondBase;
    }

    public void setSecondBase(List<Player> secondBase) {
        this.secondBase = secondBase;
    }

    public List<Player> getThirdBase() {
        return thirdBase;
    }

    public void setThirdBase(List<Player> thirdBase) {
        this.thirdBase = thirdBase;
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
        return homePoint;
    }

    public void setHomePoint(int homePoint) {
        this.homePoint = homePoint;
    }

    public int getAwayPoint() {
        return awayPoint;
    }

    public void setAwayPoint(int awayPoint) {
        this.awayPoint = awayPoint;
    }

    @Override
    public String toString() {
        return "ProgressDTO{" +
                "matchId=" + matchId +
                ", away='" + away + '\'' +
                ", home='" + home + '\'' +
                ", inning=" + inning +
                ", offenseTeam='" + offenseTeam + '\'' +
                ", firstBase=" + firstBase +
                ", secondBase=" + secondBase +
                ", thirdBase=" + thirdBase +
                ", pitcher='" + pitcher + '\'' +
                ", batter='" + batter + '\'' +
                ", strike=" + strike +
                ", ball=" + ball +
                ", out=" + out +
                ", homePoint=" + homePoint +
                ", awayPoint=" + awayPoint +
                '}';
    }
}
