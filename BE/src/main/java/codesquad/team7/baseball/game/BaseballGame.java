package codesquad.team7.baseball.game;

import org.springframework.data.annotation.Id;

public class BaseballGame {

    @Id
    private Long gameId;

    private BaseballGameTeamInformation home;
    private BaseballGameTeamInformation away;

    private Inning inning;

    private BaseballGameHistory history;

    private InningScore inningScore;

}
