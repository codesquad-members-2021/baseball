package com.codesquad.baseball.DTO;

import com.codesquad.baseball.domain.Team;

public class TeamRecordDTO {

    private TeamDTO homeTeam;

    private TeamDTO awayTeam;

    public TeamRecordDTO(Team homeTeam, Team awayTeam) {
        this.homeTeam = TeamDTO.of(homeTeam);
        this.awayTeam = TeamDTO.of(awayTeam);
    }

    public TeamDTO getHomeTeam() {
        return homeTeam;
    }

    public TeamDTO getAwayTeam() {
        return awayTeam;
    }
}
