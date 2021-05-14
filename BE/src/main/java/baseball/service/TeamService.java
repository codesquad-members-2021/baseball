package baseball.service;

import baseball.domain.Member;
import baseball.domain.Record;
import baseball.domain.Team;
import baseball.exception.TeamNotFoundException;
import baseball.repository.TeamRepository;
import baseball.service.dto.RequestTeamDTO;
import baseball.service.dto.TeamDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TeamService {

    private TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public void saveTeams(List<RequestTeamDTO> teamDTOs) {
        List<Team> teams = teamDTOs.stream()
                .map(RequestTeamDTO::toTeam)
                .collect(Collectors.toList());
        teamRepository.saveAll(teams);
    }

    public List<TeamDTO> convertToTeamDTOList() {
        Iterable<Team> teams = teamRepository.findAll();
        List<TeamDTO> teamDTOs = new ArrayList<>();

        for (Team team : teams) {
            Set<Member> members = team.getMembers();
            TeamDTO teamDTO = new TeamDTO(team, members);
            teamDTOs.add(teamDTO);
        }
        return teamDTOs;
    }

    public void insertRecord(Long teamId, Long memberId, int atBat, int hit, int out) {
        Team team = teamRepository.findById(teamId).orElseThrow(TeamNotFoundException::new);
        Member member = team.getMemberById(memberId);
        member.setRecord(new Record(atBat, hit, out));
        teamRepository.save(team);
    }
}
