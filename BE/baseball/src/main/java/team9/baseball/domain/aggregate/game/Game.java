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

    private int strikeCount;

    private int ballCount;

    private int outCount;

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

    private void goToNextInning(Team homeTeam, Team awayTeam) {
        //카운트 초기화
        this.strikeCount = 0;
        this.ballCount = 0;
        this.outCount = 0;

        //다음 이닝으로 변경
        this.currentInning += 1;
        this.currentHalves = currentHalves == Halves.TOP ? Halves.BOTTOM : Halves.TOP;
        Inning inning = new Inning(currentInning, currentHalves);
        this.inningMap.put(inning.getKeyInGame(), inning);

        //현재 이닝의 공격팀 수비팀 설정
        Team attackTeam = getAttackTeam(awayTeam, homeTeam);
        Team defenseTeam = getDefenseTeam(awayTeam, homeTeam);

        //공격팀의 타자, 수비팀의 타자 설정
        int nextPitcherUniformNumber = defenseTeam.getNextPlayer(this.batterUniformNumber).getUniformNumber();
        int nextBatterUniformNumber = attackTeam.getNextPlayer(this.pitcherUniformNumber).getUniformNumber();
        this.pitcherUniformNumber = nextPitcherUniformNumber;
        this.batterUniformNumber = nextBatterUniformNumber;
    }

    private Team getAttackTeam(Team awayTeam, Team homeTeam) {
        if (currentHalves == Halves.TOP) {
            return awayTeam;
        }
        return homeTeam;
    }

    private Team getDefenseTeam(Team awayTeam, Team homeTeam) {
        if (currentHalves == Halves.TOP) {
            return homeTeam;
        }
        return awayTeam;
    }
}
