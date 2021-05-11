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
    //private Player pitcher;
    //private Player batter;
    private String pitcher;
    private String batter;
    private int strike;
    private int ball;
    private int out;
    private int homePoint;
    private int awayPoint;

    public ProgressDTO(Long matchId, String away, String home, int inning,
                       String offenseTeam, List<Player> firstBase, List<Player> secondBase,
                       List<Player> thirdBase, String pitcher, String batter, int strike,
                       int ball, int out, int homePoint, int awayPoint) {
        this.matchId = matchId;
        this.away = away;
        this.home = home;
        this.inning = inning;
        this.offenseTeam = offenseTeam;
        this.firstBase = firstBase;
        this.secondBase = secondBase;
        this.thirdBase = thirdBase;
        this.pitcher = pitcher;
        this.batter = batter;
        this.strike = strike;
        this.ball = ball;
        this.out = out;
        this.homePoint = homePoint;
        this.awayPoint = awayPoint;
    }

    public ProgressDTO(Board board) {
        this.matchId = board.getId();
        this.away = "awayteam to string";
        this.home = "hometeam to string";
        this.inning = board.getInning();
        this.offenseTeam = "offenseTeam to String";
        //this.firstBase = firstBase;
        //this.secondBase = secondBase;
        //this.thirdBase = thirdBase;
        this.firstBase = new ArrayList<>();
        this.secondBase = new ArrayList<>();;
        this.thirdBase = new ArrayList<>();;

        this.pitcher = board.getPitcher();
        this.batter = board.getBatter();
        this.strike = board.getStrike();
        this.ball = board.getBall();
        this.out = board.getOut();
        this.homePoint = board.getHomePoint();
        this.awayPoint = board.getAwayPoint();
    }
}
