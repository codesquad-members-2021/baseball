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

    private TeamEnum winner;

    BaseballGame(Long id,
                 Inning inning,
                 Home home,
                 Away away,
                 List<BatterInningHistory> history,
                 TeamEnum winner) {
        this.id = id;
        this.inning = inning;
        this.home = home;
        this.away = away;
        this.history = history;
        this.winner = winner;
    }

    public static BaseballGame newGame(Team home, Team away) {
        return new BaseballGame(
                null,
                Inning.newInning(),
                Home.newInstance(home),
                Away.newInstance(away),
                new ArrayList<>(),
                null
        );
    }

    public void pitch(Pitch pitch) {
        if (winner != null) {
            return;
        }

        if (!history.isEmpty()) {
            BatterInningHistory lastHistory = history.get(history.size() - 1);
            if (lastHistory.checkBatterChangeEvent()) {
                batterChangeEvent(lastHistory);
                return;
            }
        }

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
            out(attack);
            return;
        }

        if (pitch == Pitch.STRIKE) {
            strike(attack);
        }

    }

    private void batterChangeEvent(BatterInningHistory lastHistory) {
        Pitch lastHistoryEvent = lastHistory.getPitch();
        history.clear();
        TeamInformation attack = getAttackTeam();
        attack.setNextBatter();
        inning.initStrikeAndBall();
        inning.flushHome();

        if (lastHistoryEvent == Pitch.OUT && inning.isThreeOut()) {
            TeamInformation defence = getDefenceTeam();
            defence.nextInning();
            inning.threeOut();
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
        history.add(new BatterInningHistory(Pitch.HIT, inning.getHistoryState()));
    }

    private void ball(TeamInformation attackTeam) {
        inning.ball();
        if (inning.isFourBall()) {
            inning.fourBall();
            history.add(new BatterInningHistory(Pitch.FOUR_BALL, inning.getHistoryState()));
            teamInformationHit(attackTeam);
            return;
        }
        history.add(new BatterInningHistory(Pitch.BALL, inning.getHistoryState()));
    }

    private void teamInformationHit(TeamInformation attack) {
        attack.hit();
        if (inning.homeIn()) {
            attack.scoreUp(inning.getOrdinal());
        }
    }

    private void out(TeamInformation attack) {
        inning.out();
        attack.out();
        history.add(new BatterInningHistory(Pitch.OUT, inning.getHistoryState()));
    }

    private void strike(TeamInformation attack) {
        inning.strike();
        if (inning.isThreeStrike()) {
            out(attack);
            return;
        }
        history.add(new BatterInningHistory(Pitch.STRIKE, inning.getHistoryState()));
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

    public TeamEnum getWinner() {
        return winner;
    }
}
