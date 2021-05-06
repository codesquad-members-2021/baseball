package codesquad.baseball;

import codesquad.baseball.DTO.*;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"teamLeftScore", "teamRightScore", "teamLeft", "teamRight", "pitcher", "hitter", "teamLog"})
public class ApiResponse {
    TeamGameScoreDTO homeTeamScore;
    TeamGameScoreDTO leftTeamScore;

    TeamDTO homeTeam;
    TeamDTO awayTeam;

    PlayerDTO pitcher;
    PlayerDTO hitter;

    TeamHistoryDTO teamLog;

    PlayerListPopUpDTO homeTeamPlayerList;
    PlayerListPopUpDTO awayTeamPlayerList;
}
