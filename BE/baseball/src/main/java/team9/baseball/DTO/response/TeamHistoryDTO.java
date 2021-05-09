package team9.baseball.DTO.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TeamHistoryDTO {
    private String teamName;
    private List<Integer> scores;
    private List<BattingHistoryDTO> battingHistory;
}
