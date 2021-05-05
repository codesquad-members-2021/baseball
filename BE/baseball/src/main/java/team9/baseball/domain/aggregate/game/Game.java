package team9.baseball.domain.aggregate.game;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import team9.baseball.domain.aggregate.team.Player;
import team9.baseball.domain.aggregate.team.Team;
import team9.baseball.domain.enums.Halves;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Game {
    @Id
    private Long id;

    private Integer awayTeamId;

    private Integer homeTeamId;

    private Integer currentInning;

    private Halves currentHalves;

    private Integer pitcherUniformNumber;

    private Integer batterUniformNumber;

    private Integer base1UniformNumber;

    private Integer base2UniformNumber;

    private Integer base3UniformNumber;

    @MappedCollection(idColumn = "game_id", keyColumn = "key_in_game")
    private Map<String, BattingHistory> battingHistoryMap = new HashMap<>();

    @MappedCollection(idColumn = "game_id", keyColumn = "key_in_game")
    private Map<String, Inning> inningMap = new HashMap<>();

    public Game(Team awayTeam, Team homeTeam) {
        this.awayTeamId = awayTeam.getId();
        this.homeTeamId = homeTeam.getId();
        this.pitcherUniformNumber = awayTeam.getFirstPlayer().getId();
        this.batterUniformNumber = homeTeam.getFirstPlayer().getId();

        initializeBattingHistory(awayTeam);
        initializeBattingHistory(homeTeam);

        this.currentInning = 1;
        this.currentHalves = Halves.TOP;
        Inning firstInning = new Inning(currentInning, currentHalves);
        this.inningMap.put(firstInning.getKeyInGame(), firstInning);
    }

    private void initializeBattingHistory(Team team) {
        for (Player player : team.getPlayerMap().values()) {
            BattingHistory battingHistory = new BattingHistory(team.getId(), player.getUniformNumber());
            this.battingHistoryMap.put(battingHistory.getKeyInGame(), battingHistory);
        }
    }
}
