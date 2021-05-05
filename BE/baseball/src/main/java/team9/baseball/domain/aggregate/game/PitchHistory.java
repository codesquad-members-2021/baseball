package team9.baseball.domain.aggregate.game;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import team9.baseball.domain.enums.PitchResult;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PitchHistory {
    @Id
    private Long id;

    private Integer pitcherTeamId;

    private Integer pitcherUniformNumber;

    private Integer batterTeamId;

    private Integer batterUniformNumber;

    private PitchResult result;

    public PitchHistory(Integer pitcherTeamId, Integer pitcherUniformNumber,
                        Integer batterTeamId, Integer batterUniformNumber, PitchResult result) {
        this.pitcherTeamId = pitcherTeamId;
        this.pitcherUniformNumber = pitcherUniformNumber;
        this.batterTeamId = batterTeamId;
        this.batterUniformNumber = batterUniformNumber;
        this.result = result;
    }
}
