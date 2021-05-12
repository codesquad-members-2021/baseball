package codesquad.team7.baseball.game;

import codesquad.team7.baseball.team.Player;
import codesquad.team7.baseball.team.Team;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Home implements TeamInformation {

    private final Long homeTeamId;
    private final String homeTeamName;

    @MappedCollection(idColumn = "game_id", keyColumn = "inning")
    private final List<HomeInningScore> homeInningScores;

    @MappedCollection(idColumn = "game_id", keyColumn = "player_statistics_index")
    private final List<HomePlayerStatistics> playersStatistics;

    @Embedded.Empty
    private final HomePitcher homePitcher;

    private String homeUser;
    private Integer homeScore;
    private Integer homeBatterNumber;

    Home(String homeUser,
         Long homeTeamId,
         String homeTeamName,
         List<HomeInningScore> homeInningScores,
         Integer homeScore,
         List<HomePlayerStatistics> playersStatistics,
         HomePitcher homePitcher,
         Integer homeBatterNumber) {
        this.homeUser = homeUser;
        this.homeTeamId = homeTeamId;
        this.homeTeamName = homeTeamName;
        this.homeInningScores = homeInningScores;
        this.homeScore = homeScore;
        this.playersStatistics = playersStatistics;
        this.homePitcher = homePitcher;
        this.homeBatterNumber = homeBatterNumber;
    }

    public static Home newInstance(Team home) {
        List<HomePlayerStatistics> playersStatistics = new ArrayList<>();
        for (Player player : home.getPlayers()) {
            playersStatistics.add(HomePlayerStatistics.newInstance(player));
        }
        return new Home(
                null,
                home.getId(),
                home.getName(),
                new ArrayList<>(),
                0,
                playersStatistics,
                new HomePitcher(home.getPitcherNumber(), 0),
                0
        );
    }

    private PlayerStatistics getBatter() {
        return playersStatistics.get(homeBatterNumber);
    }

    @Override
    public void pitch() {
        homePitcher.pitchUp();
    }

    @Override
    public void hit() {
        PlayerStatistics player = getBatter();
        player.hit();
    }

    @Override
    public void out() {
        PlayerStatistics player = getBatter();
        player.out();
    }

    @Override
    public void setNextBatter() {
        homeBatterNumber = (homeBatterNumber + 1) % playersStatistics.size();
    }

    @Override
    public void scoreUp(Integer ordinal) {
        homeScore++;
        HomeInningScore inningScore = homeInningScores.get(ordinalIndex(ordinal));
        inningScore.scoreUp();
    }

    private Integer ordinalIndex(Integer ordinal) {
        return ordinal - 1;
    }

    @Override
    public void nextInning() {
        homeInningScores.add(new HomeInningScore(0));
    }

    @Override
    public Integer getBatterNumber() {
        return homeBatterNumber;
    }

    @Override
    public Long getTeamId() {
        return homeTeamId;
    }

    @Override
    public String getTeamName() {
        return homeTeamName;
    }

    @Override
    public Integer getTotalScore() {
        return homeScore;
    }

    @Override
    public List<? extends PlayerStatistics> getPlayersStatistics() {
        return playersStatistics;
    }

    @Override
    public Pitcher getPitcher() {
        return homePitcher;
    }

    @Override
    public List<Integer> getInningScore() {
        return homeInningScores
                .stream()
                .map(HomeInningScore::getInningScore)
                .collect(Collectors.toList());
    }
}
