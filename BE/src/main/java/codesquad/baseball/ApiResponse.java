package codesquad.baseball;

import codesquad.baseball.DTO.*;
import codesquad.baseball.domain.Inning;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"inning", "nextHitter", "expeditionTeam", "homeTeam", "pitcher", "hitter", "teamLog"})
public class ApiResponse {
    Inning inning;
    PlayerLogDTO nextHitter;
    TeamDTO expeditionTeam;
    TeamDTO homeTeam;
    PlayerDTO pitcher;
    PlayerDTO hitter;
    TeamLogDTO teamLog;
}
