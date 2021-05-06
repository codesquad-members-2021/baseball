package com.codesquad.baseball.domain;

import com.codesquad.baseball.exceptions.GameNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
//@Transactional
class GameRepositoryTest {

    private static final Logger logger = LoggerFactory.getLogger(GameRepositoryTest.class);
    private static final String GAME_TITLE = "GAME 1";
    private static final String A_TEAM_NAME = "aTeam";
    private static final String B_TEAM_NAME = "bTeam";

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamParticipatingInGameRepository teamParticipatingInGameRepository;

    @Test
    @DisplayName("게임을 생성할 수 있어야 하고, 생성된 게임의 제목은 입력한 제목이어야 함")
    void testCreateGame() {
        Game game = createGame(GAME_TITLE);
        logger.debug("game : {}", game);
        game.isSameTitle(GAME_TITLE);
    }

    private Game createGame(String gameTitle) {
        Team teamA = createTeam(A_TEAM_NAME);
        Team teamB = createTeam(B_TEAM_NAME);
        List<Player> aPlayers = createPlayers(A_TEAM_NAME + "-");
        List<Player> bPlayers = createPlayers(B_TEAM_NAME + "-");

        initTeam(teamA, aPlayers);
        initTeam(teamB, bPlayers);

        Game game = Game.createGame(gameTitle, teamA.createParticipantAsHomeTeam(), teamB.createParticipantAsAwayTeam());
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
        for (int i = 2; i <= 10; i++) {
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
