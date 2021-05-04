package com.dong.baseball.Domain;

import org.springframework.data.annotation.Id;

public class Match {
    @Id
    Long matchId;

    String home;
    String away;

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    @Override
    public String toString() {
        return "Match{" +
                "matchId=" + matchId +
                ", home='" + home + '\'' +
                ", away='" + away + '\'' +
                '}';
    }
}
