package baseball.service.dto;

import java.util.Set;

public class TeamRecordsDTO {

    private Long teamId;
    private Set<RecordDTO> records;

    public TeamRecordsDTO(Long teamId, Set<RecordDTO> records) {
        this.teamId = teamId;
        this.records = records;
    }

    public Long getTeamId() {
        return teamId;
    }

    public Set<RecordDTO> getRecords() {
        return records;
    }
}
