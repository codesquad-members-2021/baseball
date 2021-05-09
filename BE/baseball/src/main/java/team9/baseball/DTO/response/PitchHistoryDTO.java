package team9.baseball.DTO.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import team9.baseball.domain.aggregate.game.PitchHistory;
import team9.baseball.domain.aggregate.team.Team;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PitchHistoryDTO {
    private PlayerDTO pitcher;
    private PlayerDTO batter;
    private String result;
    private int strikeCount;
    private int ballCount;

    public static PitchHistoryDTO of(Team attackTeam, Team defenseTeam, PitchHistory pitchHistory) {
        return builder()
                .pitcher(PlayerDTO.of(defenseTeam.getPlayer(pitchHistory.getPitcherUniformNumber())))
                .batter(PlayerDTO.of(attackTeam.getPlayer(pitchHistory.getBatterUniformNumber())))
                .result(pitchHistory.getResult().name())
                .strikeCount(pitchHistory.getStrikeCount())
                .ballCount(pitchHistory.getBallCount())
                .build();
    }
}
