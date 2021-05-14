package codesquad.baseball.DTO;

import codesquad.baseball.domain.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PlayerDTO {
    private String role;
    private String name;
    private int pitchCount;
    private int plateAppearances;
    private int hits;

    public PlayerDTO(String role, Player player) {
        this.role = role;
        this.name = player.getName();
        this.pitchCount = player.getPlayerGameInfo().getPitchCount();
        this.plateAppearances = player.getPlayerGameInfo().getPlateAppearance();
        this.hits = player.getPlayerGameInfo().getHits();
    }
}
