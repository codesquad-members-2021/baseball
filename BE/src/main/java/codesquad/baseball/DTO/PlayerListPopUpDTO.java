package codesquad.baseball.DTO;

import codesquad.baseball.domain.Player;
import codesquad.baseball.domain.Team;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@JsonPropertyOrder({"teamName", "user", "playerGameScore"})
public class PlayerListPopUpDTO {
    private String teamName;
    private boolean isUser;
    private List<PlayerGameScoreDTO> playerGameScore = new ArrayList<>();

    public PlayerListPopUpDTO (Team team) {
        this.teamName = team.getName();
        this.isUser = team.isUser();
        for(Player player: team.getPlayerList()) {
            playerGameScore.add(new PlayerGameScoreDTO(player));
        }
    }
}
