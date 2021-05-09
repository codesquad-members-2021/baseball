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

    private int strikeCount;

    private int ballCount;

    public PitchHistory(Integer pitcherTeamId, Integer pitcherUniformNumber,
                        Integer batterTeamId, Integer batterUniformNumber, PitchResult result,
                        int strikeCount, int ballCount) {
        this.pitcherTeamId = pitcherTeamId;
        this.pitcherUniformNumber = pitcherUniformNumber;
        this.batterTeamId = batterTeamId;
        this.batterUniformNumber = batterUniformNumber;
        this.result = result;
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public boolean hasMatchedPitcher(int pitcherTeamId, int pitcherUniformNumber) {
        return this.pitcherTeamId == pitcherTeamId && this.pitcherUniformNumber == pitcherUniformNumber;
    }
}
