package com.dong.baseball.Service;

import com.dong.baseball.Domain.Team;
import com.dong.baseball.Repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }


    public List<Team> teamRanking() {
        List<Team> teamList = teamRepository.findAll();

        Collections.sort(teamList, new Comparator<Team>() {
            @Override
            public int compare(Team t1, Team t2) {
                if (t1.getVictoryPoint() > t2.getVictoryPoint()) {
                    return -1;
                }
                if (t1.getVictoryPoint() < t2.getVictoryPoint()) {
                    return 1;
                }
                return 0;
            }
        });
        return teamList;
    }
}
