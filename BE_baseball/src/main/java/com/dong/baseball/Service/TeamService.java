package com.dong.baseball.Service;

import com.dong.baseball.DTO.TeamRankDTO;
import com.dong.baseball.Domain.Team;
import com.dong.baseball.Exception.TeamNotFoundException;
import com.dong.baseball.Repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }


    public List<TeamRankDTO> teamRanking() {
        List<Team> teamList = teamRepository.findAll();
        List<TeamRankDTO> teamRankDTOList = new ArrayList<>();

        for (Team team : teamList) {
            teamRankDTOList.add(new TeamRankDTO(team));
        }

        teamRankDTOList.sort(new Comparator<TeamRankDTO>() {
            @Override
            public int compare(TeamRankDTO t1, TeamRankDTO t2) {
                return Integer.compare(t2.getVictoryPoint(), t1.getVictoryPoint());
            }
        });
        return teamRankDTOList;
    }

    public Team teamInfoById(Long teamId) {
        return teamRepository.findByTeamId(teamId).orElseThrow(() -> new TeamNotFoundException());
    }

    public Team teamInfoByName(String teamName) {
        return teamRepository.findByTeamName(teamName).orElseThrow(() -> new TeamNotFoundException());
    }
}
