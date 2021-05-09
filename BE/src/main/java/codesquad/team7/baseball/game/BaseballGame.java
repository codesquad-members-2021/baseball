package codesquad.team7.baseball.game;

import codesquad.team7.baseball.team.Team;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    @Id
    @Column("game_id")
    private final Long id;

    @Embedded.Empty
    private TeamInformationMap teamInformation;

    @Embedded.Empty
    private Inning inning;

    private String homeUser;
    private Integer homeHistoryIndex;

    private String awayUser;
    private Integer awayHistoryIndex;

    @MappedCollection(idColumn = "game_id", keyColumn = "batter_inning_history_index")
    private List<BatterInningHistory> history;

    BaseballGame(Long id, TeamInformationMap teamInformation, Inning inning, Integer homeHistoryIndex, Integer awayHistoryIndex, List<BatterInningHistory> history) {
        this.id = id;
        this.teamInformation = teamInformation;
        this.inning = inning;
        this.homeHistoryIndex = homeHistoryIndex;
        this.awayHistoryIndex = awayHistoryIndex;
        this.history = history;
    }

    public static BaseballGame newGame(Team home, Team away) {
        return new BaseballGame(
                null,
                TeamInformationMap.newTeamInformation(home, away),
                Inning.newInning(),
                0,
                0,
                new ArrayList<>()
        );
    }

    public Long getId() {
        return id;
    }

    public BaseballGameTeamInformation getHomeTeamInformation() {
        return teamInformation.getHome();
    }

    public BaseballGameTeamInformation getAwayTeamInformation() {
        return teamInformation.getAway();
    }

    public Integer getInningOrdinal() {
        return inning.getOrdinal();
    }

    public TeamEnum getInningAttackTeam() {
        return inning.getAttackTeam();
    }

    public Integer getBatterNumber() {
        return teamInformation.getBatter(inning.getAttackTeam());
    }

    public Integer getStrike() {
        return inning.getStrike();
    }

    public Integer getBall() {
        return inning.getBall();
    }

    public Integer getOut() {
        return inning.getOut();
    }

    public BaseState getBase() {
        return inning.getBaseState();
    }

    public List<BatterInningHistory> getHistory() {
        return history;
    }
}
