package codesquad.team7.baseball.view;

import codesquad.team7.baseball.game.*;
import codesquad.team7.baseball.team.Team;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.ArrayList;
import java.util.List;

@JsonTypeName("game")
@JsonTypeInfo(include= JsonTypeInfo.As.WRAPPER_OBJECT,use= JsonTypeInfo.Id.NAME)
public class BaseballGameView {

    private final TeamInfoView home;
    private final TeamInfoView away;

    private final Integer inning;
    private final TeamEnum state;
    private final Integer batter;

    private final Integer strike;
    private final Integer ball;
    private final Integer out;

    private final List<BatterInningHistory> history;

    private final List<Boolean> baseState;
    private final InningScoreView inningScore;

    private BaseballGameView(Builder builder) {
        home = builder.home;
        away = builder.away;
        inning = builder.inning;
        this.state = builder.state;
        this.batter = builder.batter;
        this.strike = builder.strike;
        this.ball = builder.ball;
        this.out = builder.out;
        this.history = builder.history;
        this.baseState = builder.baseState;
        this.inningScore = builder.inningScore;
    }

    public TeamInfoView getHome() {
        return home;
    }

    public TeamInfoView getAway() {
        return away;
    }

    public Integer getInning() {
        return inning;
    }

    public TeamEnum getState() {
        return state;
    }

    public Integer getBatter() {
        return batter;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }

    public Integer getOut() {
        return out;
    }

    public List<BatterInningHistory> getHistory() {
        return history;
    }

    public List<Boolean> getBaseState() {
        return baseState;
    }

    public InningScoreView getInningScore() {
        return inningScore;
    }

    public static class Builder {
        private final TeamInfoView home;
        private final TeamInfoView away;

        private final Integer inning;
        private final TeamEnum state;
        private final Integer batter;

        private final Integer strike;
        private final Integer ball;
        private final Integer out;

        private final List<BatterInningHistory> history;

        private final List<Boolean> baseState;
        private final InningScoreView inningScore;

        public Builder(BaseballGame baseballGame, Team home, Team away) {
            BaseballGameTeamInformation homeTeamInformation = baseballGame.getHomeTeamInformation();
            BaseballGameTeamInformation awayTeamInformation = baseballGame.getAwayTeamInformation();

            this.home = new TeamInfoView.Builder(home, homeTeamInformation).build();
            this.away = new TeamInfoView.Builder(away, awayTeamInformation).build();

            this.inning = baseballGame.getInningOrdinal();
            this.state = baseballGame.getInningAttackTeam();
            this.batter = baseballGame.getBatterNumber();

            this.strike = baseballGame.getStrike();
            this.ball = baseballGame.getBall();
            this.out = baseballGame.getOut();

            this.history = baseballGame.getHistory();

            this.baseState = buildBaseStateView(baseballGame.getBase());
            this.inningScore = InningScoreView.of(homeTeamInformation, awayTeamInformation);
        }

        private List<Boolean> buildBaseStateView(BaseState baseState) {
            List<Boolean> baseStateView = new ArrayList<>();

            baseStateView.add(baseState.getFirstBase());
            baseStateView.add(baseState.getSecondBase());
            baseStateView.add(baseState.getThirdBase());
            baseStateView.add(baseState.getHomeBase());

            return baseStateView;
        }

        public BaseballGameView bulid() {
            return new BaseballGameView(this);
        }
    }

}
