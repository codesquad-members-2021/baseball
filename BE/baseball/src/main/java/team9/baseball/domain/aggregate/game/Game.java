package team9.baseball.domain.aggregate.game;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import team9.baseball.domain.aggregate.team.Team;
import team9.baseball.domain.enums.GameStatus;
import team9.baseball.domain.enums.Halves;
import team9.baseball.domain.enums.PitchResult;
import team9.baseball.exception.BadStatusException;
import team9.baseball.exception.NotFoundException;

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

    private GameStatus status;

    @MappedCollection(idColumn = "game_id", keyColumn = "key_in_game")
    private Map<String, BattingHistory> battingHistoryMap = new HashMap<>();

    @MappedCollection(idColumn = "game_id", keyColumn = "key_in_game")
    private Map<String, Inning> inningMap = new HashMap<>();

    public Game(Team awayTeam, Team homeTeam) {
        this.awayTeamId = awayTeam.getId();
        this.homeTeamId = homeTeam.getId();
        initializeBattingHistory(awayTeam);
        initializeBattingHistory(homeTeam);

        this.pitcherUniformNumber = homeTeam.getFirstPlayerUniformNumber();
        sendBatterOnPlate(awayTeamId, awayTeam.getFirstPlayerUniformNumber());

        this.currentInning = 1;
        this.currentHalves = Halves.TOP;
        this.inningMap.put(Inning.acquireKeyInGame(currentInning, currentHalves), new Inning(currentInning, currentHalves));

        this.status = GameStatus.WAITING;
    }

    private void initializeBattingHistory(Team team) {
        for (Integer uniform_number : team.getPlayerMap().keySet()) {
            String key = BattingHistory.acquireKeyInGame(team.getId(), uniform_number);
            BattingHistory battingHistory = new BattingHistory(team.getId(), uniform_number);
            this.battingHistoryMap.put(key, battingHistory);
        }
    }

    public void checkWaiting() {
        if (this.status != GameStatus.WAITING) {
            throw new BadStatusException("대기중인 게임이 아닙니다.");
        }
    }

    public void checkPlaying() {
        if (this.status != GameStatus.PLAYING) {
            throw new BadStatusException("진행중인 게임이 아닙니다.");
        }
    }

    public void proceedStrike(Team awayTeam, Team homeTeam) {
        //카운트 증가
        this.strikeCount++;
        //기록할 pitch history 생성
        PitchHistory pitchHistory = new PitchHistory(acquireDefenseTeamId(), pitcherUniformNumber,
                acquireAttackTeamId(), batterUniformNumber, PitchResult.STRIKE, this.strikeCount, this.ballCount);
        //현재 이닝에 pitch history 기록
        acquireCurrentInning().pitchHistoryList.add(pitchHistory);

        //삼진 아웃 처리
        if (strikeCount == 3) {
            proceedOut(awayTeam, homeTeam);
        }
    }

    public void proceedBall(Team awayTeam, Team homeTeam) {
        //카운트 증가
        this.ballCount++;
        //기록할 pitch history 생성
        PitchHistory pitchHistory = new PitchHistory(acquireDefenseTeamId(), pitcherUniformNumber,
                acquireAttackTeamId(), batterUniformNumber, PitchResult.BALL, this.strikeCount, this.ballCount);
        //현재 이닝에 pitch history 기록
        acquireCurrentInning().pitchHistoryList.add(pitchHistory);

        //볼넷일 경우 출루하고 다음 타자 등판
        if (ballCount == 4) {
            sendBatterOnBase();

            Team attackTeam = acquireAttackTeam(awayTeam, homeTeam);
            sendBatterOnPlate(attackTeam.getId(), attackTeam.getNextPlayerUniformNumber(batterUniformNumber));
        }
    }

    public void proceedHit(Team awayTeam, Team homeTeam) {
        //기록할 pitch history 생성
        PitchHistory pitchHistory = new PitchHistory(acquireDefenseTeamId(), pitcherUniformNumber,
                acquireAttackTeamId(), batterUniformNumber, PitchResult.HIT, this.strikeCount, this.ballCount);
        //현재 이닝에 pitch history 기록
        acquireCurrentInning().pitchHistoryList.add(pitchHistory);

        //타자의 battingHistory 에 타수 카운트 추가
        Team attackTeam = acquireAttackTeam(awayTeam, homeTeam);
        BattingHistory battingHistory = acquireBattingHistory(attackTeam.getId(), batterUniformNumber);
        battingHistory.plusHits();

        //타자 출루
        sendBatterOnBase();

        //타석에 다음 타자 등판
        sendBatterOnPlate(attackTeam.getId(), attackTeam.getNextPlayerUniformNumber(batterUniformNumber));
    }

    public int getTotalScore(Halves halves) {
        return inningMap.values().stream().filter(x -> x.getHalves() == halves).mapToInt(x -> x.getScore()).sum();
    }

    public Team acquireAttackTeam(Team awayTeam, Team homeTeam) {
        if (currentHalves == Halves.TOP) {
            return awayTeam;
        }
        return homeTeam;
    }

    public Team acquireDefenseTeam(Team awayTeam, Team homeTeam) {
        if (currentHalves == Halves.TOP) {
            return homeTeam;
        }
        return awayTeam;
    }

    public Inning acquireCurrentInning() {
        String currentInningKey = Inning.acquireKeyInGame(currentInning, currentHalves);
        return inningMap.get(currentInningKey);
    }

    private BattingHistory acquireBattingHistory(int batterTeamId, int batterUniformNumber) {
        String key = BattingHistory.acquireKeyInGame(batterTeamId, batterUniformNumber);
        if (!battingHistoryMap.containsKey(key)) {
            throw new NotFoundException(String.format("%d번 게임방에 %d팀 %d 번호 선수에 대한 기록이 없습니다.",
                    this.id, batterTeamId, batterUniformNumber));
        }
        return battingHistoryMap.get(key);
    }

    public String acquireBatterStatus() {
        int attackTeamId = acquireAttackTeamId();
        BattingHistory batterHistory = acquireBattingHistory(attackTeamId, this.batterUniformNumber);
        return batterHistory.getStatus();
    }

    public String acquirePitcherStatus() {
        int defenseTeamId = acquireDefenseTeamId();
        long pitcherCount = inningMap.values().stream()
                .flatMap(inning -> inning.getPitchHistoryList().stream())
                .filter(pitchHistory -> pitchHistory.hasMatchedPitcher(defenseTeamId, this.pitcherUniformNumber))
                .count();

        return "#" + pitcherCount;
    }

    public Integer getAwayPlayingUniformNumber() {
        return this.currentHalves == Halves.TOP ? batterUniformNumber : pitcherUniformNumber;
    }

    public Integer getHomePlayingUniformNumber() {
        return this.currentHalves == Halves.BOTTOM ? batterUniformNumber : pitcherUniformNumber;
    }

    private void proceedOut(Team awayTeam, Team homeTeam) {
        //아웃 카운트 증가
        this.outCount++;

        //타자의 battingHistory 에 아웃 카운트 추가
        String battingHistoryKey = BattingHistory.acquireKeyInGame(acquireAttackTeamId(), batterUniformNumber);
        BattingHistory battingHistory = battingHistoryMap.get(battingHistoryKey);
        battingHistory.plusOut();

        //3회 아웃이면 다음이닝으로 변경
        if (outCount == 3) {
            goToNextInning(awayTeam, homeTeam);
            return;
        }

        //타석에 다음 타자 등판
        Team attackTeam = acquireAttackTeam(awayTeam, homeTeam);
        sendBatterOnPlate(attackTeam.getId(), attackTeam.getNextPlayerUniformNumber(batterUniformNumber));
    }

    private void sendBatterOnBase() {
        //3루에 주자가 있었다면 득점
        if (this.base3UniformNumber != null) {
            acquireCurrentInning().plusScore();
        }

        //선수들 1루씩 이동
        this.base3UniformNumber = this.base2UniformNumber;
        this.base2UniformNumber = this.base1UniformNumber;
        this.base1UniformNumber = this.batterUniformNumber;
    }

    private void goToNextInning(Team awayTeam, Team homeTeam) {
        //게임 종료 상황이면 다음이닝으로 넘어가지 않고 게임종료
        if (isExited()) {
            this.status = GameStatus.EXITED;
            return;
        }

        //카운트 초기화
        this.strikeCount = 0;
        this.ballCount = 0;
        this.outCount = 0;
        this.base1UniformNumber = null;
        this.base2UniformNumber = null;
        this.base3UniformNumber = null;

        //다음 이닝으로 변경
        if (this.currentHalves == Halves.BOTTOM) {
            this.currentHalves = Halves.TOP;
            this.currentInning += 1;
        } else {
            this.currentHalves = Halves.BOTTOM;
        }
        this.inningMap.put(Inning.acquireKeyInGame(currentInning, currentHalves), new Inning(currentInning, currentHalves));

        //현재 이닝의 공격팀 수비팀 확인
        Team attackTeam = acquireAttackTeam(awayTeam, homeTeam);
        Team defenseTeam = acquireDefenseTeam(awayTeam, homeTeam);

        //수비팀의 투수 설정 (직전 타자의 다음 순서가 투수가 됨)
        int nextPitcherUniformNumber = defenseTeam.getNextPlayerUniformNumber(batterUniformNumber);
        //공격팀 타자 설정 (직전 투수의 다음 등번호가 타자가 됨)
        int nextBatterUniformNumber = attackTeam.getNextPlayerUniformNumber(pitcherUniformNumber);
        this.pitcherUniformNumber = nextPitcherUniformNumber;
        sendBatterOnPlate(attackTeam.getId(), nextBatterUniformNumber);
    }

    private boolean isExited() {
        if (currentInning == 9 && currentHalves == Halves.BOTTOM &&
                getTotalScore(Halves.TOP) != getTotalScore(Halves.BOTTOM)) {
            return true;
        }
        if (currentInning == 12 && currentHalves == Halves.BOTTOM) {
            return true;
        }

        return false;
    }

    private void sendBatterOnPlate(int batterTeamId, int nextBatterUniformNumber) {
        //카운트 초기화
        this.strikeCount = 0;
        this.ballCount = 0;

        //타석에 다음 선수 등판
        this.batterUniformNumber = nextBatterUniformNumber;

        //선수의 BatterHistory 에 타석 카운트 추가
        String battingHistoryKey = BattingHistory.acquireKeyInGame(batterTeamId, batterUniformNumber);
        BattingHistory battingHistory = battingHistoryMap.get(battingHistoryKey);
        battingHistory.plusAppear();
    }

    private int acquireAttackTeamId() {
        if (currentHalves == Halves.TOP) {
            return awayTeamId;
        }
        return homeTeamId;
    }

    private int acquireDefenseTeamId() {
        if (currentHalves == Halves.TOP) {
            return homeTeamId;
        }
        return awayTeamId;
    }
}
