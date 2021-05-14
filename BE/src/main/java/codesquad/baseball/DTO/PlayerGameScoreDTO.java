package codesquad.baseball.DTO;

import codesquad.baseball.domain.Player;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PlayerGameScoreDTO {
    private String playerName;
    private int plateAppearance;
    private int hits;
    private int out;
    private Long average;

    public PlayerGameScoreDTO(Player player) {
        this.playerName = player.getName();
        this.plateAppearance = player.getPlayerGameInfo().getPlateAppearance();
        this.hits = player.getPlayerGameInfo().getHits();
        this.out = player.getPlayerGameInfo().getOut();
        this.average = player.getPlayerGameInfo().getAverage();
    }
}
