package com.codesquad.baseball.domain;

import com.codesquad.baseball.exceptions.GameNotFoundException;
import com.codesquad.baseball.exceptions.PlayerNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
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
        assertThat(game.isAvailable()).isTrue();
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
        game.pitch(PlayType.STRIKE);
        assertThat(game.getCurrentStrikeCount()).isEqualTo(1);
        game.pitch(PlayType.STRIKE);
        assertThat(game.getCurrentStrikeCount()).isEqualTo(2);
        game.pitch(PlayType.STRIKE);
        assertThat(game.getCurrentStrikeCount()).isEqualTo(0);
        assertThat(game.getCurrentOutCount()).isEqualTo(1);
        for (int i = 0; i < 6; i++) {
            game.pitch(PlayType.STRIKE);
        }
        assertThat(game.currentInningNumber()).isEqualTo(1);
        assertThat(game.isTop()).isEqualTo(false);
        for (int i = 0; i < 9; i++) {
            game.pitch(PlayType.STRIKE);
        }
        assertThat(game.currentInningNumber()).isEqualTo(2);
        assertThat(game.isTop()).isEqualTo(true);
    }

    @Test
    @DisplayName("피치의 결과가 볼인 상황을 테스트합니다")
    void testPitchIsBall() {
        Game game = createGame(GAME_TITLE);
        int firstHitter = game.currentHitter();
        //1회 볼 이후엔 볼카운트 1이어야 함
        game.pitch(PlayType.BALL);
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
        List<Integer> pitchResult = game.pitch(PlayType.BALL);
        assertThat(game.firstBaseRunner()).isEqualTo(fourthHitter);
        assertThat(game.secondBaseRunner()).isEqualTo(thirdHitter);
        assertThat(game.thirdBaseRunner()).isEqualTo(secondHitter);
        assertThat(pitchResult.size()).isEqualTo(1);
        assertThat(pitchResult.get(0)).isEqualTo(firstHitter);
        //볼넷 한번 더 맞으면 2번타자는 백홈, 3번타자는 3루, 4번타자는 2루, 5번타자는 1루에 있어야 함
        int fifthHitter = game.currentHitter();
        IntStream.range(0, 3).forEach(value -> game.pitch(PlayType.BALL));
        pitchResult = game.pitch(PlayType.BALL);
        assertThat(game.firstBaseRunner()).isEqualTo(fifthHitter);
        assertThat(game.secondBaseRunner()).isEqualTo(fourthHitter);
        assertThat(game.thirdBaseRunner()).isEqualTo(thirdHitter);
        assertThat(pitchResult.size()).isEqualTo(1);
        assertThat(pitchResult.get(0)).isEqualTo(secondHitter);
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

        Player aTeamPitcher = teamA.getPlayers()
                .stream()
                .filter(Player::isPitcher)
                .findFirst()
                .orElseThrow(() -> new PlayerNotFoundException(PlayerNotFoundException.FIND_PITCHER_FAILED));
        aTeamParticipant.addPlayer(aTeamPitcher, PitcherPosition.SP);

        Player bTeamPitcher = teamB.getPlayers()
                .stream()
                .filter(Player::isPitcher)
                .findFirst()
                .orElseThrow(() -> new PlayerNotFoundException(PlayerNotFoundException.FIND_PITCHER_FAILED));
        bTeamParticipant.addPlayer(bTeamPitcher, PitcherPosition.SP);

        Game game = Game.createGame(gameTitle, aTeamParticipant, bTeamParticipant);
        game.initializeGame();
        gameRepository.save(game);
        return findGameById(game.getId());
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
}
