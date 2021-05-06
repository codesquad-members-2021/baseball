package baseball.controller;

import baseball.domain.Member;
import baseball.domain.Record;
import baseball.domain.RecordMember;
import baseball.domain.Team;
import baseball.repository.TeamRepository;
import baseball.service.dto.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class TeamController {

    private TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @PostMapping("/teams")
    public void createTeams(@RequestBody List<RequestTeamDTO> teamDTOS) {
        List<Team> teams = teamDTOS.stream()
                .map(RequestTeamDTO::toTeam)
                .collect(Collectors.toList());
        teamRepository.saveAll(teams);
    }

    @GetMapping("/teams")
    public List<TeamDTO> showTeams() {
        Iterable<Team> teams = teamRepository.findAll();

        List<TeamDTO> teamDTOS = new ArrayList<>();
        for (Team team : teams) {
            List<MemberDTO> memberDTOS = team.getMembers().stream()
                    .map(MemberDTO::toMemberDTO)
                    .collect(Collectors.toList());
            teamDTOS.add(new TeamDTO(team, memberDTOS));
        }
        return teamDTOS;
    }

    @GetMapping("/teams/{teamId}/records")
    public TeamRecordsDTO showRecords(@PathVariable Long teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow(NoSuchElementException::new);
        Set<Member> members = team.getMembers();
        for (Member member : members) {
            Record record = new Record(3, 1, 1);
            member.setRecord(record);
        }
        teamRepository.save(team);

        Set<RecordMember> recordMembers = new HashSet<>();
        for (Member member : members) {
            RecordMember recordMember = teamRepository.findRecordByMemberId(member.getId()).get();
            recordMembers.add(recordMember);
        }

        return new TeamRecordsDTO(teamId, recordMembers);
    }
}
