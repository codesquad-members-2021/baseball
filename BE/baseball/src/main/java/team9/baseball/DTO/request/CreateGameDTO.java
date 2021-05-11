package team9.baseball.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateGameDTO {
    private int awayTeamId;
    private int homeTeamId;
}
