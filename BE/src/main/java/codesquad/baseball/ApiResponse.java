package codesquad.baseball;

import codesquad.baseball.DTO.HistoryDTO;
import codesquad.baseball.DTO.PlayerDTO;
import codesquad.baseball.DTO.TeamDTO;

import java.util.ArrayList;
import java.util.List;

public class ApiResponse {
    TeamDTO teamLeft;
    TeamDTO teamRight;

    PlayerDTO Pitcher;
    PlayerDTO Hitter;

    List<HistoryDTO> historyDTOList;
}
