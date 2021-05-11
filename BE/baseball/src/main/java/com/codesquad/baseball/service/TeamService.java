package com.codesquad.baseball.service;

import com.codesquad.baseball.DTO.RequestPlayerRecordDTO;
import com.codesquad.baseball.DTO.TeamDTO;
import com.codesquad.baseball.domain.Player;
import com.codesquad.baseball.domain.Score;
import com.codesquad.baseball.domain.Team;
import com.codesquad.baseball.error.exception.TeamNotFoundException;
import com.codesquad.baseball.error.exception.TeamNotPlayableException;
import com.codesquad.baseball.repository.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team save(Team team) {
        return teamRepository.save(team);
    }

    public Team browseTeamById(Long id) {
        return teamRepository.findById(id).orElseThrow(TeamNotFoundException::new);
    }

    public TeamDTO browseTeamStatus(Long id) {
        Team team = browseTeamById(id);
        if (!team.isPlayable()) {
            throw new TeamNotPlayableException();
        }
        return TeamDTO.of(team);
    }
}
