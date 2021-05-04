package codesquad.team7.baseball.game;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class BaseballGameTeamInformation {

    @Id
    private Long gameTeamInfoId;

    private Long teamId;

    @Transient
    private Team team;
    private PlayersStatistics players;

    private Integer score;
    private Integer pitches;

}
