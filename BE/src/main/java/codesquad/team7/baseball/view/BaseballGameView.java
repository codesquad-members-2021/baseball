package codesquad.team7.baseball.view;

import codesquad.team7.baseball.game.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.ArrayList;
import java.util.List;

@JsonTypeName("game")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class BaseballGameView {

    private final TeamEnum winner;

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
        this.winner = builder.winner;
        this.home = builder.home;
        this.away = builder.away;
        this.inning = builder.inning;
        this.state = builder.state;
        this.batter = builder.batter;
        this.strike = builder.strike;
        this.ball = builder.ball;
        this.out = builder.out;
        this.history = builder.history;
        this.baseState = builder.baseState;
        this.inningScore = builder.inningScore;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public TeamEnum getWinner() {
        return winner;
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
        private final TeamEnum winner;

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

        public Builder(BaseballGame baseballGame) {
            TeamInformation homeTeamInformation = baseballGame.getHomeTeamInformation();
            TeamInformation awayTeamInformation = baseballGame.getAwayTeamInformation();

            this.winner = baseballGame.getWinner();

            this.home = new TeamInfoView.Builder(homeTeamInformation).build();
            this.away = new TeamInfoView.Builder(awayTeamInformation).build();

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

        public BaseballGameView build() {
            return new BaseballGameView(this);
        }
    }

}
