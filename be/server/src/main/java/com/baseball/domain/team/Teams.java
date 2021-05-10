package com.baseball.domain.team;

import com.baseball.domain.player.Batter;
import com.baseball.domain.player.Pitcher;
import com.baseball.exception.MatchOccupiedException;

import static com.baseball.domain.team.SelectedTeam.*;

public class Teams {
    private final Team awayTeam;
    private final Team homeTeam;
    private SelectedTeam selectedTeam = NONE;

    public Teams(Team awayTeam, Team homeTeam) {
        this.awayTeam = awayTeam;
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public SelectedTeam getSelectedTeam() {
        return selectedTeam;
    }

    public void selectTeam(String teamName) {
        if (selectedTeam != NONE) {
            throw new MatchOccupiedException();
        }
        selectedTeam = homeTeam.getName().equals(teamName) ? HOME : AWAY;
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
