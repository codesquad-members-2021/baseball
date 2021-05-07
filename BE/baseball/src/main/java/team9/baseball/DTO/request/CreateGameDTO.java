package team9.baseball.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateGameDTO {
    private int away_team_id;
    private int home_team_id;
}
