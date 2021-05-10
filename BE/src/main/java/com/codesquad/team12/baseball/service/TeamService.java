package com.codesquad.team12.baseball.service;

import com.codesquad.team12.baseball.model.Player;
import com.codesquad.team12.baseball.model.Team;
import com.codesquad.team12.baseball.repository.TeamRepository;

public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team findById(Long id) {
        return teamRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }
}
