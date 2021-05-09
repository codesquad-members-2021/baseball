package team9.baseball.DTO.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TeamHistoryDTO {
    private String teamName;
    private List<Integer> scores;
    private List<BattingHistoryDTO> battingHistory;

    public static TeamHistoryDTO of(String team_name, List<Integer> scores, List<BattingHistoryDTO> batting_history) {
        return builder()
                .teamName(team_name)
                .scores(scores)
                .battingHistory(batting_history)
                .build();
    }
}
