package codesquad.baseball;

import codesquad.baseball.DTO.PlayerDTO;
import codesquad.baseball.DTO.TeamDTO;
import codesquad.baseball.DTO.TeamHistoryDTO;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"teamLeft", "teamRight", "pitcher", "hitter", "teamLog"})
public class ApiResponse {
    TeamDTO teamLeft;
    TeamDTO teamRight;

    PlayerDTO pitcher;
    PlayerDTO hitter;

    TeamHistoryDTO teamLog;
}
