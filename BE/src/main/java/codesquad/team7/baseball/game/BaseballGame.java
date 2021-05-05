package codesquad.team7.baseball.game;

import codesquad.team7.baseball.team.Team;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    @Id
    private Long gameId;

    @Embedded.Empty
    private BaseballGameTeamInformationMap teamInformation;

    @Embedded.Empty
    private Inning inning;

    private Integer homeHistoryIndex;
    private Integer awayHistoryIndex;

    private List<BaseballGameInningHistory> history;

    BaseballGame(Long gameId, BaseballGameTeamInformationMap teamInformation, Inning inning, Integer homeHistoryIndex, Integer awayHistoryIndex, List<BaseballGameInningHistory> history) {
        this.gameId = gameId;
        this.teamInformation = teamInformation;
        this.inning = inning;
        this.homeHistoryIndex = homeHistoryIndex;
        this.awayHistoryIndex = awayHistoryIndex;
        this.history = history;
    }

    public Long getGameId() {
        return gameId;
    }

    public BaseballGameTeamInformationMap getTeamInformation() {
        return teamInformation;
    }

    public Inning getInning() {
        return inning;
    }

    public List<BaseballGameInningHistory> getHistory() {
        return history;
    }

    public static BaseballGame newGame(Team home, Team away) {
        return new BaseballGame(
                0L,
                BaseballGameTeamInformationMap.newTeamInformation(home, away),
                Inning.newInning(),
                0,
                0,
                new ArrayList<>()
        );
    }
}
