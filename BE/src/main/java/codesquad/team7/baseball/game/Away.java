package codesquad.team7.baseball.game;

import codesquad.team7.baseball.team.Player;
import codesquad.team7.baseball.team.Team;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Away implements TeamInformation {

    private String awayUser;

    private final Long awayTeamId;
    private final String awayTeamName;

    @MappedCollection(idColumn = "game_id", keyColumn = "inning")
    private final List<AwayInningScore> awayInningScores;
    private Integer awayScore;

    @MappedCollection(idColumn = "game_id", keyColumn = "player_statistics_index")
    private final List<AwayPlayerStatistics> playersStatistics;

    @Embedded.Empty
    private final AwayPitcher awayPitcher;
    private Integer awayBatterNumber;

    Away(String awayUser,
         Long awayTeamId,
         String awayTeamName,
         List<AwayInningScore> awayInningScores,
         Integer awayScore,
         List<AwayPlayerStatistics> playersStatistics,
         AwayPitcher awayPitcher,
         Integer awayBatterNumber) {
        this.awayUser = awayUser;
        this.awayTeamId = awayTeamId;
        this.awayTeamName = awayTeamName;
        this.awayInningScores = awayInningScores;
        this.awayScore = awayScore;
        this.playersStatistics = playersStatistics;
        this.awayPitcher = awayPitcher;
        this.awayBatterNumber = awayBatterNumber;
    }

    public static Away newInstance(Team away) {
        List<AwayPlayerStatistics> playersStatistics = new ArrayList<>();
        for (Player player : away.getPlayers()) {
            playersStatistics.add(AwayPlayerStatistics.newInstance(player));
        }
        return new Away(
                null,
                away.getId(),
                away.getName(),
                Collections.singletonList(new AwayInningScore(0)),
                0,
                playersStatistics,
                new AwayPitcher(away.getPitcherNumber(), 0),
                0
        );
    }

    private PlayerStatistics getBatter() {
        return playersStatistics.get(awayBatterNumber);
    }

    @Override
    public void pitch() {
        awayPitcher.pitchUp();
    }

    @Override
    public void hit() {
        PlayerStatistics player = playersStatistics.get(awayBatterNumber);
        player.hit();
    }

    @Override
    public void out() {
        PlayerStatistics player = getBatter();
        player.out();
    }

    @Override
    public void setNextBatter() {
        awayBatterNumber = (awayBatterNumber + 1) % playersStatistics.size();
    }

    @Override
    public void scoreUp(Integer ordinal) {
        awayScore++;
        AwayInningScore inningScore = awayInningScores.get(ordinalIndex(ordinal));
        inningScore.scoreUp();
    }

    private Integer ordinalIndex(Integer ordinal) {
        return ordinal - 1;
    }

    @Override
    public void nextInning() {
        awayInningScores.add(new AwayInningScore(0));
    }

    @Override
    public Integer getBatterNumber() {
        return awayBatterNumber;
    }

    @Override
    public Long getTeamId() {
        return awayTeamId;
    }

    @Override
    public String getTeamName() {
        return awayTeamName;
    }

    @Override
    public Integer getTotalScore() {
        return awayScore;
    }

    @Override
    public List<? extends PlayerStatistics> getPlayersStatistics() {
        return playersStatistics;
    }

    @Override
    public Pitcher getPitcher() {
        return awayPitcher;
    }

    @Override
    public List<Integer> getInningScore() {
        return awayInningScores
                .stream()
                .map(AwayInningScore::getInningScore)
                .collect(Collectors.toList());
    }
}
