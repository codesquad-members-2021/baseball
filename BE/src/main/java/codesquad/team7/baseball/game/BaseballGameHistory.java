package codesquad.team7.baseball.game;

import org.springframework.data.annotation.Id;

public class BaseballGameHistory {

    @Id
    private Long baseballGameHistory;
    private Long gameId;

    private Pitch pitch;
    private String state;
}
