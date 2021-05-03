package codesquad.baseball.domain;

import org.springframework.data.annotation.Id;

public class History {
    @Id
    private Long id;
    private Long playerId;
    private String actionName;
    private int strike;
    private int ball;
    private int out;
}
