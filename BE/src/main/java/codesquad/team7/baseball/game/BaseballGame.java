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
    private final TeamInformationMap teamInformation;

    @Embedded.Empty
    private final Inning inning;

    private String homeUser;
    private Integer homeHistoryIndex;

    private String awayUser;
    private Integer awayHistoryIndex;

    @MappedCollection(idColumn = "game_id", keyColumn = "batter_inning_history_index")
    private final List<BatterInningHistory> history;

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

    public void pitch(Pitch pitch) {
        TeamEnum attackTeam = inning.getAttackTeam();
        teamInformation.pitch(attackTeam.opposite());

        if (pitch == Pitch.HIT) {
            hit(attackTeam);
            return;
        }

        if (pitch == Pitch.BALL) {
            ball(attackTeam);
            return;
        }

        if (pitch == Pitch.OUT) {
            out(attackTeam);
            return;
        }

        if (pitch == Pitch.STRIKE) {
            strike(attackTeam);
        }

    }

    private void hit(TeamEnum attackTeam) {
        inning.hit();
        teamInformationHit(attackTeam);
    }

    private void ball(TeamEnum attackTeam) {
        inning.ball();
        if (inning.isFourBall()) {
            inning.fourBall();
            teamInformationHit(attackTeam);
        }
    }

    private void teamInformationHit(TeamEnum attackTeam) {
        teamInformation.hit(attackTeam);
        teamInformation.setNextBatter(attackTeam);

        if (inning.homeIn()) {
            teamInformation.scoreUp(attackTeam, inning.getOrdinal());
        }
    }

    private void out(TeamEnum attackTeam) {
        inning.out();
        teamInformation.out(attackTeam);
        teamInformation.setNextBatter(attackTeam);
        if (inning.isThreeOut()) {
            inning.threeOut();
            teamInformation.nextInning(attackTeam.opposite());
        }
    }

    private void strike(TeamEnum attackTeam) {
        inning.strike();
        if (inning.isThreeStrike()) {
            out(attackTeam);
        }
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
