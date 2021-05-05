package team9.baseball.domain.aggregate.game;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BattingHistory {
    @Id
    private Long id;

    private Integer batterTeamId;

    private Integer batterUniformNumber;

    private int appear;

    private int hits;

    private int out;

    private String keyInGame;

    public BattingHistory(Integer batterTeamId, Integer batterUniformNumber) {
        this.batterTeamId = batterTeamId;
        this.batterUniformNumber = batterUniformNumber;
        this.keyInGame = getKeyInGame(batterTeamId, batterUniformNumber);
    }

    public static String getKeyInGame(Integer batterTeamId, Integer batterUniformNumber) {
        return batterTeamId + "_" + batterUniformNumber;
    }
}
