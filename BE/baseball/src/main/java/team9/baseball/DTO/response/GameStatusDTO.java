package team9.baseball.DTO.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import team9.baseball.domain.aggregate.game.Game;
import team9.baseball.domain.aggregate.game.Inning;
import team9.baseball.domain.aggregate.team.Team;
import team9.baseball.domain.enums.Halves;
import team9.baseball.domain.enums.Venue;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GameStatusDTO {
    private int strike;

    private int ball;

    private int out;

    private TeamDTO awayTeam;

    private TeamDTO homeTeam;

    private String inning;

    private String halves;

    private PlayerDTO pitcher;

    private String pitcherStatus;

    private PlayerDTO batter;

    private String batterStatus;

    private PlayerDTO base1;

    private PlayerDTO base2;

    private PlayerDTO base3;

    private List<PitchHistoryDTO> pitchHistories;

    private String myRole;

    public static GameStatusDTO of(Game game, Team awayTeam, Team homeTeam, Venue userVenue) {
        Team attackTeam = game.acquireAttackTeam(awayTeam, homeTeam);
        Team defenseTeam = game.acquireDefenseTeam(awayTeam, homeTeam);

        TeamDTO awayTeamDTO = TeamDTO.of(awayTeam.getName(), game.getTotalScore(Halves.TOP),
                acquireCurrentRole(game.getCurrentHalves(), Halves.TOP));
        TeamDTO homeTeamDTO = TeamDTO.of(homeTeam.getName(), game.getTotalScore(Halves.BOTTOM),
                acquireCurrentRole(game.getCurrentHalves(), Halves.BOTTOM));

        String myRole = userVenue.getHalves() == game.getCurrentHalves() ? "ATTACK" : "DEFENSE";

        return builder()
                .strike(game.getStrikeCount())
                .ball(game.getBallCount())
                .out(game.getOutCount())
                .awayTeam(awayTeamDTO)
                .homeTeam(homeTeamDTO)
                .inning(game.getCurrentInning().toString())
                .halves(game.getCurrentHalves().name())
                .pitcher(PlayerDTO.of(defenseTeam, game.getPitcherUniformNumber()))
                .pitcherStatus(game.acquirePitcherStatus())
                .batter(PlayerDTO.of(attackTeam, game.getBatterUniformNumber()))
                .batterStatus(game.acquireBatterStatus())
                .base1(PlayerDTO.of(attackTeam, game.getBase1UniformNumber()))
                .base2(PlayerDTO.of(attackTeam, game.getBase2UniformNumber()))
                .base3(PlayerDTO.of(attackTeam, game.getBase3UniformNumber()))
                .pitchHistories(acquirePitchHistories(attackTeam, defenseTeam, game.acquireCurrentInning()))
                .myRole(myRole)
                .build();
    }

    private static List<PitchHistoryDTO> acquirePitchHistories(Team attackTeam, Team defenseTeam, Inning inning) {
        return inning.getPitchHistoryList().stream().
                map(pitchHistory -> PitchHistoryDTO.of(attackTeam, defenseTeam, pitchHistory)).
                collect(Collectors.toList());
    }

    private static String acquireCurrentRole(Halves currentHalves, Halves halves) {
        if (currentHalves == halves) {
            return "ATTACK";
        }
        return "DEFENSE";
    }

}
