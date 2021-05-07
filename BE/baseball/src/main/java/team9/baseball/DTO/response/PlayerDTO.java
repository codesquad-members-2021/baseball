package team9.baseball.DTO.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import team9.baseball.domain.aggregate.team.Team;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PlayerDTO {
    private int team_id;
    private int uniform_number;
    private String name;

    public static PlayerDTO of(Team team, Integer uniform_number) {
        if (uniform_number == null) {
            return null;
        }

        return builder()
                .team_id(team.getId())
                .uniform_number(uniform_number)
                .name(team.getPlayerName(uniform_number))
                .build();
    }
}
