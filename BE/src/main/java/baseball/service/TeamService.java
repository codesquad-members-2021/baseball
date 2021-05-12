package baseball.service;

import baseball.domain.Member;
import baseball.domain.Record;
import baseball.exception.RecordDTONotFoundException;
import baseball.exception.TeamNotFoundException;
import baseball.service.dto.*;
import baseball.domain.Team;
import baseball.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public void saveTeams(List<TeamRequest> teamDTOs) {
        List<Team> teams = teamDTOs.stream()
                .map(TeamRequest::toTeam)
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

    public void insertRecord(Long teamId, Long memberId, RecordRequest recordRequest) {
        Team team = teamRepository.findById(teamId).orElseThrow(TeamNotFoundException::new);
        Member member = team.getMemberById(memberId);
        member.setRecord(recordRequest.toRecord());
        teamRepository.save(team);
    }

    public TeamRecordsDTO getRecordsOfTeam(Long teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow(TeamNotFoundException::new);
        Set<Member> members = team.getMembers();

        Set<RecordDTO> recordDTOS = new HashSet<>();
        for (Member member : members) {
            if (member.hasRecord()) {
                RecordDTO recordDTO = teamRepository.findRecordByMemberId(member.getId())
                        .orElseThrow(RecordDTONotFoundException::new);
                recordDTOS.add(recordDTO);
            }
        }
        return new TeamRecordsDTO(teamId, recordDTOS);
    }
}
