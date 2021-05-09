package com.baseball.domain;

import com.baseball.domain.player.Batter;
import com.baseball.domain.player.Pitcher;

public class Match {
    private final Team awayTeam;
    private final Team homeTeam;
    private final MatchInfo matchInfo = new MatchInfo();

    public Match(Team awayTeam, Team homeTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public MatchInfo getMatchInfo() {
        return matchInfo;
    }

    public Pitcher getPitcher() {
        /**
         * TODO: Inning에 따라 달라지도록 해야함
         * - 홈팀이 먼저 수비
         */
        return homeTeam.getPlayers().getPitchers().get(0);
    }

    public Batter getBatter() {
        /**
         * TODO: 경기 진행에 따라 달라지도록 해야함
         * - 원정팀이 먼저 공격
         */
        return awayTeam.getPlayers().getBatters().get(0);
    }
}
