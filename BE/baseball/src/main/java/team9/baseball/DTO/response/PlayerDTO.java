package team9.baseball.DTO.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import team9.baseball.domain.aggregate.team.Team;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PlayerDTO {
    private int teamId;
    private int uniformNumber;
    private String name;

    public static PlayerDTO of(Team team, Integer uniform_number) {
        if (uniform_number == null) {
            return null;
        }

        return builder()
                .teamId(team.getId())
                .uniformNumber(uniform_number)
                .name(team.getPlayerName(uniform_number))
                .build();
    }
}
