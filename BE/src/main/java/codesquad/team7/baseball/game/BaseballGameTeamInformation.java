package codesquad.team7.baseball.game;

import codesquad.team7.baseball.team.Team;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;

public class BaseballGameTeamInformation {

    @Id
    @Column("information_id")
    private final Long id;

    private Long teamId;

    @Embedded.Empty
    private PlayersStatistics playersStatistics;

    private Integer pitches;

    @Embedded.Empty
    private TeamScores teamScores;

    BaseballGameTeamInformation(Long id, Long teamId, PlayersStatistics playersStatistics, Integer pitches, TeamScores teamScores) {
        this.id = id;
        this.teamId = teamId;
        this.playersStatistics = playersStatistics;
        this.pitches = pitches;
        this.teamScores = teamScores;
    }

    public Long getId() {
        return id;
    }

    public Long getTeamId() {
        return teamId;
    }

    public PlayersStatistics getPlayersStatistics() {
        return playersStatistics;
    }

    public Integer getPitches() {
        return pitches;
    }

    public TeamScores getTeamScores() {
        return teamScores;
    }

    public static BaseballGameTeamInformation newTeamInfo(Team team) {
        return new BaseballGameTeamInformation(
                null,
                team.getId(),
                PlayersStatistics.newStatistics(),
                0,
                TeamScores.newTeamScores()
        );
    }
}
