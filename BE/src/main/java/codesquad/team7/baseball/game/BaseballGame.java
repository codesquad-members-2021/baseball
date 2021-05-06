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

    private Integer homeHistoryIndex;
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

    public Long getId() {
        return id;
    }

    public TeamInformationMap getTeamInformation() {
        return teamInformation;
    }

    public Inning getInning() {
        return inning;
    }

    public List<BatterInningHistory> getHistory() {
        return history;
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
}
