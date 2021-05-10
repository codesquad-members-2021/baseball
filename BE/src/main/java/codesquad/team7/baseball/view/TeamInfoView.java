package codesquad.team7.baseball.view;

import codesquad.team7.baseball.game.BaseballGameTeamInformation;
import codesquad.team7.baseball.game.Pitcher;
import codesquad.team7.baseball.game.PlayersStatistics;
import codesquad.team7.baseball.team.Player;
import codesquad.team7.baseball.team.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamInfoView {
    private final String name;
    private final Integer score;
    private final List<PlayerStatisticsView> players;
    private final Pitcher pitcher;

    private TeamInfoView(Builder builder) {
        this.name = builder.name;
        this.score = builder.score;
        this.players = builder.players;
        this.pitcher = builder.pitcher;
    }

    public static class Builder {
        private final String name;
        private final Integer score;
        private final List<PlayerStatisticsView> players;
        private final Pitcher pitcher;

        public Builder (Team team, BaseballGameTeamInformation teamInformation) {
            this.name = team.getName();
            this.score = teamInformation.getTotalScore();
            this.players = buildPlayerStatistics(team, teamInformation);
            this.pitcher = new Pitcher(
                    team.getPitcherNumber(),
                    teamInformation.getPitches()
            );
        }

        private List<PlayerStatisticsView> buildPlayerStatistics(Team team, BaseballGameTeamInformation teamInformation) {
            List<PlayerStatisticsView> players = new ArrayList<>();

            List<Player> playersName = team.getPlayers();
            PlayersStatistics playersStatistics = teamInformation.getPlayersStatistics();

            for (int i = 0; i < playersName.size(); i++) {
                players.add(PlayerStatisticsView.of(playersName.get(i), playersStatistics.get(i)));
            }

            return players;
        }

        public TeamInfoView build() {
            return new TeamInfoView(this);
        }

    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }

    public List<PlayerStatisticsView> getPlayers() {
        return players;
    }

    public Pitcher getPitcher() {
        return pitcher;
    }
}
