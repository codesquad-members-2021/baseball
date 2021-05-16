package com.codesquad.baseball.domain;

import com.codesquad.baseball.domain.game.*;
import com.codesquad.baseball.domain.game.inning.History;
import com.codesquad.baseball.domain.game.participant.PitcherPosition;
import com.codesquad.baseball.domain.game.participant.PlayerParticipatingInGame;
import com.codesquad.baseball.domain.game.participant.TeamParticipatingInGame;
import com.codesquad.baseball.domain.game.pitch.PitchResult;
import com.codesquad.baseball.domain.team.*;
import com.codesquad.baseball.exceptions.notfound.GameNotFoundException;
import com.codesquad.baseball.exceptions.notfound.PlayerNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class GameRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(GameRepositoryTest.class);
    private static final String GAME_TITLE = "GAME 1";
    private static final String A_TEAM_NAME = "aTeam";
    private static final String B_TEAM_NAME = "bTeam";

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Test
    @DisplayName("게임을 생성할 수 있어야 합니다.")
    void testCreateGame() {
        Game game = createGame(GAME_TITLE);
        assertThat(game).isNotNull();
    }

    @Test
    @DisplayName("생성할때 입력한 제목이 게임의 제목이어야 합니다")
    void testGameTitle() {
        Game game = createGame(GAME_TITLE);
        assertThat(game.isSameTitle(GAME_TITLE)).isTrue();
    }

    @Test
    @DisplayName("양 팀은 입력한 만큼의 선수를 데리고 있어야 합니다")
    void testSizeOfPlayer() {
        Game game = createGame(GAME_TITLE);
        assertThat(game.sizeOfHomeTeam()).isEqualTo(9);
        assertThat(game.sizeOfAwayTeam()).isEqualTo(9);
    }

    @Test
    @DisplayName("생성된 게임의 초기상태의 occupied는 false여야 합니다")
    void testOccupation() {
        Game game = createGame(GAME_TITLE);
        assertThat(game.isJoinable()).isTrue();
    }

    @Test
    @DisplayName("생성된 게임의 초기상태의 1,2,3루는 비어있어야 합니다")
    void testBaseState() {
        Game game = createGame(GAME_TITLE);
        assertThat(game.isFirstBaseEmpty()).isTrue();
        assertThat(game.isSecondBaseEmpty()).isTrue();
        assertThat(game.isThirdBaseEmpty()).isTrue();
    }

    @Test
    @DisplayName("생성된 게임의 초기상태의 이닝정보는 1이닝 초여야 합니다.")
    void testInningState() {
        Game game = createGame(GAME_TITLE);
        assertThat(game.isTop()).isEqualTo(true);
        assertThat(game.currentInningNumber()).isEqualTo(1);
    }

    @Test
    @DisplayName("생성된 게임의 초기상태의 각 팀의 점수는 0점이어야 합니다")
    void testScore() {
        Game game = createGame(GAME_TITLE);
        assertThat(game.homeTeamScore()).isEqualTo(0);
        assertThat(game.awayTeamScore()).isEqualTo(0);
    }

    @Test
    @DisplayName("피치의 결과가 스트라이크인 상황을 테스트합니다")
    void testPitchIsStrike() {
        Game game = createGame(GAME_TITLE);
        int nextHitter = game.nextHitter();
        //스트라이크를 할 수 있어야 하며, 이에 대한 카운트가 증가해야 합니다
        doStrike(game);
        assertThat(game.getCurrentStrikeCount()).isEqualTo(1);
        doStrike(game);
        assertThat(game.getCurrentStrikeCount()).isEqualTo(2);
        doStrike(game);
        assertThat(game.getCurrentStrikeCount()).isEqualTo(0);
        assertThat(game.getCurrentOutCount()).isEqualTo(1);
        //스트라이크 아웃 이후의 타자는 이전에 구한 nextHitter이어야 합니다
        assertThat(game.currentHitter()).isEqualTo(nextHitter);

        //2아웃을 또 하면 초에서 말로 넘어가야 합니다
        IntStream.range(0, 2).forEach(value -> threeStrike(game));
        assertThat(game.currentInningNumber()).isEqualTo(1);
        assertThat(game.isTop()).isEqualTo(false);
        //3아웃을 하면 2이닝 초로 넘어가야 합니다다
        threeOut(game);
        assertThat(game.currentInningNumber()).isEqualTo(2);
        assertThat(game.isTop()).isEqualTo(true);
    }

    @Test
    @DisplayName("피치의 결과가 볼인 상황을 테스트합니다")
    void testPitchIsBall() {
        Game game = createGame(GAME_TITLE);
        int firstHitter = game.currentHitter();
        //1회 볼 이후엔 볼카운트 1이어야 함
        doBall(game);
        assertThat(game.getCurrentBallCount()).isEqualTo(1);
        //3회 볼 이후엔 볼 카운트가 0이어야 함
        //또한 볼넷 맞기 전의 타자가 1루에 가있어야 함
        IntStream.range(0, 3).forEach(value -> game.pitch(PlayType.BALL));
        assertThat(game.getCurrentBallCount()).isEqualTo(0);
        assertThat(game.firstBaseRunner()).isEqualTo(firstHitter);
        //볼넷맞으면 1루주자는 2루에 있어야 함
        //타자는 1루여야함
        int secondHitter = game.currentHitter();
        IntStream.range(0, 4).forEach(value -> game.pitch(PlayType.BALL));
        assertThat(game.firstBaseRunner()).isEqualTo(secondHitter);
        assertThat(game.secondBaseRunner()).isEqualTo(firstHitter);
        //볼넷 한번 더 맞으면 1번타자는 3루, 2번타자는 2루, 3번타자는 1루에 있어야 함
        int thirdHitter = game.currentHitter();
        IntStream.range(0, 4).forEach(value -> game.pitch(PlayType.BALL));
        assertThat(game.firstBaseRunner()).isEqualTo(thirdHitter);
        assertThat(game.secondBaseRunner()).isEqualTo(secondHitter);
        assertThat(game.thirdBaseRunner()).isEqualTo(firstHitter);
        //볼넷 한번 더 맞으면 1번타자는 백홈, 2번타자는 3루, 3번타자는 2루, 4번타자는 1루에 있어야 함
        int fourthHitter = game.currentHitter();
        IntStream.range(0, 3).forEach(value -> game.pitch(PlayType.BALL));
        PitchResult pitchResult = doBall(game);
        assertThat(game.firstBaseRunner()).isEqualTo(fourthHitter);
        assertThat(game.secondBaseRunner()).isEqualTo(thirdHitter);
        assertThat(game.thirdBaseRunner()).isEqualTo(secondHitter);
        assertThat(pitchResult.numberOfRunners()).isEqualTo(1);
        assertThat(pitchResult.findRunnerByOrder(0)).isEqualTo(firstHitter);
        assertThat(game.awayTeamScore()).isEqualTo(1);
        //볼넷 한번 더 맞으면 2번타자는 백홈, 3번타자는 3루, 4번타자는 2루, 5번타자는 1루에 있어야 함
        int fifthHitter = game.currentHitter();
        IntStream.range(0, 3).forEach(value -> game.pitch(PlayType.BALL));
        pitchResult = doBall(game);
        assertThat(game.firstBaseRunner()).isEqualTo(fifthHitter);
        assertThat(game.secondBaseRunner()).isEqualTo(fourthHitter);
        assertThat(game.thirdBaseRunner()).isEqualTo(thirdHitter);
        assertThat(pitchResult.numberOfRunners()).isEqualTo(1);
        assertThat(pitchResult.findRunnerByOrder(0)).isEqualTo(secondHitter);
        assertThat(game.awayTeamScore()).isEqualTo(2);
        //초에서 말로 교대 후, 4볼을 4번 맞으면 홈팀의 점수가 올라가야 합니다
        threeOut(game);
        IntStream.range(0, 16).forEach(value -> game.pitch(PlayType.BALL));
        assertThat(game.homeTeamScore()).isEqualTo(1);
    }

    @Test
    @DisplayName("피치의 결과가 안타인 상황을 테스트합니다")
    void testPitchIsHits() {
        Game game = createGame(GAME_TITLE);
        //1안타후엔 첫번째 타자가 1루에 가있어야 함
        int firstHitter = game.currentHitter();
        doHits(game);
        assertThat(game.firstBaseRunner()).isEqualTo(firstHitter);
        //2안타후엔 첫번째 타자가 2루, 두번째가 1루
        int secondHitter = game.currentHitter();
        doHits(game);
        assertThat(game.firstBaseRunner()).isEqualTo(secondHitter);
        assertThat(game.secondBaseRunner()).isEqualTo(firstHitter);
        //3안타후엔 첫번째 타자가 3루, 두번째가 2루 세번째는 3루
        int thirdHitter = game.currentHitter();
        doHits(game);
        assertThat(game.firstBaseRunner()).isEqualTo(thirdHitter);
        assertThat(game.secondBaseRunner()).isEqualTo(secondHitter);
        assertThat(game.thirdBaseRunner()).isEqualTo(firstHitter);
        //4안타후엔 첫번째 타자가 백홈, 두번째가 3루 세번째는 2루 네번째가 1루, 원정팀 1점
        int fourthHitter = game.currentHitter();
        PitchResult backHomeResult = doHits(game);
        assertThat(game.firstBaseRunner()).isEqualTo(fourthHitter);
        assertThat(game.secondBaseRunner()).isEqualTo(thirdHitter);
        assertThat(game.thirdBaseRunner()).isEqualTo(secondHitter);
        assertThat(backHomeResult.numberOfRunners()).isEqualTo(1);
        assertThat(backHomeResult.findRunnerByOrder(0)).isEqualTo(firstHitter);
        assertThat(game.awayTeamScore()).isEqualTo(1);
        //공수교대 후 5안타하면 홈팀 2점
        threeOut(game);
        IntStream.range(0, 5).forEach(value -> game.pitch(PlayType.HITS));
        assertThat(game.homeTeamScore()).isEqualTo(2);
        //공수교대 후 5안타하면 원정팀 3점, 홈팀 여전히 2점
        threeOut(game);
        IntStream.range(0, 5).forEach(value -> game.pitch(PlayType.HITS));
        assertThat(game.awayTeamScore()).isEqualTo(3);
        assertThat(game.homeTeamScore()).isEqualTo(2);
    }

    @Test
    @DisplayName("피치의 결과가 홈런인 상황을 테스트합니다")
    void testPitchIsHomeRun() {
        Game game = createGame(GAME_TITLE);
        //1점홈런은 원정팀 1점, 홈팀 0점이어야 하고, 모든 주자는 돌아와야 함. 백홈한 주자는 한명이어야 하고 그건 홈런친 친구여야 함
        int firstHitter = game.currentHitter();
        PitchResult pitchResult = doHomeRun(game);
        assertThat(game.hasFirstBaseRunner()).isFalse();
        assertThat(game.hasSecondBaseRunner()).isFalse();
        assertThat(game.hasThirdBaseRunner()).isFalse();
        assertThat(game.awayTeamScore()).isEqualTo(1);
        assertThat(game.homeTeamScore()).isEqualTo(0);
        assertThat(pitchResult.numberOfRunners()).isEqualTo(1);
        assertThat(pitchResult.findRunnerByOrder(0)).isEqualTo(firstHitter);
        //그 다음, 2루까지 채운다음 홈런치면 원정팀은 4점이어야 함. 백홈한건 홈런친애랑 1,2루에 있던 애들이어야 함
        int secondHitter = game.currentHitter();
        doHits(game);
        int thirdHitter = game.currentHitter();
        doHits(game);
        int fourthHitter = game.currentHitter();
        pitchResult = doHomeRun(game);
        assertThat(game.hasFirstBaseRunner()).isFalse();
        assertThat(game.hasSecondBaseRunner()).isFalse();
        assertThat(game.hasThirdBaseRunner()).isFalse();
        assertThat(game.awayTeamScore()).isEqualTo(4);
        assertThat(game.homeTeamScore()).isEqualTo(0);
        assertThat(pitchResult.numberOfRunners()).isEqualTo(3);
        assertThat(pitchResult.findRunnerByOrder(0)).isEqualTo(secondHitter);
        assertThat(pitchResult.findRunnerByOrder(1)).isEqualTo(thirdHitter);
        assertThat(pitchResult.findRunnerByOrder(2)).isEqualTo(fourthHitter);
        //일단 공수교대한다음, 1,2,3루를 다 채운다
        threeOut(game);
        IntStream.range(0, 3).forEach(value -> game.pitch(PlayType.HITS));
        //만루홈런치면 홈팀은 4점을 얻어야 함. 백홈은 총 4명이어야 함
        pitchResult = doHomeRun(game);
        assertThat(game.awayTeamScore()).isEqualTo(4);
        assertThat(game.homeTeamScore()).isEqualTo(4);
        assertThat(pitchResult.numberOfRunners()).isEqualTo(4);
    }

    @Test
    @DisplayName("이닝 별 점수를 테스트할 수 있어야 합니다")
    void testScoreOfInnings() {
        int[] expectedAwayTeamScores = {1, 0, 4, 0, 1};
        int[] expectedHomeTeamScores = {1, 0, 0, 0, 1};
        //1이닝 초
        Game game = createGame(GAME_TITLE);
        doHomeRun(game);
        //3아웃
        threeOut(game);
        //1이닝 말
        doHomeRun(game);
        //3아웃 3번
        IntStream.range(0, 3).forEach(value -> threeOut(game));
        //3이닝 초
        IntStream.range(0, 3).forEach(value -> game.pitch(PlayType.HITS));
        doHomeRun(game);
        assertThat(game.currentInningNumber()).isEqualTo(3);
        assertThat(game.isTop()).isTrue();
        //3아웃 4번
        IntStream.range(0, 4).forEach(value -> threeOut(game));
        //5이닝 초
        doHomeRun(game);
        assertThat(game.currentInningNumber()).isEqualTo(5);
        assertThat(game.isTop()).isTrue();
        //3아웃
        threeOut(game);
        //5이닝 말
        doHomeRun(game);
        assertThat(game.currentInningNumber()).isEqualTo(5);
        assertThat(game.isTop()).isFalse();
        //이닝 별 점수결과 확인하기
        List<Map<TeamType, Integer>> scoreBoard = game.showScoreBoard();
        IntStream.range(0, scoreBoard.size()).forEach(i -> {
            Map<TeamType, Integer> scoreMap = scoreBoard.get(i);
            int expectedHomeTeamScore = expectedHomeTeamScores[i];
            int expectedAwayTeamScore = expectedAwayTeamScores[i];
            assertThat(scoreMap.get(TeamType.HOME)).isEqualTo(expectedHomeTeamScore);
            assertThat(scoreMap.get(TeamType.AWAY)).isEqualTo(expectedAwayTeamScore);
        });
    }

    @Test
    @DisplayName("이닝 별 경기내용이 기록되어야 합니다")
    void testHistories() {
        Game game = createGame(GAME_TITLE);
        testHistoryOfCurrentInning(game);
    }

    @Test
    @DisplayName("선수별 경기기록을 조회할 수 있어야 합니다")
    void testPlayersRecord() {
        //타순, 타석, 안타, 아웃
        int[][] playerRecords = {
                {0, 1, 0, 1},
                {1, 1, 0, 0},
                {2, 1, 1, 0},
                {3, 1, 1, 0},
                {4, 1, 1, 0},
                {5, 1, 1, 0},
                {6, 1, 1, 0},
                {7, 1, 0, 1},
                {8, 1, 0, 0},
        };
        Game game = createGame(GAME_TITLE);
        testHistoryOfCurrentInning(game);
        List<PlayerParticipatingInGame> awayTeamRecords = game.showPlayerRecords(TeamType.AWAY);
        IntStream.range(0, awayTeamRecords.size()).forEach(i -> {
            int[] currentExpectedRecord = playerRecords[i];
            PlayerParticipatingInGame currentRecord = awayTeamRecords.get(i);
            assertThat(currentRecord.getBatOrder()).isEqualTo(currentExpectedRecord[0]);
            assertThat(currentRecord.getPlateAppearances()).isEqualTo(currentExpectedRecord[1]);
            assertThat(currentRecord.getHitCount()).isEqualTo(currentExpectedRecord[2]);
            assertThat(currentRecord.getOutCount()).isEqualTo(currentExpectedRecord[3]);
        });
    }

    @Test
    @DisplayName("9회말에 동점상황이 아니라면 경기가 종료될 수 있어야 합니다")
    void testEndOfTheGame() {
        Game game = createGame(GAME_TITLE);
        assertThat(game.currentInningNumber()).isEqualTo(1);
        //1회초
        IntStream.range(0, 9).forEach(value -> doHomeRun(game));
        threeOut(game);
        //1회말
        threeOut(game);
        //스킵(2회초)
        IntStream.range(0, 8).forEach(value -> threeOut(game));
        //6회초
        IntStream.range(0, 9).forEach(value -> doHomeRun(game));
        doStrike(game);
        doStrike(game);
        PitchResult pitchResult = doStrike(game);
        assertThat(pitchResult.getGameState()).isEqualTo(GameState.IN_PROGRESS);
        threeStrike(game);
        threeStrike(game);
        assertThat(game.currentInningNumber()).isEqualTo(6);
        //6회말
        IntStream.range(0, 9).forEach(value -> doHomeRun(game));
        threeOut(game);
        //스킵(7회초)
        IntStream.range(0, 5).forEach(value -> threeOut(game));
        //9회말
        assertThat(game.currentInningNumber()).isEqualTo(9);
        assertThat(game.isTop()).isFalse();
        threeStrike(game);
        threeStrike(game);
        doStrike(game);
        doStrike(game);
        pitchResult = doStrike(game);
        assertThat(pitchResult.getGameState()).isEqualTo(GameState.GAME_OVER);
    }

    @Test
    @DisplayName("9회말에 동점상황이면 연장전을 해야 합니다")
    void testExtendedGame() {
        Game game = createGame(GAME_TITLE);
        assertThat(game.currentInningNumber()).isEqualTo(1);
        //1회초
        IntStream.range(0, 2 * 9).forEach(value -> threeOut(game));
        threeOut(game);
        threeStrike(game);
        threeStrike(game);
        doStrike(game);
        doStrike(game);
        PitchResult pitchResult = doStrike(game);
        assertThat(pitchResult.getGameState()).isEqualTo(GameState.IN_PROGRESS);
        //12회말까지 동점이면 그냥 그 상태로 종료해야 함
        IntStream.range(0, 5).forEach(value -> threeOut(game));
        threeStrike(game);
        threeStrike(game);
        doStrike(game);
        doStrike(game);
        pitchResult = doStrike(game);
        assertThat(pitchResult.getGameState()).isEqualTo(GameState.GAME_OVER);
    }

    @Test
    @DisplayName("10회말에 동점상황이 아니면 거기서 끝나야 합니다")
    void testGameEndIn10th() {
        Game game = createGame(GAME_TITLE);
        assertThat(game.currentInningNumber()).isEqualTo(1);
        //1회초
        IntStream.range(0, 2 * 9).forEach(value -> threeOut(game));
        threeOut(game);
        threeStrike(game);
        threeStrike(game);
        doStrike(game);
        doStrike(game);
        PitchResult pitchResult = doStrike(game);
        assertThat(pitchResult.getGameState()).isEqualTo(GameState.IN_PROGRESS);
        //10회초
        doHomeRun(game);
        threeOut(game);
        threeStrike(game);
        threeStrike(game);
        doStrike(game);
        doStrike(game);
        pitchResult = doStrike(game);
        assertThat(pitchResult.getGameState()).isEqualTo(GameState.GAME_OVER);
    }

    private void testHistoryOfCurrentInning(Game game) {
        List<HistoryTestDTO> historyTestDTOS = new ArrayList<>();
        //1회초의 스트라이크 정보가 기록되어야 합니다
        final int pitcher = game.currentPitcher();
        int hitter1 = game.currentHitter();
        game.pitch(PlayType.STRIKE);
        List<History> histories = game.showHistoriesOfCurrentInning();
        //테스트데이터 입력
        historyTestDTOS.add(new HistoryTestDTO(PlayType.STRIKE, 1, 0, pitcher, hitter1, 0));
        //테스트
        testHistories(histories, historyTestDTOS);
        //1회초의 스트라이크 아웃 정보가 기록되어야 합니다
        game.pitch(PlayType.STRIKE);
        game.pitch(PlayType.STRIKE);
        int hitter2 = game.currentHitter();
        game.pitch(PlayType.STRIKE);
        //테스트데이터 입력
        histories = game.showHistoriesOfCurrentInning();
        historyTestDTOS.add(new HistoryTestDTO(PlayType.STRIKE, 2, 0, pitcher, hitter1, 0));
        historyTestDTOS.add(new HistoryTestDTO(PlayType.STRIKE_OUT, 3, 0, pitcher, hitter1, 0));
        historyTestDTOS.add(new HistoryTestDTO(PlayType.STRIKE, 1, 0, pitcher, hitter2, 0));
        //테스트
        testHistories(histories, historyTestDTOS);

        //1회초의 볼 기록도 기록되어야 합니다
        IntStream.range(0, 4).forEach(value -> game.pitch(PlayType.BALL));
        int hitter3 = game.currentHitter();
        doBall(game);
        //테스트데이터 입력
        histories = game.showHistoriesOfCurrentInning();
        historyTestDTOS.add(new HistoryTestDTO(PlayType.BALL, 1, 1, pitcher, hitter2, 0));
        historyTestDTOS.add(new HistoryTestDTO(PlayType.BALL, 1, 2, pitcher, hitter2, 0));
        historyTestDTOS.add(new HistoryTestDTO(PlayType.BALL, 1, 3, pitcher, hitter2, 0));
        historyTestDTOS.add(new HistoryTestDTO(PlayType.FOUR_BALL, 1, 4, pitcher, hitter2, 0));
        historyTestDTOS.add(new HistoryTestDTO(PlayType.BALL, 0, 1, pitcher, hitter3, 0));
        //테스트
        testHistories(histories, historyTestDTOS);

        //1회초의 안타 기록도 기록되어야 합니다
        game.pitch(PlayType.STRIKE);
        doHits(game);
        int hitter4 = game.currentHitter();
        doHits(game);
        int hitter5 = game.currentHitter();
        doHits(game);
        int hitter6 = game.currentHitter();
        doHits(game);
        //테스트데이터 입력
        histories = game.showHistoriesOfCurrentInning();
        historyTestDTOS.add(new HistoryTestDTO(PlayType.STRIKE, 1, 1, pitcher, hitter3, 0));
        historyTestDTOS.add(new HistoryTestDTO(PlayType.HITS, 1, 1, pitcher, hitter3, 0));
        historyTestDTOS.add(new HistoryTestDTO(PlayType.HITS, 0, 0, pitcher, hitter4, 0));
        historyTestDTOS.add(new HistoryTestDTO(PlayType.HITS, 0, 0, pitcher, hitter5, 1));
        historyTestDTOS.add(new HistoryTestDTO(PlayType.HITS, 0, 0, pitcher, hitter6, 1));
        //테스트
        testHistories(histories, historyTestDTOS);

        //1회초의 홈런 기록도 기록되어야 합니다
        int hitter7 = game.currentHitter();
        IntStream.range(0, 3).forEach(ballCount -> {
            doBall(game);
            historyTestDTOS.add(new HistoryTestDTO(PlayType.BALL, 0, ballCount + 1, pitcher, hitter7, 0));
        });
        IntStream.range(0, 2).forEach(strikeCount -> {
            game.pitch(PlayType.STRIKE);
            historyTestDTOS.add(new HistoryTestDTO(PlayType.STRIKE, strikeCount + 1, 3, pitcher, hitter7, 0));
        });
        doHomeRun(game);

        //테스트데이터 입력
        histories = game.showHistoriesOfCurrentInning();
        historyTestDTOS.add(new HistoryTestDTO(PlayType.HOMERUN, 2, 3, pitcher, hitter7, 4));
        testHistories(histories, historyTestDTOS);

        //1회초의 아웃도 기록되어야 합니다
        int hitter8 = game.currentHitter();
        IntStream.range(0, 2).forEach(strikeCount -> {
            doStrike(game);
            historyTestDTOS.add(new HistoryTestDTO(PlayType.STRIKE, strikeCount + 1, 0, pitcher, hitter8, 0));
        });
        doStrike(game);
        historyTestDTOS.add(new HistoryTestDTO(PlayType.STRIKE_OUT, 3, 0, pitcher, hitter8, 0));
        histories = game.showHistoriesOfCurrentInning();
        testHistories(histories, historyTestDTOS);
    }

    private void testHistories(List<History> histories, List<HistoryTestDTO> historyTestDTOS) {
        assertThat(histories.size()).isEqualTo(historyTestDTOS.size());
        for (int i = 0; i < histories.size(); i++) {
            testHistory(histories.get(i), historyTestDTOS.get(i));
        }
    }

    private void testHistory(History history, HistoryTestDTO historyTestDTO) {
        assertThat(history.getPlayType()).isEqualTo(historyTestDTO.playType);
        assertThat(history.getStrikeCount()).isEqualTo(historyTestDTO.strikeCount);
        assertThat(history.getBallCount()).isEqualTo(historyTestDTO.ballCount);
        assertThat(history.getPitcher()).isEqualTo(historyTestDTO.pitcher);
        assertThat(history.getHitter()).isEqualTo(historyTestDTO.hitter);
        assertThat(history.getEarnedScore()).isEqualTo(historyTestDTO.earnedScore);
    }

    private PitchResult doHits(Game game) {
        PitchResult pitchResult = game.pitch(PlayType.HITS);
        gameRepository.save(game);
        return pitchResult;
    }

    private PitchResult doBall(Game game) {
        PitchResult pitchResult = game.pitch(PlayType.BALL);
        gameRepository.save(game);
        return pitchResult;
    }

    private PitchResult doStrike(Game game) {
        PitchResult pitchResult = game.pitch(PlayType.STRIKE);
        gameRepository.save(game);
        return pitchResult;
    }

    private PitchResult doHomeRun(Game game) {
        PitchResult pitchResult = game.pitch(PlayType.HOMERUN);
        gameRepository.save(game);
        return pitchResult;
    }

    private void threeOut(Game game) {
        IntStream.range(0, 3).forEach(value -> threeStrike(game));
    }

    private void threeStrike(Game game) {
        IntStream.range(0, 3).forEach(value -> doStrike(game));
    }

    private Game createGame(String gameTitle) {
        Team teamA = createTeam(A_TEAM_NAME);
        Team teamB = createTeam(B_TEAM_NAME);
        List<Player> aPlayers = createPlayers(A_TEAM_NAME + "-");
        List<Player> bPlayers = createPlayers(B_TEAM_NAME + "-");

        initTeam(teamA, aPlayers);
        initTeam(teamB, bPlayers);

        TeamParticipatingInGame aTeamParticipant = teamA.createParticipantAsHomeTeam();
        TeamParticipatingInGame bTeamParticipant = teamB.createParticipantAsAwayTeam();

        teamA.getPlayers().stream().filter(Player::isHitter).forEach(aTeamParticipant::addPlayer);
        teamB.getPlayers().stream().filter(Player::isHitter).forEach(bTeamParticipant::addPlayer);

        registerPlayersInGame(teamA, aTeamParticipant);
        registerPlayersInGame(teamB, bTeamParticipant);

        Game game = Game.createGame(gameTitle, aTeamParticipant, bTeamParticipant);
        game.initializeGame();
        gameRepository.save(game);
        return findGameById(game.getId());
    }

    private void registerPlayersInGame(Team team, TeamParticipatingInGame teamParticipant) {
        Player pitcher = team.getPlayers()
                .stream()
                .filter(Player::isPitcher)
                .findFirst()
                .orElseThrow(() -> new PlayerNotFoundException(PlayerNotFoundException.FIND_PITCHER_FAILED));
        teamParticipant.addPlayer(pitcher, PitcherPosition.SP);
    }

    private Game findGameById(int gameId) {
        return gameRepository.findById(gameId).orElseThrow(() -> new GameNotFoundException(gameId));
    }

    private void initTeam(Team team, List<Player> players) {
        players.forEach(team::addPlayer);
        teamRepository.save(team);
    }

    private Team createTeam(String teamName) {
        Team team = new Team(teamName);
        return teamRepository.save(team);
    }

    private List<Player> createPlayers(String prefix) {
        List<Player> players = new ArrayList<>();
        players.add(createPitcher(prefix + "pitcher", 1));
        for (int i = 1; i <= 8; i++) {
            players.add(createHitter(prefix + "hitter" + i, i));
        }
        return players;
    }

    private Player createPitcher(String playerName, int uniformNumber) {
        return createPlayer(playerName, uniformNumber, PlayerRole.PITCHER);
    }

    private Player createHitter(String playerName, int uniformNumber) {
        return createPlayer(playerName, uniformNumber, PlayerRole.HITTER);
    }

    private Player createPlayer(String playerName, int uniformNumber, PlayerRole role) {
        return new Player.Builder()
                .playerName(playerName)
                .uniformNumber(uniformNumber)
                .role(role)
                .build();
    }

    private static class HistoryTestDTO {
        public PlayType playType;
        public int strikeCount;
        public int ballCount;
        public int pitcher;
        public int hitter;
        public int earnedScore;

        public HistoryTestDTO(PlayType playType, int strikeCount, int ballCount, int pitcher, int hitter, int earnedScore) {
            this.playType = playType;
            this.strikeCount = strikeCount;
            this.ballCount = ballCount;
            this.pitcher = pitcher;
            this.hitter = hitter;
            this.earnedScore = earnedScore;
        }
    }
}
