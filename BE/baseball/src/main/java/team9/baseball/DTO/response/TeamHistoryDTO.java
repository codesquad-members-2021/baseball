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
    private String team_name;
    private List<Integer> scores;
    private List<BattingHistoryDTO> batting_history;

    public static TeamHistoryDTO of(String team_name, List<Integer> scores, List<BattingHistoryDTO> batting_history) {
        return builder()
                .team_name(team_name)
                .scores(scores)
                .batting_history(batting_history)
                .build();
    }
}
