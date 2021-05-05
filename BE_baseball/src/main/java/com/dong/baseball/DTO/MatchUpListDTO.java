package com.dong.baseball.DTO;

import com.dong.baseball.Domain.Match;

public class MatchUpListDTO {
    private Long matchId;
    private String home;
    private String away;


    public MatchUpListDTO(Match match) {
        this.matchId = match.getMatchId();
        this.home = match.getHome();
        this.away = match.getAway();
    }

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
        return "MatchUpListDTO{" +
                "matchId=" + matchId +
                ", home='" + home + '\'' +
                ", away='" + away + '\'' +
                '}';
    }
}
