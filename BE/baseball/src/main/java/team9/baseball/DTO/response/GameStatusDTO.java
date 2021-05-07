package team9.baseball.DTO.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import team9.baseball.domain.aggregate.game.BattingHistory;
import team9.baseball.domain.aggregate.game.Game;
import team9.baseball.domain.aggregate.game.Inning;
import team9.baseball.domain.aggregate.team.Team;
import team9.baseball.domain.enums.Halves;
import team9.baseball.domain.enums.Venue;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GameStatusDTO {
    private int strike;

    private int ball;

    private int out;

    private TeamDTO away_team;

    private TeamDTO home_team;

    private String inning;

    private String halves;

    private PlayerDTO pitcher;

    private String pitcher_status;

    private PlayerDTO batter;

    private String batter_status;

    private PlayerDTO base1;

    private PlayerDTO base2;

    private PlayerDTO base3;

    private List<PitchHistoryDTO> pitch_histories;

    private String my_role;

    public static GameStatusDTO of(Game game, Team awayTeam, Team homeTeam, Venue userVenue) {
        Team attackTeam = game.acquireAttackTeam(awayTeam, homeTeam);
        Team defenseTeam = game.acquireDefenseTeam(awayTeam, homeTeam);

        TeamDTO awayTeamDTO = TeamDTO.of(awayTeam.getName(), game.getTotalScore(Halves.TOP),
                acquireCurrentRole(game.getCurrentHalves(), Halves.TOP));
        TeamDTO homeTeamDTO = TeamDTO.of(homeTeam.getName(), game.getTotalScore(Halves.BOTTOM),
                acquireCurrentRole(game.getCurrentHalves(), Halves.BOTTOM));


        BattingHistory batterHistory = game.acquireBattingHistory(attackTeam.getId(), game.getBatterUniformNumber());
        String batterStatus = acquireBatterStatus(batterHistory);
        String pitcherStatus = acquirePitcherStatus(game, defenseTeam.getId(), game.getPitcherUniformNumber());

        String myRole = userVenue.getHalves() == game.getCurrentHalves() ? "ATTACK" : "DEFENSE";

        return builder()
                .strike(game.getStrikeCount())
                .ball(game.getBallCount())
                .out(game.getOutCount())
                .away_team(awayTeamDTO)
                .home_team(homeTeamDTO)
                .inning(game.getCurrentInning().toString())
                .halves(game.getCurrentHalves().name())
                .pitcher(PlayerDTO.of(defenseTeam, game.getPitcherUniformNumber()))
                .pitcher_status(pitcherStatus)
                .batter(PlayerDTO.of(attackTeam, game.getBatterUniformNumber()))
                .batter_status(batterStatus)
                .base1(PlayerDTO.of(attackTeam, game.getBase1UniformNumber()))
                .base2(PlayerDTO.of(attackTeam, game.getBase2UniformNumber()))
                .base3(PlayerDTO.of(attackTeam, game.getBase3UniformNumber()))
                .pitch_histories(acquirePitchHistories(game.acquireCurrentInning()))
                .my_role(myRole)
                .build();
    }

    private static String acquireBatterStatus(BattingHistory batterHistory) {
        return String.format("%d타석 %d안타", batterHistory.getAppear(), batterHistory.getHits());
    }

    private static String acquirePitcherStatus(Game game, int pitcherTeamId, int pitcherUniformNumber) {
        long pitcherCount = game.getInningMap().values().stream()
                .flatMap(inning -> inning.getPitchHistoryList().stream())
                .filter(pitchHistory -> pitchHistory.getPitcherTeamId() == pitcherTeamId &&
                        pitchHistory.getPitcherUniformNumber() == pitcherUniformNumber)
                .count();

        return "#" + pitcherCount;
    }

    private static List<PitchHistoryDTO> acquirePitchHistories(Inning inning) {
        return inning.getPitchHistoryList().stream().
                map(pitchHistory -> PitchHistoryDTO.of(pitchHistory)).
                collect(Collectors.toList());
    }

    private static String acquireCurrentRole(Halves currentHalves, Halves halves) {
        if (currentHalves == halves) {
            return "ATTACK";
        }
        return "DEFENSE";
    }

}
