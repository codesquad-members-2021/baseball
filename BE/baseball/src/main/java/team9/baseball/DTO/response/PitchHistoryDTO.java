package team9.baseball.DTO.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import team9.baseball.domain.aggregate.game.PitchHistory;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PitchHistoryDTO {
    private String result;
    private String log;

    public static PitchHistoryDTO of(PitchHistory pitchHistory) {
        return builder()
                .result(pitchHistory.getResult().name())
                .log(null)
                .build();
    }
}
