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
    private final Inning inning;

    @Embedded.Empty
    private final Home home;

    @Embedded.Empty
    private final Away away;

    @MappedCollection(idColumn = "game_id", keyColumn = "batter_inning_history_index")
    private final List<BatterInningHistory> history;

    BaseballGame(Long id,
                 Inning inning,
                 Home home,
                 Away away,
                 List<BatterInningHistory> history) {
        this.id = id;
        this.inning = inning;
        this.home = home;
        this.away = away;
        this.history = history;
    }

    public static BaseballGame newGame(Team home, Team away) {
        return new BaseballGame(
                null,
                Inning.newInning(),
                Home.newInstance(home),
                Away.newInstance(away),
                new ArrayList<>()
        );
    }

    public void pitch(Pitch pitch) {
        TeamInformation attack = getAttackTeam();
        TeamInformation defence = getDefenceTeam();

        defence.pitch();

        if (pitch == Pitch.HIT) {
            hit(attack);
            return;
        }

        if (pitch == Pitch.BALL) {
            ball(attack);
            return;
        }

        if (pitch == Pitch.OUT) {
            out(attack, defence);
            return;
        }

        if (pitch == Pitch.STRIKE) {
            strike(attack, defence);
        }

    }

    private TeamInformation getAttackTeam() {
        TeamEnum attackTeam = inning.getAttackTeam();
        if (attackTeam == TeamEnum.HOME) {
            return home;
        }
        return away;
    }

    private TeamInformation getDefenceTeam() {
        TeamEnum attackTeam = inning.getAttackTeam();
        if (attackTeam == TeamEnum.AWAY) {
            return home;
        }
        return away;
    }

    private void hit(TeamInformation attackTeam) {
        inning.hit();
        teamInformationHit(attackTeam);
    }

    private void ball(TeamInformation attackTeam) {
        inning.ball();
        if (inning.isFourBall()) {
            inning.fourBall();
            teamInformationHit(attackTeam);
        }
    }

    private void teamInformationHit(TeamInformation attack) {
        attack.hit();
        attack.setNextBatter();

        if (inning.homeIn()) {
            attack.scoreUp(inning.getOrdinal());
        }
    }

    private void out(TeamInformation attack, TeamInformation defence) {
        inning.out();
        attack.out();
        attack.setNextBatter();
        if (inning.isThreeOut()) {
            inning.threeOut();
            defence.nextInning();
        }
    }

    private void strike(TeamInformation attack, TeamInformation defence) {
        inning.strike();
        if (inning.isThreeStrike()) {
            out(attack, defence);
        }
    }

    public Long getId() {
        return id;
    }

    public TeamInformation getHomeTeamInformation() {
        return home;
    }

    public TeamInformation getAwayTeamInformation() {
        return away;
    }

    public Integer getInningOrdinal() {
        return inning.getOrdinal();
    }

    public TeamEnum getInningAttackTeam() {
        return inning.getAttackTeam();
    }

    public Integer getBatterNumber() {
        TeamInformation attack = getAttackTeam();
        return attack.getBatterNumber();
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

    public Long getHomeTeamId() {
        return home.getTeamId();

    }

    public Long getAwayTeamId() {
        return away.getTeamId();
    }

    public String getHomeTeamName() {
        return home.getTeamName();
    }

    public String getAwayTeamName() {
        return away.getTeamName();
    }
}
