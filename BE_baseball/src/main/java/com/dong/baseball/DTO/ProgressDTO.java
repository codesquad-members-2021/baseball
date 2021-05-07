package com.dong.baseball.DTO;

import com.dong.baseball.Domain.Player;

import java.util.ArrayList;
import java.util.List;

public class ProgressDTO {

    private String away;
    private String home;
    private int inning;
    private String offenseTurn;
    private List<Player> firstBase;
    private List<Player> secondBase;
    private List<Player> thirdBase;
    private Player pitcher;
    private Player batter;


    public ProgressDTO(String s) {
        this.away = "away";
        this.home = "home";
        this.inning = 99;
        this.offenseTurn = "offenseTurn";
        this.firstBase = new ArrayList<>();
        this.secondBase = new ArrayList<>();
        this.thirdBase = new ArrayList<>();
        this.pitcher = new Player();
        this.batter = new Player();
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

    public String getOffenseTurn() {
        return offenseTurn;
    }

    public void setOffenseTurn(String offenseTurn) {
        this.offenseTurn = offenseTurn;
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

    public Player getPitcher() {
        return pitcher;
    }

    public void setPitcher(Player pitcher) {
        this.pitcher = pitcher;
    }

    public Player getBatter() {
        return batter;
    }

    public void setBatter(Player batter) {
        this.batter = batter;
    }
}
