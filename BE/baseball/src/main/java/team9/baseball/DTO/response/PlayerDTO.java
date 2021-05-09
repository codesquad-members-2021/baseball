package team9.baseball.DTO.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import team9.baseball.domain.aggregate.team.Player;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PlayerDTO {
    private int teamId;
    private int uniformNumber;
    private String name;

    public static PlayerDTO of(Player player) {
        if (player == null) {
            return null;
        }

        return builder()
                .teamId(player.getId())
                .uniformNumber(player.getUniformNumber())
                .name(player.getName())
                .build();
    }
}
