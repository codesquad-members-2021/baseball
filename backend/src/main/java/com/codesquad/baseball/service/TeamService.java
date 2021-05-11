package com.codesquad.baseball.service;

import com.codesquad.baseball.domain.Player;
import com.codesquad.baseball.domain.PlayerRole;
import com.codesquad.baseball.domain.Team;
import com.codesquad.baseball.domain.TeamRepository;
import com.codesquad.baseball.dto.PlayerDTO;
import com.codesquad.baseball.exceptions.TeamNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Transactional
    public Team createTeam(String teamName) {
        Team team = new Team(teamName);
        return teamRepository.save(team);
    }

    @Transactional(readOnly = true)
    public Team findTeam(int id) {
        return teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException(id));
    }

    @Transactional
    public void addHitter(Team team, String playerName, int uniformNumber) {
        Player player = createPlayer(playerName, uniformNumber, PlayerRole.HITTER);
        addPlayer(team, player);
    }

    @Transactional
    public void addPitcher(Team team, String playerName, int uniformNumber) {
        Player player = createPlayer(playerName, uniformNumber, PlayerRole.PITCHER);
        addPlayer(team, player);
    }

    private Player createPlayer(String playerName, int uniformNumber, PlayerRole playerRole) {
        return new Player.Builder()
                .playerName(playerName)
                .uniformNumber(uniformNumber)
                .role(playerRole)
                .build();
    }

    private void addPlayer(Team team, Player player) {
        team.addPlayer(player);
        teamRepository.save(team);
    }
}
