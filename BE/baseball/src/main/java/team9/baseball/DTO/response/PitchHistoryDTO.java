package team9.baseball.DTO.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import team9.baseball.domain.aggregate.game.PitchHistory;
import team9.baseball.domain.aggregate.team.Team;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PitchHistoryDTO {
    private PlayerDTO pitcher;
    private PlayerDTO batter;
    private String result;
    private int strike_count;
    private int ball_count;

    public static PitchHistoryDTO of(Team attackTeam, Team defenseTeam, PitchHistory pitchHistory) {
        return builder()
                .pitcher(PlayerDTO.of(defenseTeam, pitchHistory.getPitcherUniformNumber()))
                .batter(PlayerDTO.of(attackTeam, pitchHistory.getBatterUniformNumber()))
                .result(pitchHistory.getResult().name())
                .strike_count(pitchHistory.getStrikeCount())
                .ball_count(pitchHistory.getBallCount())
                .build();
    }
}
