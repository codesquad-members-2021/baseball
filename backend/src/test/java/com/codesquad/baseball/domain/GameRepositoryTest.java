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
        assertThat(game.awayTeamScore()).isEqualTo(1);
        //볼넷 한번 더 맞으면 2번타자는 백홈, 3번타자는 3루, 4번타자는 2루, 5번타자는 1루에 있어야 함
        int fifthHitter = game.currentHitter();
        IntStream.range(0, 3).forEach(value -> game.pitch(PlayType.BALL));
        pitchResult = game.pitch(PlayType.BALL);
        assertThat(game.firstBaseRunner()).isEqualTo(fifthHitter);
        assertThat(game.secondBaseRunner()).isEqualTo(fourthHitter);
        assertThat(game.thirdBaseRunner()).isEqualTo(thirdHitter);
        assertThat(pitchResult.size()).isEqualTo(1);
        assertThat(pitchResult.get(0)).isEqualTo(secondHitter);
        assertThat(game.awayTeamScore()).isEqualTo(2);
        //초에서 말로 교대 후, 4볼을 4번 맞으면 홈팀의 점수가 올라가야 합니다
        IntStream.range(0, 9).forEach(value -> game.pitch(PlayType.STRIKE));
        IntStream.range(0, 16).forEach(value -> game.pitch(PlayType.BALL));
        assertThat(game.homeTeamScore()).isEqualTo(1);
    }

    @Test
    @DisplayName("피치의 결과가 안타인 상황을 테스트합니다")
    void testPitchIsHits() {
        Game game = createGame(GAME_TITLE);
        //1안타후엔 첫번째 타자가 1루에 가있어야 함
        int firstHitter = game.currentHitter();
        game.pitch(PlayType.HITS);
        assertThat(game.firstBaseRunner()).isEqualTo(firstHitter);
        //2안타후엔 첫번째 타자가 2루, 두번째가 1루
        int secondHitter = game.currentHitter();
        game.pitch(PlayType.HITS);
        assertThat(game.firstBaseRunner()).isEqualTo(secondHitter);
        assertThat(game.secondBaseRunner()).isEqualTo(firstHitter);
        //3안타후엔 첫번째 타자가 3루, 두번째가 2루 세번째는 3루
        int thirdHitter = game.currentHitter();
        game.pitch(PlayType.HITS);
        assertThat(game.firstBaseRunner()).isEqualTo(thirdHitter);
        assertThat(game.secondBaseRunner()).isEqualTo(secondHitter);
        assertThat(game.thirdBaseRunner()).isEqualTo(firstHitter);
        //4안타후엔 첫번째 타자가 백홈, 두번째가 3루 세번째는 2루 네번째가 1루, 원정팀 1점
        int fourthHitter = game.currentHitter();
        List<Integer> backHomeResult = game.pitch(PlayType.HITS);
        assertThat(game.firstBaseRunner()).isEqualTo(fourthHitter);
        assertThat(game.secondBaseRunner()).isEqualTo(thirdHitter);
        assertThat(game.thirdBaseRunner()).isEqualTo(secondHitter);
        assertThat(backHomeResult.size()).isEqualTo(1);
        assertThat(backHomeResult.get(0)).isEqualTo(firstHitter);
        assertThat(game.awayTeamScore()).isEqualTo(1);
        //공수교대 후 5안타하면 홈팀 2점
        IntStream.range(0, 9).forEach(value -> game.pitch(PlayType.STRIKE));
        IntStream.range(0, 5).forEach(value -> game.pitch(PlayType.HITS));
        assertThat(game.homeTeamScore()).isEqualTo(2);
        //공수교대 후 5안타하면 원정팀 3점, 홈팀 여전히 2점
        IntStream.range(0, 9).forEach(value -> game.pitch(PlayType.STRIKE));
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
        List<Integer> pitchResult = game.pitch(PlayType.HOMERUN);
        assertThat(game.hasFirstBaseRunner()).isFalse();
        assertThat(game.hasSecondBaseRunner()).isFalse();
        assertThat(game.hasThirdBaseRunner()).isFalse();
        assertThat(game.awayTeamScore()).isEqualTo(1);
        assertThat(game.homeTeamScore()).isEqualTo(0);
        assertThat(pitchResult.size()).isEqualTo(1);
        assertThat(pitchResult.get(0)).isEqualTo(firstHitter);
        //그 다음, 2루까지 채운다음 홈런치면 원정팀은 4점이어야 함. 백홈한건 홈런친애랑 1,2루에 있던 애들이어야 함
        int secondHitter = game.currentHitter();
        game.pitch(PlayType.HITS);
        int thirdHitter = game.currentHitter();
        game.pitch(PlayType.HITS);
        int fourthHitter = game.currentHitter();
        pitchResult = game.pitch(PlayType.HOMERUN);
        assertThat(game.hasFirstBaseRunner()).isFalse();
        assertThat(game.hasSecondBaseRunner()).isFalse();
        assertThat(game.hasThirdBaseRunner()).isFalse();
        assertThat(game.awayTeamScore()).isEqualTo(4);
        assertThat(game.homeTeamScore()).isEqualTo(0);
        assertThat(pitchResult.size()).isEqualTo(3);
        assertThat(pitchResult.get(0)).isEqualTo(secondHitter);
        assertThat(pitchResult.get(1)).isEqualTo(thirdHitter);
        assertThat(pitchResult.get(2)).isEqualTo(fourthHitter);
        //일단 공수교대한다음, 1,2,3루를 다 채운다
        IntStream.range(0, 9).forEach(value -> game.pitch(PlayType.STRIKE));
        IntStream.range(0,3).forEach(value -> game.pitch(PlayType.HITS));
        //만루홈런치면 홈팀은 4점을 얻어야 함. 백홈은 총 4명이어야 함
        pitchResult = game.pitch(PlayType.HOMERUN);
        assertThat(game.awayTeamScore()).isEqualTo(4);
        assertThat(game.homeTeamScore()).isEqualTo(4);
        assertThat(pitchResult.size()).isEqualTo(4);
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
}
