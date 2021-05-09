package team9.baseball.DTO.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import team9.baseball.domain.aggregate.game.Game;
import team9.baseball.domain.aggregate.game.Inning;
import team9.baseball.domain.aggregate.team.Team;
import team9.baseball.domain.enums.Halves;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GameHistoryDTO {
    private TeamHistoryDTO awayTeam;
    private TeamHistoryDTO homeTeam;

    public static GameHistoryDTO of(Game game, Team awayTeam, Team homeTeam) {
        List<Integer> awayScores = acquireScores(game, Halves.TOP);
        List<Integer> homeScores = acquireScores(game, Halves.BOTTOM);

        int awayPlayingUniformNumber = game.getAwayPlayingUniformNumber();
        int homePlayingUniformNumber = game.getHomePlayingUniformNumber();

        List<BattingHistoryDTO> awayBattingHistories = acquireBattingHistoryDTOList(game, awayTeam, awayPlayingUniformNumber);
        List<BattingHistoryDTO> homeBattingHistories = acquireBattingHistoryDTOList(game, homeTeam, homePlayingUniformNumber);

        return builder()
                .awayTeam(TeamHistoryDTO.builder()
                        .teamName(awayTeam.getName())
                        .scores(awayScores)
                        .battingHistory(awayBattingHistories)
                        .build())
                .homeTeam(TeamHistoryDTO.builder()
                        .teamName(homeTeam.getName())
                        .scores(homeScores)
                        .battingHistory(homeBattingHistories)
                        .build())
                .build();
    }

    private static List<Integer> acquireScores(Game game, Halves halves) {
        return game.getInningMap().values().stream().
                filter(x -> x.getHalves() == halves)
                .sorted(Comparator.comparingInt(Inning::getInning))
                .map(x -> x.getScore())
                .collect(Collectors.toList());
    }

    private static List<BattingHistoryDTO> acquireBattingHistoryDTOList(Game game, Team team, int playingUniformNumber) {
        return game.getBattingHistoryMap().values().stream()
                .filter(x -> x.getBatterTeamId() == team.getId())
                .map(x -> BattingHistoryDTO.of(team, x, playingUniformNumber))
                .collect(Collectors.toList());
    }

}
