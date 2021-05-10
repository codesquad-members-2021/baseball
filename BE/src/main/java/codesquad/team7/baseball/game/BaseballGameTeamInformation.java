package codesquad.team7.baseball.game;

import codesquad.team7.baseball.team.Team;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;

import java.util.List;
import java.util.stream.Collectors;

public class BaseballGameTeamInformation {

    @Id
    @Column("information_id")
    // TeamInformation 과 PlayersStatistics / TeamScores 를 OneToMany Mapping 하기 위해 추가한 id
    private final Long id;

    private final Long teamId;

    @Column("team_name")
    private final String name;

    @Embedded.Empty
    private final PlayersStatistics playersStatistics;
    @Embedded.Empty
    private final TeamScores teamScores;
    @Embedded.Empty
    private Pitcher pitcher;
    private Integer batterNumber;

    BaseballGameTeamInformation(Long id, Long teamId, String name, PlayersStatistics playersStatistics, Integer batterNumber, Pitcher pitcher, TeamScores teamScores) {
        this.id = id;
        this.teamId = teamId;
        this.name = name;
        this.playersStatistics = playersStatistics;
        this.batterNumber = batterNumber;
        this.pitcher = pitcher;
        this.teamScores = teamScores;
    }

    public static BaseballGameTeamInformation newTeamInfo(Team team) {
        return new BaseballGameTeamInformation(
                null,
                team.getId(),
                team.getName(),
                PlayersStatistics.newStatistics(team),
                0,
                new Pitcher(team.getPitcherNumber(), 0),
                TeamScores.newTeamScores()
        );
    }

    public void hit() {
        playersStatistics.hit(batterNumber);
    }

    public void out() {
        playersStatistics.out(batterNumber);
    }

    public void setNextBatter() {
        batterNumber = (batterNumber + 1) % playersStatistics.size();
    }

    public void pitch() {
        pitcher.pitchUp();
    }

    public void scoreUp(int inning) {
        teamScores.scoreUp(inning);
    }

    public Long getTeamId() {
        return teamId;
    }

    public Integer getTotalScore() {
        return teamScores.getTotalScore();
    }

    public List<PlayerStatistics> getPlayersStatistics() {
        return playersStatistics.getPlayers();
    }

    public Integer getBatter() {
        return batterNumber;
    }

    public String getTeamName() {
        return name;
    }

    public Pitcher getPitcher() {
        return pitcher;
    }

    public List<Integer> getInningScore() {
        return teamScores.getInningScore().stream()
                .map(InningScore::getInningScore)
                .collect(Collectors.toList());
    }

    public void nextInning() {
        teamScores.nextInning();
    }


}
