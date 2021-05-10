package codesquad.team7.baseball.view;

import codesquad.team7.baseball.game.Pitcher;
import codesquad.team7.baseball.game.PlayerStatistics;
import codesquad.team7.baseball.game.TeamInformation;

import java.util.List;

public class TeamInfoView {
    private final String name;
    private final Integer score;
    private final List<? extends PlayerStatistics> players;
    private final Pitcher pitcher;

    private TeamInfoView(Builder builder) {
        this.name = builder.name;
        this.score = builder.score;
        this.players = builder.players;
        this.pitcher = builder.pitcher;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }

    public List<? extends PlayerStatistics> getPlayers() {
        return players;
    }

    public Pitcher getPitcher() {
        return pitcher;
    }

    public static class Builder {
        private final String name;
        private final Integer score;
        private final List<? extends PlayerStatistics> players;
        private final Pitcher pitcher;

        public Builder(TeamInformation teamInformation) {
            this.name = teamInformation.getTeamName();
            this.score = teamInformation.getTotalScore();
            this.players = teamInformation.getPlayersStatistics();
            this.pitcher = teamInformation.getPitcher();
        }

        public TeamInfoView build() {
            return new TeamInfoView(this);
        }

    }
}
