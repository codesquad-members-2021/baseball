package com.codesquad.baseball.domain;

import com.codesquad.baseball.exceptions.GameNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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


    private Game createGame(String gameTitle) {
        Team teamA = createTeam(A_TEAM_NAME);
        Team teamB = createTeam(B_TEAM_NAME);
        List<Player> aPlayers = createPlayers(A_TEAM_NAME + "-");
        List<Player> bPlayers = createPlayers(B_TEAM_NAME + "-");

        initTeam(teamA, aPlayers);
        initTeam(teamB, bPlayers);

        TeamParticipatingInGame aTeamParticipant = teamA.createParticipantAsHomeTeam();
        TeamParticipatingInGame bTeamParticipant = teamB.createParticipantAsAwayTeam();

        teamA.getPlayers().forEach(aTeamParticipant::addPlayer);
        teamB.getPlayers().forEach(bTeamParticipant::addPlayer);

        Game game = Game.createGame(gameTitle, aTeamParticipant, bTeamParticipant);

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
