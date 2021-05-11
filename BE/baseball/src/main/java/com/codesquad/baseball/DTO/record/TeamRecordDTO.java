package com.codesquad.baseball.DTO.record;

import com.codesquad.baseball.DTO.TeamDTO;
import com.codesquad.baseball.domain.Team;

public class TeamRecordDTO {

    private TeamDTO awayTeam;

    private TeamDTO homeTeam;

    public TeamRecordDTO(Team awayTeam, Team homeTeam) {
        this.awayTeam = TeamDTO.of(awayTeam);
        this.homeTeam = TeamDTO.of(homeTeam);
    }

    public TeamDTO getAwayTeam() {
        return awayTeam;
    }

    public TeamDTO getHomeTeam() {
        return homeTeam;
    }
}
