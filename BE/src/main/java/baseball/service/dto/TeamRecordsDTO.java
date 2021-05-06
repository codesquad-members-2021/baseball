package baseball.service.dto;

import baseball.domain.RecordMember;

import java.util.Set;

public class TeamRecordsDTO {

    private Long teamId;
    private Set<RecordMember> records;

    public TeamRecordsDTO(Long teamId, Set<RecordMember> records) {
        this.teamId = teamId;
        this.records = records;
    }

    public Long getTeamId() {
        return teamId;
    }

    public Set<RecordMember> getRecords() {
        return records;
    }
}
