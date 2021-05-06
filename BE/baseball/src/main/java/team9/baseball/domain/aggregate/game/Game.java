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


    public void proceedStrike(Team awayTeam, Team homeTeam) {
        //카운트 증가
        this.strikeCount++;

        //삼진 아웃
        if (strikeCount == 3) {
            proceedOut(awayTeam, homeTeam);
        }
    }

    public void proceedHit(Team awayTeam, Team homeTeam) {
        Team attackTeam = getAttackTeam(awayTeam, homeTeam);

        //타자의 battingHistory 에 타수 카운트 추가
        String battingHistoryKey = BattingHistory.getKeyInGame(attackTeam.getId(), batterUniformNumber);
        BattingHistory battingHistory = battingHistoryMap.get(battingHistoryKey);
        battingHistory.plusHits();

        //타자 출루
        sendBatterOnBase();

        //타석에 다음 타자 등판
        sendBatterOnPlate(attackTeam);
    }

    private void proceedOut(Team awayTeam, Team homeTeam) {
        //아웃 카운트 증가
        this.outCount++;

        //3회 아웃이면 다음이닝으로 변경
        if (outCount == 3) {
            goToNextInning(awayTeam, homeTeam);
            return;
        }

        //타석에 다음 타자 등판
        Team attackTeam = getAttackTeam(awayTeam, homeTeam);
        sendBatterOnPlate(attackTeam);
    }

    private void sendBatterOnBase() {
        String currentInningKey = Inning.getKeyInGame(currentInning, currentHalves);
        Inning inning = inningMap.get(currentInningKey);

        //3루에 주자가 있었다면 득점
        if (this.base3UniformNumber != null) {
            inning.plusScore();
        }

        //선수들 1루씩 이동
        this.base3UniformNumber = this.base2UniformNumber;
        this.base2UniformNumber = this.base1UniformNumber;
        this.base1UniformNumber = this.batterUniformNumber;
        this.batterUniformNumber = null;
    }

    private void goToNextInning(Team homeTeam, Team awayTeam) {
        //아웃 카운트 초기화
        this.outCount = 0;

        //다음 이닝으로 변경
        if (this.currentHalves == Halves.BOTTOM) {
            this.currentHalves = Halves.TOP;
            this.currentInning += 1;
        } else {
            this.currentHalves = Halves.BOTTOM;
        }
        Inning inning = new Inning(currentInning, currentHalves);
        this.inningMap.put(inning.getKeyInGame(), inning);

        //현재 이닝의 공격팀 수비팀 설정
        Team attackTeam = getAttackTeam(awayTeam, homeTeam);
        Team defenseTeam = getDefenseTeam(awayTeam, homeTeam);

        //수비팀의 투수 설정
        int nextPitcherUniformNumber = defenseTeam.getNextPlayer(this.batterUniformNumber).getUniformNumber();
        this.pitcherUniformNumber = nextPitcherUniformNumber;

        //공격팀 타자 등판
        sendBatterOnPlate(attackTeam);
    }

    private void sendBatterOnPlate(Team attackTeam) {
        //카운트 초기화
        this.strikeCount = 0;
        this.ballCount = 0;

        //타석에 다음 선수 등판
        int batterTeamId = attackTeam.getId();
        int nextBatterUniformNumber = attackTeam.getNextPlayer(this.pitcherUniformNumber).getUniformNumber();
        this.batterUniformNumber = nextBatterUniformNumber;

        //선수의 BatterHistory 에 타석 카운트 추가
        String battingHistoryKey = BattingHistory.getKeyInGame(batterTeamId, batterUniformNumber);
        BattingHistory battingHistory = battingHistoryMap.get(battingHistoryKey);
        battingHistory.plusAppear();
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
