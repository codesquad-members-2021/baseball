package com.codesquad.team12.baseball.service;

import com.codesquad.team12.baseball.dto.response.TeamPlayerDto;
import com.codesquad.team12.baseball.model.Team;
import com.codesquad.team12.baseball.repository.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public TeamPlayerDto findById(String name) {
        Team team = teamRepository.findById(name)
                .orElseThrow(IllegalArgumentException::new);
        return Team.createTeamPlayerDto(team);
    }

}
